package com.example.get_set_data_firebase

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.get_set_data_firebase.databinding.Activity2Binding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import android.content.Intent


class Activity2 : AppCompatActivity() {


    private lateinit var binding : Activity2Binding
    private lateinit var dbRef : DatabaseReference
    private lateinit var activity: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        activity = findViewById(R.id.button4)

        activity.setOnClickListener{
            openActivity()
        }


        binding.readdataBtn.setOnClickListener {

            val empName : String = binding.etusername.text.toString()
            if  (empName.isNotEmpty()){

                readData(empName)

            }else{

                Toast.makeText(this,"PLease enter the Username",Toast.LENGTH_SHORT).show()

            }

        }

    }

    private fun readData(empName: String) {


        dbRef = FirebaseDatabase.getInstance().getReference("Employees")
        dbRef.child(empName).get().addOnSuccessListener {


            if (it.exists()){

                val empname = it.child("empName").value
                val emphours = it.child("empHours").value
                val empsalary = it.child("empSal").value
                Toast.makeText(this,"Successfuly Read",Toast.LENGTH_SHORT).show()
                binding.etusername.text.clear()
                binding.tvFirstName.text = empname.toString()
                binding.tvLastName.text = emphours.toString()
                binding.tvAge.text = empsalary.toString()

            }else{

                Toast.makeText(this,"User Doesn't Exist",Toast.LENGTH_SHORT).show()

            }

        }.addOnFailureListener{

            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()


        }
    }

    private fun openActivity() {
        val intent = Intent(this,MainActivity::class.java);
        startActivity(intent);
    }


}

