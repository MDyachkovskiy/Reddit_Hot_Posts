package gb.com.reddit_hot_posts.model.datasource.remote.dto

import com.google.gson.annotations.SerializedName

data class RedditApiResponse(
    @SerializedName("data")
    val redditDataResponse: RedditDataResponse = RedditDataResponse(),
    val kind: String = ""
)