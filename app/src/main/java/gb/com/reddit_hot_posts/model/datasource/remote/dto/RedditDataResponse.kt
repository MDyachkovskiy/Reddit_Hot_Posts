package gb.com.reddit_hot_posts.model.datasource.remote.dto

data class RedditDataResponse(
    val after: String = "",
    val before: Any = Any(),
    val children: List<Children> = listOf(),
    val dist: Int = 0,
    val geo_filter: String = "",
    val modhash: String = ""
)