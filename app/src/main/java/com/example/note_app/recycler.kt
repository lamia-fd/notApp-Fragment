package com.example.note_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class recycler (val frag: Fragment1,private val UserInput: ArrayList<noteInfo>): RecyclerView.Adapter<recycler.ItemHolder>() {



    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val userinput=UserInput[position]
        holder.itemView.apply {
            tvUserNote.text =userinput.note
            imageButton4.setOnClickListener {

                any.id=userinput.id
                frag.findNavController().navigate(R.id.action_fragment1_to_fragment2)

                //activity.openDialog(userinput.id)

            }
            imageButton5.setOnClickListener {
              //  activity.deleteNote(userinput.id)
                frag.deleteNote(userinput.id)
            }

        }
    }

    override fun getItemCount()= UserInput.size


}