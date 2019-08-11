package com.zabochen.fugaapp.di

import com.zabochen.fugaapp.ui.bookmark.BookmarkAdviceFragment
import com.zabochen.fugaapp.ui.random.RandomAdviceFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {

    fun inject(randomAdviceFragment: RandomAdviceFragment)
    fun inject(bookmarkAdviceFragment: BookmarkAdviceFragment)

}