package com.alexandreobsilva.a12passosnamauricio.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.alexandreobsilva.a12passosnamauricio.model.data.DiarioDAO

class RoomViewModel(application: Application) : AndroidViewModel(application) {

     lateinit private var diario: DiarioDAO

     
//
//    public PostViewModel(@NonNull Application application) {
//        super(application);
//        postDao = PostsDatabase.getInstance(application).postDao();
//        executorService = Executors.newSingleThreadExecutor();
//    }
//
//    LiveData<List<DiarioDAO>> getAll() {
//        return postDao.findAll();
//    }

}