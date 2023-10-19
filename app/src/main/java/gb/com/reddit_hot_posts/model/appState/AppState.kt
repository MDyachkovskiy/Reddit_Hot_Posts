package gb.com.reddit_hot_posts.model.appState

import androidx.paging.PagingData
import gb.com.reddit_hot_posts.model.datasource.remote.dto.RedditPost

sealed class AppState {
    object Loading : AppState()
    data class Success(val data: PagingData<RedditPost>) : AppState()
    data class Error(val error : Throwable) : AppState()
}