package devpaul.business.googlesheetcrud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class WriteActivity : AppCompatActivity() {

    var writeProgressBar: ProgressBar? = null
    var edtBookName: EditText? = null
    var edtBookAuthor: EditText? = null
    var edtBookPrice: EditText? = null
    var ratingBar: RatingBar? = null
    var btnSaveToDrive: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        writeProgressBar = findViewById(R.id.writeProgressBar)
        edtBookName = findViewById(R.id.edtBookName)
        edtBookAuthor = findViewById(R.id.edtBookAuthor)
        edtBookPrice = findViewById(R.id.edtBookPrice)
        ratingBar = findViewById(R.id.ratingBar)
        btnSaveToDrive = findViewById(R.id.btnSaveToDrive)

        writeProgressBar?.visibility = View.GONE
        btnSaveToDrive?.setOnClickListener {
            if (edtBookName?.text.toString().isEmpty() or edtBookAuthor?.text.toString()
                    .isEmpty() or edtBookPrice?.text.toString().isEmpty()
                or ratingBar?.rating.toString().isEmpty()) {
                Toast.makeText(this@WriteActivity, "Ingrese la información", Toast.LENGTH_LONG).show()
            } else {
                writeProgressBar?.visibility = View.VISIBLE

                val url = "https://script.google.com/macros/s/AKfycbwGQJJsE08xtFB_Sz8xgZSC8W6hBZjRKb43641NUoW5hZFah4b0IbO6FRpuDZRENG9I/exec"
                val stringRquest = object : StringRequest(
                    Method.POST, url, Response.Listener {
                        Toast.makeText(this@WriteActivity, it.toString(), Toast.LENGTH_LONG).show()
                        writeProgressBar?.visibility = View.GONE
                    },
                    Response.ErrorListener {
                        Toast.makeText(this@WriteActivity, it.toString(), Toast.LENGTH_LONG).show()
                    }){
                    override fun getParams(): MutableMap<String, String> {
                        val params = HashMap<String,String>()
                        params["bookName"] = edtBookName?.text.toString()
                        params["bookAuthor"] = edtBookAuthor?.text.toString()
                        params["bookPrice"] = edtBookPrice?.text.toString()
                        params["bookRating"] = ratingBar?.rating.toString()

                        return params
                    }
                }
                val queue = Volley.newRequestQueue(this@WriteActivity)
                queue.add(stringRquest)
            }
        }

    }


}