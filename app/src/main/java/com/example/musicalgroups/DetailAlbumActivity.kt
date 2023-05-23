package com.example.musicalgroups

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.musicalgroups.data.DataGenerator
import com.example.musicalgroups.data.Album

class DetailAlbumActivity : AppCompatActivity() {

    private var isReadyPromotions: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_album_detail)

        val albumTitle = intent.getSerializableExtra("album") as Album
        val discos = DataGenerator.getDetailAlbum(albumTitle)
        val album = discos.find { it.titulo == albumTitle.titulo }
        supportActionBar?.title = albumTitle.titulo

        if (album != null) {
            val albumImageView: ImageView = findViewById(R.id.img_album)
            val albumTitleTextView: TextView = findViewById(R.id.name_album)
            val groupNameTextView: TextView = findViewById(R.id.txt_name_group_album)
            val discographyTextView: TextView = findViewById(R.id.name_discography)
            val publicationDateTextView: TextView = findViewById(R.id.date_publication)

            val drawableResourceId = getDrawableResourceId(this, album.caratula)
            albumImageView.setImageResource(drawableResourceId)
            albumTitleTextView.text = album.artista
            groupNameTextView.text = album.titulo
            discographyTextView.text = album.selloDiscografico
            publicationDateTextView.text = album.añoLanzamiento.toString()
            isReadyPromotions = true
        }
    }

    private fun getDrawableResourceId(context: Context, resourceName: String): Int {
        val resourceId =
            context.resources.getIdentifier(resourceName, "drawable", context.packageName)
        return if (resourceId != 0) resourceId else R.drawable.img_no_available
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.share_menu, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        val item = menu.findItem(R.id.share_item)
        item.isVisible = isReadyPromotions
        return true
    }
}

