package com.example.musicalgroups

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicalgroups.adapter.GroupsAdapter
import com.example.musicalgroups.data.Album
import com.example.musicalgroups.data.Artista
import com.example.musicalgroups.data.DataGenerator

class MainActivity : ComponentActivity() {
    private lateinit var groupsAdapter: GroupsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_groups)

        val lstGroups: RecyclerView = findViewById(R.id.lst_groups)
        val artist = mutableListOf<Artista>()
        val discos = mutableListOf<Album>()

        DataGenerator.addArtist(artist)
        DataGenerator.addDisc(discos)

        groupsAdapter = GroupsAdapter(artist)

        lstGroups.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = groupsAdapter
        }
    }
}

