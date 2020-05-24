package com.alexandreobsilva.a12passosnamauricio.view.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alexandreobsilva.a12passosnamauricio.R
import kotlinx.android.synthetic.main.activity_tela_de_login.*

class TelaDeLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_de_login)

        bt_login_logar.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("key", "Kotlin")
            startActivity(intent)
        }
    }
}
