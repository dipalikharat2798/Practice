package com.androdevdk.mvvmretrofit.repository

import com.androdevdk.mvvmretrofit.models.QuoteList

sealed class Response() {
    class Loading:Response()
    class Success(val quoteList: QuoteList):Response()
    class Error(val errorMessage:String):Response()
}