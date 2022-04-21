package com.alexandreobsilva.a12passosnamauricio.view.activitys

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.alexandreobsilva.a12passosnamauricio.R
import com.alexandreobsilva.a12passosnamauricio.view.fragments.DiarioFragment
import com.alexandreobsilva.a12passosnamauricio.view.fragments.MenuDeTextosFragment
import com.alexandreobsilva.a12passosnamauricio.view.fragments.PaginaDeLinksFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(MenuDeTextosFragment())
        colocaToolBar()
        menuDeNavegação()
        //  supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    private fun menuDeNavegação() {
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.btm_menu_de_botoes -> {
                    loadFragment(MenuDeTextosFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.btn_linksUteis -> {
                    loadFragment(PaginaDeLinksFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.btn_diario -> {
                    loadFragment(DiarioFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.btn_calculadora -> {
                    val intent = Intent(this, CalculadoraActivity::class.java)
                    startActivity(intent)
                }
            }
            false

        }
    }

    private fun colocaToolBar() {
//        toolbar = findViewById(R.id.my_toolbar)
//        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
