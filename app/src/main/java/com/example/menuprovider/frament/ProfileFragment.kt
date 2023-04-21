package com.example.menuprovider.frament

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.menuprovider.R
import com.example.menuprovider.addMenuProvider

class ProfileFragment : Fragment(R.layout.profile_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addMenuProvider(
            onCreateMenu = { menu: Menu, menuInflater: MenuInflater ->
                menuInflater.inflate(R.menu.profile_toolbar, menu)
            }, onMenuItemSelected = { menu: MenuItem ->
                when (menu.itemId) {
                    R.id.btnFirst -> {
                        Toast.makeText(
                            requireContext(),
                            "Listener from ProfileFragment",
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
    }
}