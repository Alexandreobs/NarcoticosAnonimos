//package com.alexandreobsilva.a12passosnamauricio.viewmodel
////
////import androidx.lifecycle.LiveData
////import androidx.lifecycle.MutableLiveData
////import androidx.lifecycle.ViewModel
////import com.alexandreobsilva.a12passosnamauricio.AppUtil
////import com.google.android.gms.tasks.Task
////import com.google.firebase.auth.AuthResult
////import com.google.firebase.auth.FirebaseAuth
////import io.reactivex.disposables.CompositeDisposable
////import java.security.AccessController.getContext
////
////
////class CadastroViewlModel: ViewModel() {
////
////    private val logado = MutableLiveData<Boolean>()
////    private val errorQualquerCoisa =  MutableLiveData<Throwable>()
////    private val isLoading = MutableLiveData<Boolean>()
////    private val disposable: CompositeDisposable = CompositeDisposable()
////
////    fun registrar(email: String, password: String) {
////        // seta o loading para true para dar feedback ao usuário, que começou o cadastro no firebase
////        isLoading.setValue(true)
////        val firebaseAuth = FirebaseAuth.getInstance()
////        firebaseAuth.createUserWithEmailAndPassword(email, password)
////            .addOnCompleteListener { task: Task<AuthResult> ->
////                AppUtil.salvarIdUsuario(getContext(), FirebaseAuth.getInstance().getCurrentUser().getUid());
////
////                // seta o loading para true para dar feedback ao uauário, que terminou o cadastro
////                isLoading.setValue(false)
////
////                // Se conseguiu se registrar com sucesso vamos para a home
////                if (task.isSuccessful) {
////                    logado.setValue(true)
////                } else {
////
////                    // Se deu algum erro mostramos para o usuário a mensagem
////                    errorQualquerCoisa.setValue(task.exception)
////                }
////            }
////    }
////
////    fun getLogin(): LiveData<Boolean?> {
////        return logado
////    }
////
////    fun liveDataError(): LiveData<Throwable> {
////        return errorQualquerCoisa
////    }
////
////    override fun onCleared() {
////        super.onCleared()
////        disposable.clear()
////    }
////}