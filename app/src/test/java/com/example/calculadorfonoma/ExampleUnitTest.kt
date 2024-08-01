package com.example.calculadorfonoma

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest
{

    //  for (i in 0..10) {}

    //  for (i in 1..4 step 2)

    //for (i in 0 until 10)

    //for (i in 0 downTo  10)



    //   for (int i = 0; i < 10; i++) {}



}



fun main (){

   val a = isPalindrome(10)

    println(a)


}








fun isPalindrome(x: Int): Boolean{

    val a = x.toString()
    var b=""

    for(i in a.length-1 downTo   0){
        b += a[i]
    }

    if(a==b){
        return true
    }

    return false
}






/*
fun aa (nums: IntArray, target: Int): IntArray
{

    var a: IntArray = intArrayOf(0,0)

    for(i in nums.indices){

        for(j in i+1 until  nums.size){

           if( nums[i]+ nums[j]==target){
               a = intArrayOf(i,j)
           }

        }


    }


    return a
}
*/



/*
var a: IntArray = intArrayOf(0,0)

for(i in nums.indices){

    for(j in i+1 until  nums.size){

        if( nums[i]+ nums[j]==target){
            a = intArrayOf(i,j)
        }

    }


}


return a
*/



/*

class Mama(){

    val a =-8

    fun aa(){


        for (i in 0 downTo  10){

        }


        println("x")
    }


}


    var numbers = intArrayOf(13, 4, 24, 7)
    var maxNum = numbers[0];

    for (i in 0.. numbers.size-1) {

        if (numbers[i] > maxNum) {
            maxNum = numbers[i];
        }
    }
    println(maxNum);



*/

