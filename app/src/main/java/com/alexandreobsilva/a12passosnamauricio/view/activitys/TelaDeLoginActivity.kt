package com.alexandreobsilva.a12passosnamauricio.view.activitys

//import com.alexandreobsilva.a12passosnamauricio.viewmodel.CadastroViewlModel
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.alexandreobsilva.a12passosnamauricio.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_tela_de_login.*


class TelaDeLoginActivity : AppCompatActivity() {

    private lateinit var googleSignInClient: GoogleSignInClient



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_de_login)

        logar()
        regitrarNovaConta()

        val gso =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso);

        logarComGoogle()


    }

    private fun logarComGoogle() {
        bt_login_google.setOnClickListener {
            signIn()
        }
    }

    private fun signIn() {
        val signInIntent: Intent = googleSignInClient.getSignInIntent()
        startActivityForResult(signInIntent, Context.CONTEXT_INCLUDE_CODE)
    }


    private fun regitrarNovaConta() {
        bt_login_registrar_nova_conta.setOnClickListener {
            openDialog()
        }
    }

    private fun logar() {
        bt_login_logar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("key", "Kotlin")
            startActivity(intent)
        }
    }


    private fun openDialog() {

        val dialoBuilder = AlertDialog.Builder(this).setCancelable(false).create()
        val inlfater: LayoutInflater = this.layoutInflater
        val dialogView = inlfater.inflate(R.layout.dialog_registro_conta, null)
        dialoBuilder.setView(dialogView)

        val sairBtn = dialogView.findViewById<Button>(R.id.bt_dialog_sair)
        val cadastrarBtn = dialogView.findViewById<Button>(R.id.bt_dialog_cadastrar)
        val email1 = dialogView.findViewById<TextInputEditText>(R.id.et_dialog_email_1)
        val emailConfirma =
            dialogView.findViewById<TextInputEditText>(R.id.et_dialog_email_confirma)
        val idade = dialogView.findViewById<TextInputEditText>(R.id.et_dialog_idade)
        val senha1 = dialogView.findViewById<TextInputEditText>(R.id.et_dialog_senha_1)
        val senhaConfimra =
            dialogView.findViewById<TextInputEditText>(R.id.et_dialog_senha_confirma)

        val til_email1 = dialogView.findViewById<TextInputLayout>(R.id.til_dialog_email_1)
        val til_emailConfirma =
            dialogView.findViewById<TextInputLayout>(R.id.til_dialog_email_confirma)
        val til_idade = dialogView.findViewById<TextInputLayout>(R.id.til_dialog_idade)
        val til_senha1 = dialogView.findViewById<TextInputLayout>(R.id.til_dialog_senha_1)
        val til_senhaConfirma =
            dialogView.findViewById<TextInputLayout>(R.id.til_dialog_senha_confirma)

//        lateinit var cadastroViewlModel: CadastroViewlModel


        cadastrarBtn.setOnClickListener {

            var emailS: String = emailConfirma.text.toString()
            var senhaS: String = senhaConfimra.text.toString()

            if (email1.text.toString().isEmpty()) {
                til_email1.isErrorEnabled = true
                til_email1.error = ("Favor preencher o Campo")
            } else {
                til_email1.isErrorEnabled = false
            }

            if (emailConfirma.text.toString().isEmpty()) {
                til_emailConfirma.isErrorEnabled = true
                til_emailConfirma.error = ("Favor preencher o Campo")
            } else {
                til_emailConfirma.isErrorEnabled = false
            }

            if (idade.text.toString().isEmpty()) {
                til_idade.isErrorEnabled = true
                til_idade.error = ("Favor preencher o Campo")
            } else {
                til_idade.isErrorEnabled = false
            }

            if (senha1.text.toString().isEmpty()) {
                til_senha1.isErrorEnabled = true
                til_senha1.error = ("Favor preencher o Campo")
            } else {
                til_senha1.isErrorEnabled = false
            }

            if (senhaConfimra.text.toString().isEmpty()) {
                til_senhaConfirma.isErrorEnabled = true
                til_senhaConfirma.error = ("Favor preencher o Campo")
            } else {
                til_senhaConfirma.isErrorEnabled = false
            }

            if (!emailConfirma.text.toString()
                    .equals(email1.text.toString()) || !senhaConfimra.text.toString()
                    .equals(senha1.text.toString())
            ) {
                til_emailConfirma.isErrorEnabled = true
                til_emailConfirma.error = ("Os E-mails ou senhas estão diferentes")
                til_senhaConfirma.error = ("As senhas ou emails estão diferentes")
            } else {
                til_emailConfirma.isErrorEnabled = false

//                cadastroViewlModel.registrar(emailS, senhaS)
            }


        }


        sairBtn.setOnClickListener {
            dialoBuilder.dismiss()
        }

        dialoBuilder.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialoBuilder.show()


    }

    private fun validaCampos(
        email1: TextInputEditText,
        til_email1: TextInputLayout,
        emailConfirma: TextInputEditText,
        til_emailConfirma: TextInputLayout,
        idade: TextInputEditText,
        til_idade: TextInputLayout,
        senha1: TextInputEditText,
        til_senha1: TextInputLayout,
        senhaConfimra: TextInputEditText,
        til_senhaConfirma: TextInputLayout
    ) {
        if (email1.text.toString().isEmpty()) {
            til_email1.isErrorEnabled = true
            til_email1.error = ("Favor preencher o Campo")
        } else {
            til_email1.isErrorEnabled = false
        }

        if (emailConfirma.text.toString().isEmpty()) {
            til_emailConfirma.isErrorEnabled = true
            til_emailConfirma.error = ("Favor preencher o Campo")
        } else {
            til_emailConfirma.isErrorEnabled = false
        }

        if (idade.text.toString().isEmpty()) {
            til_idade.isErrorEnabled = true
            til_idade.error = ("Favor preencher o Campo")
        } else {
            til_idade.isErrorEnabled = false
        }

        if (senha1.text.toString().isEmpty()) {
            til_senha1.isErrorEnabled = true
            til_senha1.error = ("Favor preencher o Campo")
        } else {
            til_senha1.isErrorEnabled = false
        }

        if (senhaConfimra.text.toString().isEmpty()) {
            til_senhaConfirma.isErrorEnabled = true
            til_senhaConfirma.error = ("Favor preencher o Campo")
        } else {
            til_senhaConfirma.isErrorEnabled = false
        }

        if (!emailConfirma.text.toString()
                .equals(email1.text.toString()) || !senhaConfimra.text.toString()
                .equals(senha1.text.toString())
        ) {
            til_emailConfirma.isErrorEnabled = true
            til_emailConfirma.error = ("Os E-mails ou senhas estão diferentes")
            til_senhaConfirma.error = ("As senhas ou emails estão diferentes")
        } else {
            til_emailConfirma.isErrorEnabled = false
        }
    }

}
