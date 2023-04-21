package com.example.menuprovider.frament

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.menuprovider.R
import com.example.menuprovider.addMenuProvider

class HomeFragment : Fragment(R.layout.home_fragment) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addMenuProvider(
            onCreateMenu = { menu: Menu, menuInflater: MenuInflater ->
                menuInflater.inflate(R.menu.home_toolbar, menu)
            }, onMenuItemSelected = { menu: MenuItem ->
                when (menu.itemId) {
                    R.id.btnFirst -> {
                        Toast.makeText(
                            requireContext(),
                            "Listener from HomeFragment",
                            Toast.LENGTH_SHORT
                        ).show()
                        true
                    }

                    else -> {
                        false
                    }
                }
            }, owner = viewLifecycleOwner
        )
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}