package gb.com.reddit_hot_posts.model.datasource.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RedditPostsDao {
    @Query("SELECT * FROM RedditPost ORDER BY id")
    fun getAllPosts(): PagingSource<Int, RedditPost>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(posts: List<RedditPost>)

    @Query("DELETE FROM RedditPost")
    suspend fun clearAll()
}