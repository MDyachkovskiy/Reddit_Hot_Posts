package gb.com.reddit_hot_posts.model.datasource.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RedditPostsDao {
    @Query("SELECT * FROM RedditPostEntity ORDER BY id")
    fun getAllPosts(): PagingSource<Int, RedditPostEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(posts: List<RedditPostEntity>)

    @Query("DELETE FROM RedditPostEntity")
    suspend fun clearAll()

    @Query("SELECT * FROM RedditPostEntity LIMIT :limit OFFSET :offset")
    fun getPostsRange(offset: Int, limit: Int): Flow<List<RedditPostEntity>>
}