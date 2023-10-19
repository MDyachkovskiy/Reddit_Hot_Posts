package gb.com.reddit_hot_posts.model.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [RedditPostEntity::class], version = 1, exportSchema = false)
abstract class RedditDatabase : RoomDatabase() {
    abstract fun postsDao(): RedditPostsDao
}