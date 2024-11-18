package com.example.umc_study_week6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// PropertyAdapter.kt
class PropertyAdapter(private val propertyList: List<Property>) : RecyclerView.Adapter<PropertyAdapter.PropertyViewHolder>() {

    inner class PropertyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val propertyImage: ImageView = itemView.findViewById(R.id.propertyImage)
        val propertyLocation: TextView = itemView.findViewById(R.id.propertyLocation)
        val propertyRating: TextView = itemView.findViewById(R.id.propertyRating)
        val propertyDistance: TextView = itemView.findViewById(R.id.propertyDistance)
        val propertyDate: TextView = itemView.findViewById(R.id.propertyDate)
        val propertyPrice: TextView = itemView.findViewById(R.id.propertyPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.property_item, parent, false)
        return PropertyViewHolder(view)
    }

    override fun onBindViewHolder(holder: PropertyViewHolder, position: Int) {
        val property = propertyList[position]
        holder.propertyImage.setImageResource(property.imageResId)
        holder.propertyLocation.text = property.location
        holder.propertyRating.text = property.rating
        holder.propertyDistance.text = property.distance
        holder.propertyDate.text = property.date
        holder.propertyPrice.text = property.price
    }

    override fun getItemCount(): Int = propertyList.size
}
