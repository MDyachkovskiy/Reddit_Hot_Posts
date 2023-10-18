package gb.com.reddit_hot_posts.view


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import gb.com.reddit_hot_posts.databinding.ActivityMainBinding
import gb.com.reddit_hot_posts.view.adapter.RedditPostAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: RedditViewModel by viewModel()
    private lateinit var redditAdapter: RedditPostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
            .also { setContentView(it.root) }

        redditAdapter = RedditPostAdapter()
        binding.mainRecyclerView.adapter = redditAdapter
        binding.mainRecyclerView.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        lifecycleScope.launch {
            viewModel.posts.collectLatest { pagingData ->
                redditAdapter.submitData(pagingData)
            }
        }
    }
}