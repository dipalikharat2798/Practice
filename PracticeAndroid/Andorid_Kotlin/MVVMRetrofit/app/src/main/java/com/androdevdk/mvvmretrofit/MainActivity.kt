package com.androdevdk.mvvmretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.androdevdk.mvvmretrofit.api.QuoteService
import com.androdevdk.mvvmretrofit.api.RetrofitHelper
import com.androdevdk.mvvmretrofit.repository.QuoteRepository
import com.androdevdk.mvvmretrofit.viewmodel.MainViewModel
import com.androdevdk.mvvmretrofit.viewmodel.MainViewModelFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     //   val quotesAPI = RetrofitHelper.getInstance().create(QuotesAPI::class.java)

       // val quoteService=RetrofitHelper.getInstance().create(QuoteService::class.java)
       // val repository=QuoteRepository(quoteService)
        val repository=(application as QuoteApplication).quoteRepository
        mainViewModel=ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this, {
           // Log.d("TAG", "onCreate: "+it.results.count().toString())
            Toast.makeText(this, it.results.count().toString(), Toast.LENGTH_LONG).show()

            val result=it.results
//            result.forEach {
//                Log.d("TAG", "onCreate: "+it.content.toString())
//            }
        })
//        GlobalScope.launch {
//            val result=quotesAPI.getQuotes(1)
//            if (result != null){
//               val quoteList = result.body()
//                if (quoteList != null) {
//                    quoteList.results.forEach{
//                        Log.d("TAG", "onCreate: "+it.content)
//                    }
//                }
//            }
//        }
    }
}