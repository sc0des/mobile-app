package Exercises.inc

import Exercises.inc.data.UnsplashApiProvider
import Exercises.inc.model.UnsplashItem
import Exercises.inc.model.UnsplashSearch
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide() // hides the title bar

        val provider = UnsplashApiProvider()
        provider.fetchImages(this)

        //add provider.fetchPhotoDetails(details, this)

        findViewById<RecyclerView>(R.id.rv_container).apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = MainAdapter(emptyList()) {
                Toast.makeText(context, getString(R.string.main_item_clicked, it), Toast.LENGTH_SHORT).show()
                openDetailsActivity()

            }
        }
    }

    private fun openDetailsActivity() {
        startActivity(Intent(this, DetailsActivity::class.java))
    }

    fun onDataFetchedSuccess(images: List<UnsplashItem>) {
        val adapter = findViewById<RecyclerView>(R.id.rv_container).adapter as MainAdapter
        adapter.submitList(images)
    }

    fun onDataFetchedFailed() {
        Toast.makeText(baseContext, R.string.main_unable_to_fetch_images, Toast.LENGTH_SHORT).show()
    }
}




