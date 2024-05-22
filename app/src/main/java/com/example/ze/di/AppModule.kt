package com.example.ze.di

import android.app.Application
import android.content.Context
import android.content.Intent
import androidx.room.Room
import com.example.ze.constants.Constants.ABOUT_INTENT
import com.example.ze.constants.Constants.BOOK_DETAILS_INTENT
import com.example.ze.constants.Constants.LOGIN_INTENT
import com.example.ze.constants.Constants.MAIN_INTENT
import com.example.ze.constants.Constants.REGISTER_INTENT
import com.example.ze.roomdb.VVDB
import com.example.ze.ui.books.BookDetailsActivity
import com.example.ze.ui.login.LoginActivity
import com.example.ze.ui.login.RegisterActivity
import com.example.ze.ui.main.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @Named(LOGIN_INTENT)
    fun provideAuthIntent(context: Context): Intent {
        return Intent(context, LoginActivity::class.java)
    }

    @Provides
    @Named(MAIN_INTENT)
    fun provideMainIntent(context: Context): Intent {
        return Intent(context, MainActivity::class.java)
    }

    @Provides
    @Named(REGISTER_INTENT)
    fun provideRegisterIntent(context: Context): Intent {
        return Intent(context, RegisterActivity::class.java)
    }

    @Provides
    @Named(BOOK_DETAILS_INTENT)
    fun provideBookDetailsIntent(context: Context): Intent {
        return Intent(context, BookDetailsActivity::class.java)
    }

    @Provides
    @Singleton
    fun injectLocalBooksDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, VVDB::class.java, "VVDB"
    ).build()

    @Provides
    @Singleton
    fun injectVVDao(database: VVDB) = database.VVDao()

}