package com.example.online_shopping.Adapter

import com.example.online_shopping.DataClass.ChooseByCountry


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.online_shopping.R


class ChooseByCountryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var image:ImageView = itemView.findViewById(R.id.choose_by_country_image)

}

class ChooseByCountryAdapter(var chooseByCountryList: ArrayList<ChooseByCountry>) : RecyclerView.Adapter<ChooseByCountryViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChooseByCountryViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.choose_by_country,parent,false)
        return ChooseByCountryViewHolder(view)
    }

    override fun getItemCount(): Int {
       return chooseByCountryList.size
    }

    override fun onBindViewHolder(holder: ChooseByCountryViewHolder, position: Int) {
        holder.image.setImageResource(chooseByCountryList[position].countryImage)
    }


}