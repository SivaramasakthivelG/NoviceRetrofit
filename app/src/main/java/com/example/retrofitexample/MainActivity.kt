package com.example.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.retrofitexample.databinding.ActivityMainBinding
import com.example.retrofitexample.mappers.AlbumService
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofitService = RetrofitInstance.getInstance().create(AlbumService::class.java)

        val liveData: LiveData<Response<Albums>> =
            liveData {
                val response = retrofitService.getAlbumData(0.0)
                emit(response)
            }

        liveData.observe(this, Observer {
            val albumList = it.body()?.listIterator()
            if(albumList != null){
                while (albumList.hasNext()){
                    val item = albumList.next()

                    val data = "Title: ${item.price}"
                    binding.textData.append(data+"\n")
                }
            }
        })

    }
}