package com.example.online_shopping.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.online_shopping.DataClass.LastestArrivals
import com.example.online_shopping.R


class LastestArrivalsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var image:ImageView = itemView.findViewById(R.id.lastest_arrival_image)
    var name:TextView = itemView.findViewById(R.id.lastest_arrival_name)
    var modelNo: TextView = itemView.findViewById(R.id.lastest_arrival_model_no)
    var brandName:TextView = itemView.findViewById(R.id.lastest_arrival_brand)
    var ratingBar:RatingBar = itemView.findViewById(R.id.rating_bar)
    var discountPrice: TextView = itemView.findViewById(R.id.discount_price)
    var price:TextView = itemView.findViewById(R.id.price)
}

class LastestArrivalsAdapter(var lastestArrivalList: ArrayList<LastestArrivals>) : RecyclerView.Adapter<LastestArrivalsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LastestArrivalsViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.lastest_arrival_item,parent,false)
        return LastestArrivalsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lastestArrivalList.size

    }

    override fun onBindViewHolder(holder: LastestArrivalsViewHolder, position: Int) {
        holder.image.setImageResource(lastestArrivalList[position].image)
        holder.name.text = lastestArrivalList[position].name
        holder.modelNo.text = lastestArrivalList[position].modelNo
        holder.brandName.text = lastestArrivalList[position].brandName
        holder.ratingBar.numStars = lastestArrivalList[position].ratingBar
        holder.discountPrice.text = lastestArrivalList[position].discountPrice
        holder.price.text = lastestArrivalList[position].price

    }

}