package gb.com.reddit_hot_posts.app

import android.app.Application
import gb.com.reddit_hot_posts.di.apiModule
import gb.com.reddit_hot_posts.di.databaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(apiModule, databaseModule)
        }
    }
}