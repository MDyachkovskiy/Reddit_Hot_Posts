package gb.com.reddit_hot_posts.view

import androidx.paging.PagingSource
import androidx.paging.PagingState
import gb.com.reddit_hot_posts.model.datasource.remote.RedditApi
import gb.com.reddit_hot_posts.model.datasource.remote.dto.RedditPost

class RedditPagingSource(
    private val redditApi: RedditApi
) :PagingSource<String, RedditPost>() {
    override fun getRefreshKey(state: PagingState<String, RedditPost>): String? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.nextKey
        }
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, RedditPost> {
        return try {
            val response = redditApi.getTopPosts(params.key, params.loadSize)
            val posts = response.redditDataResponse.children.map {
                it.redditPost
            }

            LoadResult.Page (
                data = posts,
                prevKey = null,
                nextKey = response.redditDataResponse.after
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}