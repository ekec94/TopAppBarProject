// Set up the app bar
//    Learn how to add a Toolbar widget to your activity, and set it as the activity's app bar.
// Add and handle actions
//    Learn how to add actions to the app bar and its overflow menu, and how to respond when users
//    choose those actions.
// Add an up action
//    Learn how to add an Up button to your app bar, so users can navigate back to the app's
//    home screen.
// Use action views and action providers
//    Learn how to use these widgets to provide advanced functionality in your app bar.

package com.example.topappbarproject

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // define app bar - toolbar
        setSupportActionBar(findViewById(R.id.idToolbar))
    }

    // define menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)

        /***************************************************************************************
         *    Author: Lemubit Academy
         *    Date: 2019
         *    Availability: https://youtu.be/3aQgSsLkgJo?si=koX_rDeJftXkNFn1
         ***************************************************************************************/

        // define search view
        val manager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchItem = menu?.findItem(R.id.idSearch)
        val searchView = searchItem?.actionView as SearchView

        searchView.setSearchableInfo(manager.getSearchableInfo(componentName))

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                searchView.setQuery("", false)
                searchItem.collapseActionView()

                // toast message to user of query entered into search view
                Toast.makeText(this@MainActivity,"$query was entered in the search", Toast.LENGTH_LONG).show()

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // does nothing since I did not include anything to actually search for
                return false
            }

        })

        return true
    }


    // actions when an item from the menu is clicked
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.idActivity1 -> {
            Toast.makeText(this,"$item from the menu was selected", Toast.LENGTH_LONG).show()
            true
        }

        R.id.idActivity2 -> {
            val intent = Intent(this, Activity2::class.java)
            startActivity(intent)
            true
        }

        R.id.idActivity3 -> {
            val intent = Intent(this, Activity3::class.java)
            startActivity(intent)
            true
        }

        // from developer.android.com
        else -> {
            // The user's action isn't recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }
}