package com.example.ze.di

import androidx.fragment.app.Fragment
import com.example.ze.ui.books.BooksFragment
import com.example.ze.ui.discover.DiscoverCategoryFragment
import com.example.ze.ui.discover.DiscoverFragment
import com.example.ze.ui.search.MainSearchFragment
import com.example.ze.ui.settings.SettingsFragment
import com.example.ze.ui.shelves.ShelfWithBooksFragment
import com.example.ze.ui.shelves.ShelvesFragment
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
abstract class FragmentFactoryModule {

    @Binds
    @IntoMap
    @FragmentKey(BooksFragment::class)
    abstract fun bindBooksFragment(fragment: BooksFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(DiscoverFragment::class)
    abstract fun bindDiscoverFragment(fragment: DiscoverFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(DiscoverCategoryFragment::class)
    abstract fun bindDiscoverCategoryFragment(fragment: DiscoverCategoryFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(ShelvesFragment::class)
    abstract fun bindShelvesFragment(fragment: ShelvesFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(MainSearchFragment::class)
    abstract fun bindMainSearchFragment(fragment: MainSearchFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(SettingsFragment::class)
    abstract fun bindSettingsFragment(fragment: SettingsFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(ShelfWithBooksFragment::class)
    abstract fun bindShelfWithBooksFragment(fragment: ShelfWithBooksFragment): Fragment
}