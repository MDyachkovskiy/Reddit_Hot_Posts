package gb.com.reddit_hot_posts.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import gb.com.reddit_hot_posts.databinding.ItemRedditTopicBinding
import gb.com.reddit_hot_posts.model.datasource.remote.dto.RedditPost

class RedditPostAdapter :
    PagingDataAdapter<RedditPost, RedditPostAdapter.ViewHolder>(RedditDiffCallback()) {


    class ViewHolder (
        private val binding: ItemRedditTopicBinding
            ) : RecyclerView.ViewHolder(binding.root) {

                fun bind(post: RedditPost) {
                    with(binding) {
                        postTitle.text = post.title
                        starCount.text = post.score.toString()
                        replayCount.text = post.num_comments.toString()
                    }
                }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = getItem(position)
        if (post != null) holder.bind(post)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRedditTopicBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
}