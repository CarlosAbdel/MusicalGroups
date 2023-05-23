package com.example.musicalgroups

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class AddAlbumFragment : Fragment() {

    class AddAlbumFragment : Fragment() {
        private lateinit var etTitle: EditText
        private lateinit var etRecordLabel: EditText
        private lateinit var etReleaseYear: EditText
        private lateinit var btnUploadImage: Button

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val view = inflater.inflate(R.layout.fragment_add_album, container, false)

            etTitle = view.findViewById(R.id.et_title)
            etRecordLabel = view.findViewById(R.id.et_record_label)
            etReleaseYear = view.findViewById(R.id.et_release_year)
            btnUploadImage = view.findViewById(R.id.btn_upload_image)

            btnUploadImage.setOnClickListener {
                val title = etTitle.text.toString()
                val recordLabel = etRecordLabel.text.toString()
                val releaseYear = etReleaseYear.text.toString().toInt()
            }
            return view
        }
    }
}
