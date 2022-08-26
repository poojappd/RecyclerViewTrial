package com.example.recyclerviewtrial

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(val dataSet: MutableList<Person>?, val context: Context) : RecyclerView.Adapter<RVAdapter.PersonViewHolder>() {
                            //our list view
    class PersonViewHolder(view:View):RecyclerView.ViewHolder(view){
        val textViewName : TextView
        val textViewLastName:TextView
        val textViewGender :TextView
        val textViewNationality:TextView

        init {


            textViewName = view.findViewById(R.id.textViewName);

            textViewLastName = view.findViewById (R.id.textViewLastName);
             textViewGender =  view.findViewById (R.id.textViewGender);
             textViewNationality = view.findViewById (R.id.textViewNationality);
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_person_row_item, parent, false)
        return PersonViewHolder(view)

    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = dataSet?.get(position)

        holder.textViewName.setText(person?.name)
        holder.textViewLastName.setText(person?.lastName)
        holder.textViewNationality.setText(person?.nationality)
        holder.textViewGender.text =
            if (person?.gender === Gender.MALE) "Male" else "Female"
    }

    override fun getItemCount(): Int{
        return dataSet!!.size
    }
}