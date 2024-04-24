package com.example.pract3xam.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pract3xam.Prueba.Prueba
import com.example.pract3xam.R


class PruebaAdapter(private val xyz: (Prueba) -> Unit) : ListAdapter<Prueba, PruebaAdapter.ViewHolder>(PruebaComparator()){
    class ViewHolder(prueba_item: View, val xyz: (Prueba) -> Unit) : RecyclerView.ViewHolder(prueba_item) {
        val tvCuerpo = prueba_item.findViewById<TextView>(R.id.tvCuerpo)

        fun bind(prueba: Prueba){
            tvCuerpo.text = prueba.Cuerpo

            itemView.setOnClickListener{
                xyz(prueba)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PruebaAdapter.ViewHolder {
        val prueba_item = LayoutInflater.from(parent.context).inflate(R.layout.prueba_item,parent,false)
        return PruebaAdapter.ViewHolder(prueba_item,xyz)
    }

    override fun onBindViewHolder(
        holder: PruebaAdapter.ViewHolder,
        position: Int
    ) {
        val materia_kardex = getItem(position)
        holder.bind(materia_kardex)


    }
    class PruebaComparator : DiffUtil.ItemCallback<Prueba>() {
        override fun areItemsTheSame(oldItem: Prueba, newItem: Prueba): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Prueba, newItem: Prueba): Boolean {
            return oldItem.ID == newItem.ID
        }
    }
}