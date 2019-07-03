package fr.legrand.daifen.application.data

import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        if(response.code() == 302){
            return response
        }else{
            return response
        }
    }

}