package com.example.musicalgroups.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musicalgroups.DetailAlbumActivity
import com.example.musicalgroups.R
import com.example.musicalgroups.data.Album

class AlbumsAdapter(private val albums: List<Album>) :
    RecyclerView.Adapter<AlbumsAdapter.AlbumViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.album_item, parent, false)
        return AlbumViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = albums[position]
        holder.bind(album)
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    inner class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val albumImageView: ImageView = itemView.findViewById(R.id.img_album_icon)
        private val albumTitleTextView: TextView = itemView.findViewById(R.id.txt_name_album)

        fun bind(album: Album) {
            albumImageView.setImageResource(
                getDrawableResourceId(
                    itemView.context,
                    album.caratula
                )
            )

            albumTitleTextView.text = album.titulo

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailAlbumActivity::class.java)
                intent.putExtra("album", album)
                itemView.context.startActivity(intent)
            }
        }

        private fun getDrawableResourceId(context: Context, resourceName: String): Int {
            val resourceId =
                context.resources.getIdentifier(resourceName, "drawable", context.packageName)
            return if (resourceId != 0) resourceId else R.drawable.img_no_available
        }
    }
}
