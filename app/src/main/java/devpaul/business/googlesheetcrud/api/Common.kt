package devpaul.business.googlesheetcrud.api

import devpaul.business.googlesheetcrud.routes.RetrofitService


object Common {

    private  val BASE_URL = "https://script.google.com/macros/s/AKfycbwGQJJsE08xtFB_Sz8xgZSC8W6hBZjRKb43641NUoW5hZFah4b0IbO6FRpuDZRENG9I/"

    val retrofitService : RetrofitService
    get () = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)

}