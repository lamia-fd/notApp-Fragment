package com.example.note_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class Fragment1 : Fragment() {
    lateinit var tv1: TextView
    lateinit var dbh :Helper
    lateinit var button: Button
    lateinit var myRv: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_1, container, false)

        tv1 = view.findViewById(R.id.tv1)
// val layout = view.findViewById<ConstraintLayout>(R.id.layout)
        dbh = Helper(requireContext())
        myRv = view.findViewById(R.id.rvMain)
     //   layout.setBackgroundResource(R.drawable.background)
        button = view.findViewById(R.id.button)
       // myRv.adapter = recycler(this,dbh.retrieves())
      //  myRv.layoutManager = LinearLayoutManager(requireContext())
update()
       // view.findViewById<RecyclerView>(R.id.rvMain).setOnClickListener{
       //     Navigation.findNavController(view).navigate(R.id.action_fragment1_to_fragment2)
      //  }
        button.setOnClickListener {
            if(tv1.text.isNotBlank()) {
                addNote()
            }else{
                Toast.makeText(requireContext(), "write something", Toast.LENGTH_LONG).show()
            }
        }

        return view
    }



    fun addNote(){
        var note=tv1.text.toString()
        val status = dbh.savedata(note)
        if(status>0) {
            Toast.makeText(requireContext(), "data is served", Toast.LENGTH_LONG).show()
        }else if (status<0){
            Toast.makeText(requireContext(), "fail to serve", Toast.LENGTH_LONG).show()

        }
        /////update the notes to the recycler view
      //  myRv.adapter = recycler(this,dbh.retrieves())
      //  myRv.layoutManager = LinearLayoutManager(requireContext())
update()
    }

    fun deleteNote(id:Int){
        var deleted=dbh.deleteNote(id)
        if (deleted<1){
            Toast.makeText(requireContext(),"not working..",Toast.LENGTH_LONG).show()

        }
       // myRv.adapter = recycler(this,dbh.retrieves())
       // myRv.layoutManager = LinearLayoutManager(requireContext())
    update()

    }

    fun update()
    {
        myRv.adapter = recycler(this,dbh.retrieves())
        myRv.layoutManager = LinearLayoutManager(requireContext())
        myRv.adapter?.notifyDataSetChanged()

    }

}