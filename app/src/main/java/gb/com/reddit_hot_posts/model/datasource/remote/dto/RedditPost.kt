package gb.com.reddit_hot_posts.model.datasource.remote.dto

data class RedditPost(
    val created: Double = 0.0,
    val num_comments: Int = 0,
    val score: Int = 0,
    val title: String = "",
)