package com.example.get_set_data_firebase
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
//import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import android.widget.Button
import android.widget.EditText
import android.widget.MediaController
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.get_set_data_firebase.fragments.GetAllFragment
import com.example.get_set_data_firebase.fragments.InsertFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.DatabaseReference
import android.widget.Toast.makeText as makeText



class MainActivity : AppCompatActivity() {

//
    private val insertFragment = InsertFragment()
    private val getAllFragment = GetAllFragment()

    private lateinit var insert: Button
    private lateinit var empname: EditText
    private lateinit var emphours: EditText
    private lateinit var empsal: EditText
    private lateinit var bottom_navigation: BottomNavigationView
    private lateinit var activity: Button


    private lateinit var dbRef: DatabaseReference



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(getAllFragment)
        replaceFragment(insertFragment)

        bottom_navigation = findViewById(R.id.bottom_navigation)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_baseline_present -> replaceFragment(getAllFragment)
                R.id.ic_baseline -> replaceFragment(insertFragment)
            }
            true

        }

//        val button = findViewById<ListView>(R.id.button);
        insert = findViewById(R.id.button1)
        empname = findViewById(R.id.editText)
        emphours = findViewById(R.id.editText2)
        empsal = findViewById(R.id.editText3)
        activity = findViewById(R.id.button2)

        activity.setOnClickListener{
           openActivity()
            }

        dbRef = FirebaseDatabase.getInstance().getReference("Employees")

        insert.setOnClickListener {
            saveEmployeeData()
            empname.text.clear()
            emphours.text.clear()
            empsal.text.clear()

        }

    }

    private fun openActivity() {
        val intent = Intent(this,Activity2::class.java);
        startActivity(intent);
    }

    private fun saveEmployeeData() {
        val empName = empname.text.toString()
        val empHours = emphours.text.toString()
        val empSal = empsal.text.toString()

        if (empName.isEmpty()){
            empname.error = "Please enter data"
        }

        if (empHours.isEmpty()){
            emphours.error = "Please enter data"
        }

        if (empSal.isEmpty()){
            empsal.error = "Please enter data"
        }

        val empId = dbRef.push().key!!

        val employee = Employee(empId, empName, empHours, empSal)

        dbRef.child(empId).setValue(employee)

    }
    private fun replaceFragment(fragment: Fragment){

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()

    }
}
