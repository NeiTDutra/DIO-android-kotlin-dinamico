package com.example.dio_kotlin_nav_apare_estilo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val recyclerViewList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.recyclerViewList)
    }

    private val adapter = ContactAdapter()

    private fun bindView() {
        recyclerViewList.adapter = adapter
        recyclerViewList.layoutManager = LinearLayoutManager(this)
    }

    private fun updateList() {
        adapter.updateList(
            arrayListOf(
                Contact(
                    name = "Nei Dutra",
                    phone = "(51)99999-9999",
                    photograph = "img.png"
                ),
                Contact(
                    name = "João Dalton",
                    phone = "(51)99999-9999",
                    photograph = "img.png"
                ),
                Contact(
                    name = "Maria Person",
                    phone = "(51)99999-9999",
                    photograph = "img.png"
                ),
                Contact(
                    name = "Janice Gotler",
                    phone = "(51)99999-9999",
                    photograph = "img.png"
                )
            )
        )
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun initDrawer() {
        val drawerLayout = findViewById<View>(R.id.drawerLayout) as DrawerLayout
        val toolbar = findViewById<Toolbar>(R.id.toolBar)
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_menu)
        initDrawer()
        bindView()
        updateList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.menuItemOne -> {
                showToast("Item de menu one")
                true
            }
            R.id.menuItemTwo -> {
                showToast("Item de menu two")
                true
            }
            R.id.menuItemThree -> {
                showToast("Item de menu three")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}