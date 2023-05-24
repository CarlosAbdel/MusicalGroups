package com.example.musicalgroups

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.musicalgroups.data.Album
import com.example.musicalgroups.data.DataGenerator

class DetailAlbumActivity : AppCompatActivity() {

    private var isReadyPromotions: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_detail)

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
        val shareButton: ImageButton = findViewById(R.id.btn_share)
        shareButton.setOnClickListener {
            sendEmail()
        }
    }

    private fun sendEmail() {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:direccion@ext.live.u-tad.es")
        intent.putExtra(Intent.EXTRA_SUBJECT, "Información del disco")
        intent.putExtra(Intent.EXTRA_TEXT, getAlbumDetails())
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun getAlbumDetails(): String {
        val albumTitleTextView: TextView = findViewById(R.id.name_album)
        val groupNameTextView: TextView = findViewById(R.id.txt_name_group_album)
        val discographyTextView: TextView = findViewById(R.id.name_discography)
        val publicationDateTextView: TextView = findViewById(R.id.date_publication)

        val albumTitle = albumTitleTextView.text.toString()
        val groupName = groupNameTextView.text.toString()
        val discography = discographyTextView.text.toString()
        val publicationDate = publicationDateTextView.text.toString()

        return "Detalles del álbum:\n\n" +
                "Título: $albumTitle\n" +
                "Grupo: $groupName\n" +
                "Discografía: $discography\n" +
                "Fecha de publicación: $publicationDate"
    }

    private fun getDrawableResourceId(context: Context, resourceName: String): Int {
        val resourceId =
            context.resources.getIdentifier(resourceName, "drawable", context.packageName)
        return if (resourceId != 0) resourceId else R.drawable.img_no_available
    }
}

