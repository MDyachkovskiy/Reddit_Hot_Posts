package gb.com.reddit_hot_posts.view

import androidx.paging.PagingSource
import androidx.paging.PagingState
import gb.com.reddit_hot_posts.model.datasource.local.RedditDatabase
import gb.com.reddit_hot_posts.model.datasource.remote.RedditApi
import gb.com.reddit_hot_posts.model.datasource.remote.dto.RedditPost
import gb.com.reddit_hot_posts.utils.toDbModel
import gb.com.reddit_hot_posts.utils.toDomainModel
import kotlinx.coroutines.flow.first

class RedditPagingSource(
    private val redditApi: RedditApi,
    private val database: RedditDatabase
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

            database.postsDao().insertAll(response.redditDataResponse.children.map{
                it.redditPost.toDbModel()
            })

            val start = params.key?.toIntOrNull() ?: 0
            val end = start + params.loadSize
            val postsFromDb = database.postsDao().getPostsRange(start, end).first().map {
                it.toDomainModel()
            }

            LoadResult.Page (
                data = postsFromDb,
                prevKey = null,
                nextKey = response.redditDataResponse.after
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}