package devpaul.business.googlesheetcrud

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import devpaul.business.googlesheetcrud.adapter.MyDataAdapter
import devpaul.business.googlesheetcrud.api.Common
import devpaul.business.googlesheetcrud.model.Data
import devpaul.business.googlesheetcrud.model.Items
import devpaul.business.googlesheetcrud.routes.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*



class ReadActivity : AppCompatActivity() {

    var TAG = "DataList"

    lateinit var  mService : RetrofitService
    lateinit var  adapter : MyDataAdapter
    var recyclerViewData: RecyclerView? = null
    var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read)

        mService = Common.retrofitService
        recyclerViewData = findViewById(R.id.recyclerView)
        recyclerViewData?.layoutManager = LinearLayoutManager(this)
        recyclerViewData?.setHasFixedSize(true)
        progressDialog = ProgressDialog(this)
        getDataList()
    }

    private fun getDataList() {
        progressDialog!!.show()
        progressDialog!!.setContentView(R.layout.progress_dialog)
        Objects.requireNonNull(progressDialog!!.window)?.setBackgroundDrawableResource(android.R.color.transparent)

        mService.getDataList().enqueue(object : Callback<Data?> {
            override fun onResponse(call: Call<Data?>, response: Response<Data?>) {
                val jsonResponse: Data? = response.body()
          /*      adapter = MyDataAdapter(this@ReadActivity, response.body() as MutableList<Items?>)*/
                val data2 = jsonResponse?.items as MutableList<Items>
              /*  val data = ArrayList(listOf(jsonResponse?.items))*/
                adapter = MyDataAdapter(this@ReadActivity, data2)
                recyclerViewData?.adapter = adapter

                progressDialog?.dismiss()
            }

            override fun onFailure(call: Call<Data?>, t: Throwable) {
                progressDialog?.dismiss()
                Log.d(TAG,t.message!!)
            }
        })

    }

}