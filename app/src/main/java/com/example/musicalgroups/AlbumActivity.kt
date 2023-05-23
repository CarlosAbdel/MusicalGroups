package com.example.musicalgroups

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
        setContentView(R.layout.fragment_select_album)

        val lstAlbums: RecyclerView = findViewById(R.id.lst_albums)
        val artist = intent.getSerializableExtra("artista") as Artista
        val albums = getAlbums(artist)

        albumsAdapter = AlbumsAdapter(albums)

        lstAlbums.apply {
            layoutManager = LinearLayoutManager(this@AlbumActivity)
            adapter = albumsAdapter

//            val btnAddAlbum: Button = findViewById(R.id.btn_new_album)
//
//            // Agrega un evento de clic al botón para abrir la vista FragmentNewAlbum
//            btnAddAlbum.setOnClickListener {
//                val fragmentNewAlbum = AddAlbumFragment()
//
//                // Obtén el administrador de fragmentos y realiza la transacción para mostrar FragmentNewAlbum
//                supportFragmentManager.beginTransaction()
//                    .replace(R.id.container_layout, fragmentNewAlbum)
//                    .addToBackStack(null)
//                    .commit()
//
//            }
        }
    }
}
