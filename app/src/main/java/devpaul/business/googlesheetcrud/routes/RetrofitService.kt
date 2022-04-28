package devpaul.business.googlesheetcrud.routes

import devpaul.business.googlesheetcrud.model.Data
import retrofit2.Call
import retrofit2.http.GET


interface RetrofitService {

    @GET("exec")
    fun  getDataList (): Call<Data>

}