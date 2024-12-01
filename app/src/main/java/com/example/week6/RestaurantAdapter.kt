package com.example.week6

class RestaurantAdapter(private val items: List<Restaurant>) : RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.restaurantImage)
        val nameTextView: TextView = itemView.findViewById(R.id.restaurantName)
        val ratingTextView: TextView = itemView.findViewById(R.id.restaurantRating)
        val deliveryFeeTextView: TextView = itemView.findViewById(R.id.deliveryFee)
        val minOrderTextView: TextView = itemView.findViewById(R.id.minOrder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.imageView.setImageResource(item.imageResId)
        holder.nameTextView.text = item.name
        holder.ratingTextView.text = "⭐ ${item.rating}"
        holder.deliveryFeeTextView.text = item.deliveryFee
        holder.minOrderTextView.text = item.minOrder
    }

    override fun getItemCount(): Int = items.size
}
