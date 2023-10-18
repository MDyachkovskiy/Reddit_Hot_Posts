package gb.com.reddit_hot_posts.model.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import gb.com.reddit_hot_posts.model.datasource.remote.RedditApi
import gb.com.reddit_hot_posts.model.datasource.remote.dto.RedditPost
import gb.com.reddit_hot_posts.view.RedditPagingSource
import kotlinx.coroutines.flow.Flow

class RedditRepositoryImpl(
    private val reddit: RedditApi
) : RedditRepository {

    override fun getPostsStream(): Flow<PagingData<RedditPost>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {RedditPagingSource(reddit)}
        ).flow
    }
}