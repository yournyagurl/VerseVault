package com.example.ze.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ze.constants.Constants.randomWordList
import com.example.ze.constants.Response
import com.example.ze.model.googlebooksmodel.DataModel
import com.example.ze.model.googlebooksmodel.GoogleApiBooks
import com.example.ze.repository.GoogleBooksRepositoryInterface
import com.example.ze.repository.LocalBooksRepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainSearchViewModel @Inject constructor(
    private val googleBooksRepository: GoogleBooksRepositoryInterface,
    private val booksRepository: LocalBooksRepositoryInterface
) : ViewModel() {

    //LocalBook Works

    private val _currentLocalBookList = MutableLiveData<List<DataModel.LocalBook>>()
    val currentLocalBookList: LiveData<List<DataModel.LocalBook>>
        get() = _currentLocalBookList

    private val _searchLocalBookList = MutableLiveData<List<DataModel.LocalBook>>()
    val searchLocalBookList: LiveData<List<DataModel.LocalBook>>
        get() = _searchLocalBookList

    fun searchLocalBooks(searchString: String) = viewModelScope.launch {
        _searchLocalBookList.value = booksRepository.searchLocalBooks(searchString)
    }

    fun setCurrentLocalBookList(bookList: List<DataModel.LocalBook>) {
        _currentLocalBookList.value = bookList
    }

    fun insertBook(localBook: DataModel.LocalBook) = viewModelScope.launch {
        booksRepository.insert(localBook)
    }

    fun deleteBookById(id: String) = viewModelScope.launch {
        booksRepository.deleteBookById(id)
    }

    //GoogleBook Works

    private val _currentList = MutableLiveData<List<DataModel.GoogleBookItem>>()
    val currentList: LiveData<List<DataModel.GoogleBookItem>>
        get() = _currentList

    private val _searchBooksResponse = MutableLiveData<Response<GoogleApiBooks>>()
    val searchBooksResponse: LiveData<Response<GoogleApiBooks>>
        get() = _searchBooksResponse

    private val _randomBooksResponse = MutableLiveData<Response<GoogleApiBooks>>()
    val randomBooksResponse: LiveData<Response<GoogleApiBooks>>
        get() = _randomBooksResponse

    fun searchBooksFromApi(searchQuery: String) = viewModelScope.launch {
        googleBooksRepository.searchBooksFromApi(searchQuery).collectLatest { response ->
            _searchBooksResponse.postValue(response)
        }
    }

    fun randomBooksFromApi() = viewModelScope.launch {
        googleBooksRepository.searchBooksFromApi(randomWordList.random())
            .collectLatest { response ->
                _randomBooksResponse.postValue(response)
            }
    }

    fun setCurrentList(bookList: List<DataModel.GoogleBookItem>) {
        _currentList.postValue(bookList)
    }

}