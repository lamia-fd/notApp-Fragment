package com.example.note_app

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Fragment2: Fragment() {
    lateinit var dbh: Helper


    //  lateinit var myRv: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_2, container, false)
        dbh = Helper(requireContext())

        var ev = view.findViewById<EditText>(R.id.editTextT)

        view.findViewById<Button>(R.id.button2).setOnClickListener {

            if(ev.text.isNotBlank()) {
                var updatedNote = ev.text.toString()


                var id1 = any.id

                var updated = dbh.edit(id1, updatedNote)
                if (updated < 1) {
                    Toast.makeText(requireContext(), "not working..", Toast.LENGTH_LONG).show()

                }
                Navigation.findNavController(view).navigate(R.id.action_fragment2_to_fragment1)
            }else{
                Toast.makeText(requireContext(), "write something", Toast.LENGTH_LONG).show()

            }


        }





        return view
    }


}