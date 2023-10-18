package gb.com.reddit_hot_posts.model.datasource.remote.dto

import com.google.gson.annotations.SerializedName

data class Children(
    @SerializedName("data")
    val redditPost: RedditPost = RedditPost(),
    val kind: String = ""
)