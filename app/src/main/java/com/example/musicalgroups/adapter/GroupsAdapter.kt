package com.example.musicalgroups.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musicalgroups.AlbumActivity
import com.example.musicalgroups.R
import com.example.musicalgroups.data.Artista

class GroupsAdapter(private val artistas: List<Artista>) :
    RecyclerView.Adapter<GroupsAdapter.GruposViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GruposViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_group, parent, false)
        return GruposViewHolder(view)
    }

    override fun onBindViewHolder(holder: GruposViewHolder, position: Int) {
        val artista = artistas[position]
        holder.bind(artista)
    }

    override fun getItemCount(): Int {
        return artistas.size
    }

    inner class GruposViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val grupoIconImageView: ImageView = itemView.findViewById(R.id.img_group_icon)
        private val nombreGrupoTextView: TextView = itemView.findViewById(R.id.txt_name_group)

        fun bind(artista: Artista) {
            grupoIconImageView.setImageResource(
                getDrawableResourceId(
                    itemView.context,
                    artista.caratula
                )
            )
            nombreGrupoTextView.text = artista.nombre
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, AlbumActivity::class.java)
                intent.putExtra("artista", artista)
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



