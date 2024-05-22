package com.example.ze.di

import android.content.Context
import com.example.ze.constants.Constants.GOOGLE_BOOKS_BASE_URL
import com.example.ze.constants.Constants.OPEN_LIBRARY_BASE_URL
import com.example.ze.constants.Util
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.ze.R
import com.example.ze.repository.FirebaseRepositoryImpl
import com.example.ze.repository.FirebaseRepositoryInterface
import com.example.ze.repository.GoogleBooksRepositoryImpl
import com.example.ze.repository.GoogleBooksRepositoryInterface
import com.example.ze.repository.LocalBooksRepositoryImpl
import com.example.ze.repository.LocalBooksRepositoryInterface
import com.example.ze.repository.OpenLibRepositoryImpl
import com.example.ze.repository.OpenLibRepositoryInterface
import com.example.ze.repository.ShelfRepositoryImpl
import com.example.ze.repository.ShelfRepositoryInterface
import com.example.ze.roomdb.VVDao
import com.example.ze.service.GoogleBooksApiService
import com.example.ze.service.OpenLibraryApiService
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): GoogleBooksApiService {
        return Retrofit.Builder()
            .baseUrl(GOOGLE_BOOKS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GoogleBooksApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideOpenLibraryRetrofit(): OpenLibraryApiService {
        return Retrofit.Builder()
            .baseUrl(OPEN_LIBRARY_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OpenLibraryApiService::class.java)
    }

    @Provides
    fun provideFirebaseAuthInstance() = FirebaseAuth.getInstance()

    @Provides
    fun provideFirebaseFirestore() = FirebaseFirestore.getInstance()

    @Provides
    fun provideFirebaseStorage() = FirebaseStorage.getInstance()

    @Singleton
    @Provides
    fun provideAuthRepository(
        auth: FirebaseAuth,
        db: FirebaseFirestore,
        storage: FirebaseStorage
    ) = FirebaseRepositoryImpl(auth, db, storage) as FirebaseRepositoryInterface

    @Singleton
    @Provides
    fun provideApiBooksRepository(googleBooksApiService: GoogleBooksApiService) =
        GoogleBooksRepositoryImpl(googleBooksApiService) as GoogleBooksRepositoryInterface

    @Singleton
    @Provides
    fun provideLocalBooksRepository(VVDao: VVDao) =
        LocalBooksRepositoryImpl(VVDao) as LocalBooksRepositoryInterface

    @Singleton
    @Provides
    fun provideOpenLibRepository(openLibraryApiService: OpenLibraryApiService) =
        OpenLibRepositoryImpl(openLibraryApiService) as OpenLibRepositoryInterface

    @Singleton
    @Provides
    fun provideShelfRepository(VVDao: VVDao) =
        ShelfRepositoryImpl(VVDao) as ShelfRepositoryInterface

    @Singleton
    @Provides
    fun injectGlide(@ApplicationContext context: Context) = Glide
        .with(context)
        .setDefaultRequestOptions(
            RequestOptions()
                .placeholder(Util.progressDrawable(context))
                .error(R.drawable.ic_placeholder_book_icon)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        )

}