package devpaul.business.googlesheetcrud

import android.app.Dialog
import android.app.ProgressDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.util.*
import kotlin.collections.HashMap

class WriteActivity : AppCompatActivity() {

    var edtProductName: EditText? = null
    var edtProductDescription: EditText? = null
    var edtProductSell: EditText? = null
    var edtProductBuy: EditText? = null
    var ratingBar: RatingBar? = null
    var btnSaveToDrive: Button? = null

    var textViewType: TextView? = null
    var arrayList: ArrayList<String>? = null
    var dialog: Dialog? = null

    var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        edtProductName = findViewById(R.id.edtNameProduct)
        edtProductDescription = findViewById(R.id.edtDescriptionProduct)
        edtProductSell = findViewById(R.id.edtProductSell)
        edtProductBuy = findViewById(R.id.edtPriceBuyProduct)
        textViewType = findViewById(R.id.text_view)
        ratingBar = findViewById(R.id.ratingBar)
        btnSaveToDrive = findViewById(R.id.btnSaveToDrive)

        progressDialog = ProgressDialog(this)

        arrayList = ArrayList()
        arrayList!!.add("Tipo 1")
        arrayList!!.add("Tipo 2")
        arrayList!!.add("Tipo 3")
        arrayList!!.add("Tipo 4")

        textViewType?.setOnClickListener {
            dialog = Dialog(this@WriteActivity)
            dialog!!.setContentView(R.layout.dialog_searchable_spinner)
            dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog!!.show()
            val editText = dialog!!.findViewById<EditText>(R.id.edit_text)
            val listView =
                dialog!!.findViewById<ListView>(R.id.list_view)
            val adapter =
                ArrayAdapter(this@WriteActivity, android.R.layout.simple_list_item_1, arrayList!!)
            listView.adapter = adapter
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    charSequence: CharSequence,
                    i: Int,
                    i1: Int,
                    i2: Int) {

                }

                override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                    adapter.filter.filter(charSequence)
                }

                override fun afterTextChanged(editable: Editable) {}
            })
            listView.onItemClickListener =
                OnItemClickListener { adapterview: AdapterView<*>?, view1: View?, i: Int, l: Long ->
                    textViewType?.text = adapter.getItem(i)
                    dialog?.dismiss()
                }
        }

        btnSaveToDrive?.setOnClickListener {
            sendData()
        }

    }

    private fun sendData() {

        val textName = edtProductName?.text.toString()
        val textDescription = edtProductDescription?.text.toString()
        val textSell = edtProductSell?.text.toString()
        val textBuy = edtProductBuy?.text.toString()
        val textType = textViewType?.text.toString()

        progressDialog!!.show()
        progressDialog!!.setContentView(R.layout.progress_dialog)
        Objects.requireNonNull(progressDialog!!.window)?.setBackgroundDrawableResource(android.R.color.transparent)

        if (validarFormulario(textName, textDescription, textSell, textBuy, textType)) {
            if (ratingBar?.rating.toString().isEmpty()) {
                Toast.makeText(this, "RatingBar no seleccionado", Toast.LENGTH_SHORT).show()
                progressDialog?.dismiss()
            } else {
                val url =
                    "https://script.google.com/macros/s/AKfycbwGQJJsE08xtFB_Sz8xgZSC8W6hBZjRKb43641NUoW5hZFah4b0IbO6FRpuDZRENG9I/exec"
                val stringRquest = object : StringRequest(
                    Method.POST, url, Response.Listener {
                        Toast.makeText(this@WriteActivity, it.toString(), Toast.LENGTH_LONG).show()
                        progressDialog?.dismiss()
                        cleanData()
                    },
                    Response.ErrorListener {
                        Toast.makeText(this@WriteActivity, it.toString(), Toast.LENGTH_LONG).show()
                    }) {
                    override fun getParams(): MutableMap<String, String> {
                        val params = HashMap<String, String>()
                        params["productName"] = edtProductName?.text.toString()
                        params["productDescription"] = edtProductDescription?.text.toString()
                        params["productSell"] = edtProductSell?.text.toString()
                        params["productBuy"] = edtProductBuy?.text.toString()
                        params["productType"] = textViewType?.text.toString()
                        params["productRating"] = ratingBar?.rating.toString()

                        return params
                    }
                }
                val queue = Volley.newRequestQueue(this@WriteActivity)
                queue.add(stringRquest)

            }
        }else{
            progressDialog?.dismiss()
        }

    }

    private fun validarFormulario(
        nameProduct: String,
        descriptionProduct: String,
        sellProduct: String,
        buyProduct: String,
        typeProduct: String,
    ): Boolean {
        if (nameProduct.isEmpty()) {
            Toast.makeText(this, "Nombre del Producto vacío", Toast.LENGTH_SHORT).show()
            return false
        }
        if (descriptionProduct.isEmpty()) {
            Toast.makeText(this, "Descripción del producto vacío", Toast.LENGTH_SHORT)
                .show()
            return false
        }
        if (sellProduct.isEmpty()) {
            Toast.makeText(this, "Precio de venta vacío", Toast.LENGTH_SHORT).show()
            return false
        }
        if (buyProduct.isEmpty()) {
            Toast.makeText(this, "Precio de compra vacío", Toast.LENGTH_SHORT).show()
            return false
        }
        if (typeProduct == "Tipo de Producto") {
            Toast.makeText(this, "Debes seleccionar un tipo", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun cleanData(){

        edtProductName?.setText("")
        edtProductDescription?.setText("")
        edtProductSell?.setText("")
        edtProductBuy?.setText("")
        textViewType?.text = "Tipo de Producto"
        ratingBar?.rating = 0F
    }


}