package com.example.musicalgroups

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.musicalgroups.data.Album
import com.example.musicalgroups.data.DataGenerator

class AddAlbumActivity : AppCompatActivity() {
    private lateinit var etTitle: EditText
    private lateinit var etRecordLabel: EditText
    private lateinit var etReleaseYear: EditText
    private lateinit var btnAddAlbum: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_album)
        val nombreArtista = intent.getStringExtra("nombreArtista")


        etTitle = findViewById(R.id.et_title)
        etRecordLabel = findViewById(R.id.et_record_label)
        etReleaseYear = findViewById(R.id.et_release_year)
        btnAddAlbum = findViewById(R.id.btn_add_album)

        btnAddAlbum.setOnClickListener {
            val title = etTitle.text.toString()
            val recordLabel = etRecordLabel.text.toString()
            val releaseYear = etReleaseYear.text.toString().toInt()
            val album = Album(title, nombreArtista.toString(), recordLabel, releaseYear, 0, "")

            DataGenerator.addAlbum(album)

            etTitle.text.clear()
            etRecordLabel.text.clear()
            etReleaseYear.text.clear()

            Toast.makeText(this, "Álbum agregado correctamente", Toast.LENGTH_SHORT).show()
            val resultIntent = Intent()
            resultIntent.putExtra("album", album)
            setResult(Activity.RESULT_OK, resultIntent)

            val intent = Intent(this@AddAlbumActivity, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }
}

