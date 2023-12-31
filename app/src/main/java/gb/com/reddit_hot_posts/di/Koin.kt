package gb.com.reddit_hot_posts.di

import androidx.room.Room
import gb.com.reddit_hot_posts.model.datasource.local.RedditDatabase
import gb.com.reddit_hot_posts.model.datasource.remote.RedditApi
import gb.com.reddit_hot_posts.model.repository.RedditRepository
import gb.com.reddit_hot_posts.model.repository.RedditRepositoryImpl
import gb.com.reddit_hot_posts.view.RedditViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://www.reddit.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(RedditApi::class.java) }

    single<RedditRepository> { RedditRepositoryImpl(get(), get()) }
}

val databaseModule = module {
    single {
        Room.databaseBuilder(get(), RedditDatabase::class.java, "reddit_database").build()
    }

    single { get<RedditDatabase>().postsDao() }
}

val appModule = module {
    viewModel { RedditViewModel(get()) }
}