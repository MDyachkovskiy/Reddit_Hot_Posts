package gb.com.reddit_hot_posts.model.datasource.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RedditPost (
    @PrimaryKey
    val id: String,
    val title: String,
    val created: Double,
    val num_comments: Int,
    val score: Int
    )