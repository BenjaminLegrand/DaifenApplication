package fr.legrand.daifen.application.data.manager.api

import fr.legrand.daifen.application.data.entity.remote.PigeonListResponse
import fr.legrand.daifen.application.data.entity.remote.PigeonResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("pigeonnier/")
    fun getPigeonList(@Query("page") page: Int): Single<PigeonListResponse>

    @FormUrlEncoded
    @POST("site/login.php")
    fun login(@Field("nom") username: String, @Field("pass") password: String, @Field("mem") memorize: String): Single<Response<Unit>>

    @GET("pigeonnier/pigeon.php")
    fun getPigeon(@Query("id") id: Int): Single<PigeonResponse>
}