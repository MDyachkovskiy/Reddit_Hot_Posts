package gb.com.reddit_hot_posts.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import gb.com.reddit_hot_posts.model.datasource.remote.dto.RedditPost
import gb.com.reddit_hot_posts.model.repository.RedditRepository
import kotlinx.coroutines.flow.Flow

class RedditViewModel(
    private val repository: RedditRepository
) : ViewModel() {

    val posts: Flow<PagingData<RedditPost>> = repository.getPostsStream().cachedIn(viewModelScope)
}