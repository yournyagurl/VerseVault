package com.example.ze.repository

import android.net.Uri
import com.example.ze.constants.Response
import com.example.ze.model.googlebooksmodel.DataModel
import com.example.ze.roomdb.entities.BookShelfCrossRef
import com.example.ze.roomdb.entities.LocalShelf
import com.google.firebase.auth.AuthCredential

interface FirebaseRepositoryInterface {

    suspend fun signInWithEmailPassword(email: String, password: String): Response<Boolean>

    suspend fun signInAnonymous(): Response<Boolean>

    suspend fun anonymousToPermanent(credential: AuthCredential): Response<Boolean>

    suspend fun signUpWithEmailPassword(email: String, password: String): Response<Boolean>

    suspend fun createUserInFirestore(): Response<Boolean>

    suspend fun deleteUserBookFromFirestore(bookId: String): Response<Boolean>

    suspend fun deleteUserCrossRefFromFirestore(crossRefId: String): Response<Boolean>

    suspend fun deleteUserShelfFromFirestore(shelfId: String): Response<Boolean>

    suspend fun deleteUserPermanently(): Response<Boolean>

    suspend fun downloadUserBooksFromFirestore(): Response<List<DataModel.LocalBook>>

    suspend fun downloadUserShelvesFromFirestore(): Response<List<LocalShelf>>

    suspend fun downloadUserCrossRefFromFirestore(): Response<List<BookShelfCrossRef>>

    suspend fun uploadCustomBookCoverToFirestore(uri: Uri): Response<Uri>

    suspend fun uploadUserBooksToFirestore(localBook: DataModel.LocalBook): Response<Boolean>

    suspend fun uploadCustomShelfCoverToFirestore(uri: Uri): Response<Uri>

    suspend fun uploadUserShelvesToFirestore(shelf: LocalShelf): Response<Boolean>

    suspend fun uploadUserCrossRefToFirestore(bookShelfCrossRef: BookShelfCrossRef): Response<Boolean>

    suspend fun signOut(): Response<Boolean>

    suspend fun reAuthUser(credential: AuthCredential): Response<Boolean>

    suspend fun changeUserEmail(email: String): Response<Boolean>

    suspend fun changeUserPassword(password: String): Response<Boolean>

    suspend fun sendResetPassword(email: String): Response<Boolean>

}