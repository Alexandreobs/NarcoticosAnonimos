package view.activitys

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.alexandreobsilva.a12passosnamauricio.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import view.fragments.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        loadFragment(MenuDeTextosFragment())
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.btm_menu_de_botoes -> {
                    loadFragment(MenuDeTextosFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.doze_conceitos -> {
                   // loadFragment(DozeconceitosFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.doze_tradicoes -> {
                  //  loadFragment(DozetradicoesFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.btn_oracoes -> {
                   // loadFragment(OrarFragment())
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false

        }

    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
