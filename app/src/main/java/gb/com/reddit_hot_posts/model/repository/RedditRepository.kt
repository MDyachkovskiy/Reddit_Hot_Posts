package gb.com.reddit_hot_posts.model.repository

import androidx.paging.PagingData
import gb.com.reddit_hot_posts.model.datasource.remote.dto.RedditPost
import kotlinx.coroutines.flow.Flow

interface RedditRepository {
    fun getPostsStream(): Flow<PagingData<RedditPost>>
}