package gb.com.reddit_hot_posts.model.repository

import gb.com.reddit_hot_posts.model.datasource.remote.RedditApi
import gb.com.reddit_hot_posts.model.datasource.remote.dto.RedditApiResponse

class RedditRepository(
    private val reddit: RedditApi
) {

    suspend fun fetchTopPosts(after: String?, limit: Int): RedditApiResponse {
        return reddit.getTopPosts(after, limit)
    }

}