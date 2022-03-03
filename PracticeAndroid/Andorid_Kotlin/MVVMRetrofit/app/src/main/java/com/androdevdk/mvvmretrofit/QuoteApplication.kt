package com.androdevdk.mvvmretrofit

import android.app.Application
import androidx.constraintlayout.widget.ConstraintSet
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.androdevdk.mvvmretrofit.api.QuoteService
import com.androdevdk.mvvmretrofit.api.RetrofitHelper
import com.androdevdk.mvvmretrofit.db.QuoteDatabase
import com.androdevdk.mvvmretrofit.repository.QuoteRepository
import com.androdevdk.mvvmretrofit.worker.QuoteWorker
import java.util.concurrent.TimeUnit

class QuoteApplication : Application() {
    lateinit var quoteRepository: QuoteRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
        setupWorker()
    }

    private fun setupWorker() {
        val constraint = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
        val workerRequest=PeriodicWorkRequest.Builder(QuoteWorker::class.java,15,TimeUnit.MINUTES)
            .setConstraints(constraint)
            .build()
        WorkManager.getInstance(this).enqueue(workerRequest)
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository = QuoteRepository(quoteService, database,applicationContext)
    }
}