package com.example.musicalgroups

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicalgroups.adapter.AlbumsAdapter
import com.example.musicalgroups.data.Artista
import com.example.musicalgroups.data.DataGenerator.getAlbums

class AlbumActivity : AppCompatActivity() {
    private lateinit var albumsAdapter: AlbumsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_album)

        val lstAlbums: RecyclerView = findViewById(R.id.lst_albums)
        val btnNewAlbum: Button = findViewById(R.id.btn_new_album)
        val artist = intent.getSerializableExtra("artista") as Artista
        val albums = getAlbums(artist)

        albumsAdapter = AlbumsAdapter(albums)

        lstAlbums.apply {
            layoutManager = LinearLayoutManager(this@AlbumActivity)
            adapter = albumsAdapter
        }

        btnNewAlbum.setOnClickListener {
            val artist = intent.getSerializableExtra("artista") as Artista
            val intent = Intent(this@AlbumActivity, AddAlbumActivity::class.java)
            intent.putExtra("nombreArtista", artist.nombre)
            startActivity(intent)
        }
    }
}
