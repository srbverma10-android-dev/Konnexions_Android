package com.sourabhverma.newsappbykonnexions

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class ViewModelMainActivity(app: Application) : AndroidViewModel(app) {

    private val repository: MainActivityRepo = MainActivityRepo()

    private var item : MutableLiveData<NewsData> = MutableLiveData()

    fun getAllNews() : MutableLiveData<NewsData>{
        repository.getData {
            if(it!=null){
                item.postValue(it)
            }
        }
        return item
    }
}