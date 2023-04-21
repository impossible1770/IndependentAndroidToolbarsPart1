package com.example.menuprovider

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

fun Fragment.addMenuProvider(
    onPrepareMenu: ((menu: Menu) -> Unit)? = null,
    onCreateMenu: ((menu: Menu, menuInflater: MenuInflater) -> Unit)? = null,
    onMenuItemSelected: ((menu: MenuItem) -> Boolean)? = null,
    onMenuClosed: ((menu: Menu) -> Unit)? = null,
    owner: LifecycleOwner,
) {
    (requireActivity() as? MenuHost)?.addMenuProvider(object : MenuProvider {

        override fun onPrepareMenu(menu: Menu) {
            onPrepareMenu?.invoke(menu)
        }

        override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
            onCreateMenu?.invoke(menu, menuInflater)
        }

        override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
            return onMenuItemSelected?.invoke(menuItem) ?: true
        }

        override fun onMenuClosed(menu: Menu) {
            onMenuClosed?.invoke(menu)
        }

    }, owner,)
}