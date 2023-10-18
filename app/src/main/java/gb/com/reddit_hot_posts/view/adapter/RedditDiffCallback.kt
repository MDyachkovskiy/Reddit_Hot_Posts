package gb.com.reddit_hot_posts.view.adapter

import androidx.recyclerview.widget.DiffUtil
import gb.com.reddit_hot_posts.model.datasource.remote.dto.RedditPost

class RedditDiffCallback : DiffUtil.ItemCallback<RedditPost>() {
    override fun areItemsTheSame(oldItem: RedditPost, newItem: RedditPost): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: RedditPost, newItem: RedditPost): Boolean {
        return oldItem == newItem
    }
}