package com.example.introductiontofragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


private const val POSITION = "POSITION"

class FragmentImage : Fragment() {
    private var position: Int? = null
    val images = arrayOf(R.drawable.img1, R.drawable.img2, R.drawable.img3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            position = it.getInt(POSITION)
        }



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageView: ImageView = view.findViewById(R.id.imgView)
        imageView.setImageResource(images[position!!])
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(position: Int) =
            FragmentImage().apply {
                arguments = Bundle().apply {
                    putInt(POSITION, position)
                }
            }
    }
}