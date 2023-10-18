package gb.com.reddit_hot_posts.model.datasource.remote

import gb.com.reddit_hot_posts.model.datasource.remote.dto.RedditApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RedditApi {
    @GET("top.json")
    suspend fun getTopPosts(
        @Query("after") after: String?,
        @Query("limit") limit: Int
    ) : RedditApiResponse
}