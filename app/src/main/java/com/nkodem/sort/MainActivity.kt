package com.nkodem.sort

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    private fun sort(arr:IntArray):IntArray{
        var swap = true
        while(swap){
            swap = false
            for(i in 0 until arr.size-1){
                if(arr[i] > arr[i+1]){
                    val temp = arr[i]
                    arr[i] = arr[i+1]
                    arr[i+1] = temp
                    swap = true
                }
            }
        }
        return arr
    }
    fun main(args:Array<String>){
        val list = sort(intArrayOf(1,20,3,8,6))
        for(k in list ) print("$k ")
    }
}