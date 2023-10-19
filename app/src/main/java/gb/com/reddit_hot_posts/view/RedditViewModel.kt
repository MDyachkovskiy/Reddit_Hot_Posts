package gb.com.reddit_hot_posts.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gb.com.reddit_hot_posts.model.appState.AppState
import gb.com.reddit_hot_posts.model.repository.RedditRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class RedditViewModel(
    private val repository: RedditRepository
) : ViewModel() {

    private val _state = MutableStateFlow<AppState>(AppState.Loading)
    val state: StateFlow<AppState> = _state

    fun fetchPosts() {
        viewModelScope.launch {
            repository.getPostsStream()
                .onStart {
                    _state.emit(AppState.Loading)
                }
                .catch { e ->
                    _state.emit(AppState.Error(e))
                }
                .collect { pagingData ->
                    _state.emit(AppState.Success(pagingData))
                }
        }
    }
}