package com.nhulox.dosv.fragments

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var btnFragment: Button

    private lateinit var fragment1: Fragment1
    private lateinit var fragment2: Fragment2
    private lateinit var fragment3: Fragment3

    private var ACTUAL_FRAGMENT = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFragment = findViewById(R.id.btnFragment)

        fragment1 = Fragment1()
        fragment2 = Fragment2()
        fragment3 = Fragment3()

        btnFragment.setOnClickListener{
            insertFragment(it)
        }

    }

    private fun insertFragment(view: View){
        //Toast.makeText(this, "Changing Fragments", Toast.LENGTH_LONG).show()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        if (ACTUAL_FRAGMENT == 0){
            transaction.replace(R.id.container, fragment1)
            transaction.addToBackStack(null)
            transaction.commit()
            ACTUAL_FRAGMENT++
        }

        else if (ACTUAL_FRAGMENT == 1){
            transaction.replace(R.id.container, fragment2)
            transaction.addToBackStack(null)
            transaction.commit()
            ACTUAL_FRAGMENT++
        }

        else if (ACTUAL_FRAGMENT == 2){
            transaction.replace(R.id.container, fragment3)
            transaction.addToBackStack(null)
            transaction.commit()
            ACTUAL_FRAGMENT = 0
        }

    }
}
