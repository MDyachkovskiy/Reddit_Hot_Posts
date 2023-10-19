package gb.com.reddit_hot_posts.utils

import gb.com.reddit_hot_posts.model.datasource.local.RedditPostEntity
import gb.com.reddit_hot_posts.model.datasource.remote.dto.RedditPost

fun RedditPost.toDbModel(): RedditPostEntity {
    return RedditPostEntity(
        id = this.id,
        title = this.title,
        created = this.created,
        num_comments = this.num_comments,
        score = this.score
    )
}

fun RedditPostEntity.toDomainModel(): RedditPost {
    return RedditPost(
        id = this.id,
        title = this.title,
        created = this.created,
        num_comments = this.num_comments,
        score = this.score
    )
}