package com.example.gameapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

//    getting the elements
    private lateinit var tvattempts:TextView
    private lateinit var btnfirstnum:Button
    private lateinit var btnsecondnum:Button
    private lateinit var tvcorrectcount:TextView
    private lateinit var tvincorrectcount:TextView
    private lateinit var btnreset:Button
    private lateinit var tvcorrect:TextView
    private lateinit var tvincorrect:TextView
    private lateinit var tvdraw:TextView
    private lateinit var tvdrawcount:TextView
    private lateinit var result:TextView
    private var count:Int=0
    private var incount:Int=0
    private var draw:Int=0
    private var attempt:Int=10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        //    initializing and binding values
        tvattempts=findViewById(R.id.tvattempts);
        btnfirstnum=findViewById(R.id.btnfirstnum);
        btnsecondnum=findViewById(R.id.btnsecondnum);
        tvcorrectcount=findViewById(R.id.tvcorrectcount);
        tvincorrectcount=findViewById(R.id.tvincorrectcount);
        btnreset=findViewById(R.id.btnreset);
        tvcorrect=findViewById(R.id.tvcorrect);
        tvincorrect=findViewById(R.id.tvincorrect);
        tvdraw=findViewById(R.id.tvdraw);
        tvdrawcount=findViewById(R.id.tvdrawcount);
        result=findViewById(R.id.result);


//        calling the functions
        randomnum1();
        randomnum2();

        tvattempts.text=attempt.toString()

//        adding listeners on buttons
        btnfirstnum.setOnClickListener { btn1check(); bothcall() };
        btnsecondnum.setOnClickListener { btn2check(); bothcall() };
        btnreset.setOnClickListener { reset() }

    }
//    function for generating random number each
    private fun randomnum1(){
        val randomnum1= Random.nextInt(0,100);
        btnfirstnum.text=randomnum1.toString();
    }

    private fun randomnum2(){
        val randomnum2= Random.nextInt(0,100);
        btnsecondnum.text=randomnum2.toString();
    }
//generate random num for both buttons
    private fun bothcall(){
        randomnum1();
        randomnum2();
    }

//    check for correct incorrect btn1
    private fun btn1check(){
        if(btnfirstnum.text.toString()>btnsecondnum.text.toString()){
            ++count
            tvcorrectcount.text=count.toString()
            result.text="WON";
        }
        if(btnfirstnum.text.toString()<btnsecondnum.text.toString()){
            ++incount
            tvincorrectcount.text=incount.toString()
            result.text="LOST";

        }
        if(btnfirstnum.text.toString()==btnsecondnum.text.toString()){
            ++draw;
            tvdrawcount.text=draw.toString()
            result.text="DRAW";

        }
        attempt(count,incount,attempt,draw)
}
    //    check for correct incorrect btn1

    private fun btn2check(){
        if(btnfirstnum.text.toString()<btnsecondnum.text.toString()){
            ++count
            tvcorrectcount.text=count.toString()
            result.text="WON";

        }
        if(btnfirstnum.text.toString()>btnsecondnum.text.toString()){
            ++incount
            tvincorrectcount.text=incount.toString()
            result.text="LOST";

        }
        if(btnfirstnum.text.toString()==btnsecondnum.text.toString()){
            ++draw;
            tvdrawcount.text=draw.toString()
            result.text="DRAW";

        }
        attempt(count,incount,attempt,draw)
    }

//    function to reset the game
    private fun reset(){
        bothcall();
        tvcorrectcount.text="";
        tvincorrectcount.text="";
        tvattempts.text="10";
        tvdrawcount.text=""
        result.text="Result";

//    setting the correct and incorrect counters  to 0
        count=0;
        incount=0;
        draw=0;
        attempt=10;
    }
//    function to change the attmpts
    private fun attempt(count: Int,incount: Int,attempt:Int,draw:Int){
        var sum=count+incount+draw
        var attempts=attempt-sum
        tvattempts.text=attempts.toString()
        if(sum==10){
            Toast.makeText(this@GameActivity,"Game over. Play again",Toast.LENGTH_LONG).show();
        }
    }

}