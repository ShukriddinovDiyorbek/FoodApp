package uz.pdp.foodapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.pdp.foodapp.R
import uz.pdp.foodapp.model.Meal

class CustomAdapter(var items: ArrayList<Meal>,var listener: CutomListener) : RecyclerView.Adapter<CustomAdapter.VH>() {

    inner class VH(item: View) : RecyclerView.ViewHolder(item){
        val meal_name: TextView
        val item_linear: LinearLayout
        init {
            meal_name = item.findViewById(R.id.meal_name)
            item_linear = item.findViewById(R.id.item_linear)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv,parent,false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val meal = items[position]
        holder.meal_name.setText(meal.name)

        holder.item_linear.setOnClickListener {
            listener.onClick(position, meal)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    public interface CutomListener{
        fun onClick(position: Int, item: Meal)
    }
}