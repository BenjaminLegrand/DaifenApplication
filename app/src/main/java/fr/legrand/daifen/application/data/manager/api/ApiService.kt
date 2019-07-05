package fr.legrand.daifen.application.data.manager.api

import fr.legrand.daifen.application.data.entity.remote.PigeonListResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("pigeonnier/")
    fun getPigeonList(): Single<PigeonListResponse>

    @FormUrlEncoded
    @POST("site/login.php")
    fun login(@Field("nom") username: String, @Field("pass") password: String): Single<Response<Unit>>
}