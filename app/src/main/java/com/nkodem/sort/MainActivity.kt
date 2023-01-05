package com.nkodem.sort

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var arrSize = 10
        var list = mutableListOf<Int>()
        val sortBtn = findViewById<Button>(R.id.sortBtn)
        val losBtn = findViewById<Button>(R.id.losBtn)
        val przedSort = findViewById<TextView>(R.id.przedSort)
        val timeView = findViewById<TextView>(R.id.timeView)
        val poSort = findViewById<TextView>(R.id.poSort)
        val podaneTekst = findViewById<EditText>(R.id.podaneTekst)
        val sortProgress = findViewById<ProgressBar>(R.id.sortProgress)


        list = mutableListOf<Int>()
        sortBtn.setOnClickListener {
            val begin = System.nanoTime()
            poSort.text = bubbleSort(list.toIntArray()).toMutableList().toString()
            val end = System.nanoTime()
            val time = end - begin
            timeView.text = time.toString()
            przedSort.text = ""
            sortProgress.progress = 100
        }

        losBtn.setOnClickListener {

            arrSize = podaneTekst.text.toString().toInt()
            sortProgress.max = arrSize
            list.clear()
            for (i in 0..arrSize - 1) {
                list.add((0..10).random())
                println(i)
            }
            przedSort.text = list.toString()
            poSort.text = ""
            sortProgress.progress = 0
        }
    }

}
fun bubbleSort(arr:IntArray):IntArray{
    var swap = true
    while(swap){
        swap = false
        for(i in 0 until arr.size-1){
            if(arr[i] > arr[i+1]){
                val temp = arr[i]
                arr[i] = arr[i+1]
                arr[i + 1] = temp

                swap = true
            }
        }
    }
    return arr
}

