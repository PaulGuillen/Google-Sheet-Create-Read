package devpaul.business.googlesheetcrud.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import devpaul.business.googlesheetcrud.R
import devpaul.business.googlesheetcrud.model.Items


class MyDataAdapter(private val context: Context, private val dataList: MutableList<Items>) :
    RecyclerView.Adapter<MyDataAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemVIew = LayoutInflater.from(context).inflate(R.layout.item_data, parent, false)
        return MyViewHolder(itemVIew)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        holder.txt_nombre.text = dataList[position].productName
        holder.txt_description.text = dataList[position].productDescription
        holder.txt_sell.text = dataList[position].productSell.toString()
        holder.txt_buy.text = dataList[position].productBuy.toString()
        holder.txt_type.text = dataList[position].productType
        holder.txt_rating.text = dataList[position].productRating

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var txt_nombre: TextView
        var txt_description: TextView
        var txt_sell: TextView
        var txt_buy: TextView
        var txt_type: TextView
        var txt_rating: TextView


        init {

            txt_nombre = itemView.findViewById(R.id.nombre_producto)
            txt_description = itemView.findViewById(R.id.descripcion_producto)
            txt_sell = itemView.findViewById(R.id.producto_venta)
            txt_buy = itemView.findViewById(R.id.producto_compra)
            txt_type = itemView.findViewById(R.id.producto_tipo)
            txt_rating = itemView.findViewById(R.id.producto_rating)
        }
    }
}