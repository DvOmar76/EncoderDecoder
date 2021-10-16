package com.example.encoderdecoder

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val arr=ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rcMain.adapter=RVAdapter(arr)
        rcMain.layoutManager=LinearLayoutManager(this)
        btnEncode.setOnClickListener {
                encode(edEncode.text.toString())
        }
        btnDecode.setOnClickListener {
            encode(edDecode.text.toString())
        }
    }
    fun encode(text: String){
        var output=""

        for (i in text){
           output+=proses(i)
        }

        if (text.isNotEmpty()){
            arr.add(output)
            rcMain.adapter?.notifyDataSetChanged()
        }else{
            Toast.makeText(applicationContext, "ed is empty", Toast.LENGTH_SHORT).show()
        }

    }
    fun proses(char:Char) :Char{
        val alphabet = "abcdefghijklmnopqrstuvwxyz";
        var output='p'
        if (char.isLetter()){
            var position = alphabet.indexOf(char.lowercase())
            if (position>-1){
                position-=13
                if (position<0){
                    output=alphabet.get(position+26)
                }else{
                    output=alphabet.get(position)
                }
            }
        }
        else{
            output=char
        }
        if (char.isUpperCase()){
            return output.uppercaseChar()
        }else{
            return output
        }
    }
}