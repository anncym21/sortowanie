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
        val poSort = findViewById<TextView>(R.id.poSort)
        val podaneTekst = findViewById<EditText>(R.id.podaneTekst)
        val sortProgress = findViewById<ProgressBar>(R.id.sortProgress)

        list = mutableListOf()
        sortBtn.setOnClickListener {
            list = bubbleSort(list.toIntArray()).toMutableList()
            poSort.text = list.toString()
            przedSort.text = ""
        }
//
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

        }
    }

}

/*fun main(args: Array<String>){
    print("Enter text: ")
    val stringInput = readLine()!!
    println("You entered: $stringInput")
    val numbers = takeInput()
    bubbleSort(numbers)
    println(numbers.joinToString(separator = " "))
}*/
fun takeInput(): IntArray{
    val scanner = Scanner(System.`in`)
    val size = scanner.nextInt()
    val numbers = IntArray(size)
    for(i in 0 until size){
        numbers[i] = scanner.nextInt()
    }
    return numbers
}

fun bubbleSort(numbers: IntArray){
    for(pass in 0 until (numbers.size - 1)){
        for(currentPosition in 0 until(numbers.size - pass - 1)){
            if(numbers[currentPosition]>numbers[currentPosition + 1]){
                val tmp = numbers[currentPosition]
                numbers[currentPosition] = numbers[currentPosition + 1]
                numbers[currentPosition + 1] = tmp
            }
        }
    }
}

fun bubbleSortWithSteps(numbers: IntArray){
    println("Initial numbers: [%s]".format(numbers.joinToString(separator = ", ")))
    for(pass in 0 until (numbers.size - 1)){
        for(currentPosition in 0 until(numbers.size - pass - 1)){
            print("Pass-%d-Step-%d:Comparing elements at position %d(%d) and %d(%d). ".format(pass, currentPosition,
                currentPosition, numbers[currentPosition],(currentPosition + 1), numbers[currentPosition +1]))
            if (numbers[currentPosition]>numbers[currentPosition + 1]){
                println("They are in wrong order, swap them")
                val tmp = numbers[currentPosition]
                numbers[currentPosition] = numbers[currentPosition + 1]
                numbers[currentPosition + 1] = tmp
            }else{
                println("Tey are in correct order, do not swap them")
            }
            println("Numbers after Pass-%d-Step-%d: [%s]".format(pass, currentPosition, numbers.joinToString(separator = ", ")))
        }
    }
    println("Sorted numbers: [%s]".format(numbers.joinToString(separator = ", ")))
}

fun bubbleSortSinglePass(numbers: IntArray){
    for (currentPosition in 0 until(numbers.size - 1)){
        if(numbers[currentPosition]>numbers[currentPosition + 1]){
            val tmp = numbers[currentPosition]
            numbers[currentPosition] = numbers[currentPosition + 1]
            numbers[currentPosition + 1] = tmp
        }
    }
}

