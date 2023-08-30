package com.example.bottomnavview

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.bottomnavview.databinding.FragmentLoginBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class LoginFragment : Fragment() {
    private  lateinit var binding : FragmentLoginBinding
    private lateinit var sharedPreference : SharedPreferences
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var dpReference: DatabaseReference
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater,container,false)
        initView()
        events()
        return binding.root
    }

    private fun events() {
        binding.loginBtn.setOnClickListener {
            dpReference.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        val name = snapshot.child("name").getValue(String::class.java)
                        val password = snapshot.child("password").getValue(String::class.java)
                        if (binding.emailOrName.text.toString() == name && binding.pass.text.toString() == password) {
                            val editor = sharedPreference.edit()
                            editor.putString("loginstatus", "logedin")
                            editor.apply()
                            findNavController().navigate(R.id.go_to_home)
                        } else {
                            Toast.makeText(
                                requireContext(),
                                "Check Your Name or Password",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.i("firebaseException ", error.message)
                }

            })
        }
    }


    private fun initView() {
        //initialization
        dpReference = FirebaseDatabase.getInstance().getReference("Authentication")
         bottomNavigationView = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        sharedPreference = requireActivity().getSharedPreferences("mySharedPreference", MODE_PRIVATE)
        if(sharedPreference.getString("loginstatus","") == "logedin"){
            findNavController().popBackStack()
            findNavController().navigate(R.id.go_to_home)
        }
    }

    override fun onResume() {
        super.onResume()
        bottomNavigationView.visibility = View.GONE
    }

    override fun onPause() {
        super.onPause()
        bottomNavigationView.visibility = View.VISIBLE
    }

}