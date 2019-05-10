package com.example.jerry.broadcastbestpractice;

import android.annotation.SuppressLint;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private volatile boolean timerRun;
    private long basetime = 0L;
    private Button Button1;
    private Button Button2;
    private Button Button3;
    private Button Button4;
    private Button Button5;
    private Button Button6;
    private Button Button7;
    private Button Button8;
    private Button Button9;
    private Button Button10;
    private Button Button11;
    private Button Button12;
    private Button Button13;
    private Button Button14;
    private Button Button15;
    private Button Button16;
    private SoundPool soundPool;
    private int soundID;
    private Button gamestart;
    private Button reset;
    private TextView mtimer;

    private List<MyButton> buttonLists = new ArrayList<>();

    Handler startTimehandler = new Handler() {
        public void handleMessage(Message msg){
            if (null != mtimer){
                if(timerRun) {
                    mtimer.setText((String) msg.obj);
                }
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.high_score:
                //AlertDialog.Builder builder =

                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        closeAndroidPDialog();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null){
//            actionBar.hide();
//        }

        findViewByIdforAll();
        buttomInit();
        initSound();

        reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buttomInit();
                for (int i=1; i<=16; i++) {
                    reflectToButton(i);
                }
                timerRun = false;
                mtimer.setText("00:00:00");
            }
        });
        gamestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!timerRun) {
                    mix();
                    mtimer.setText("00:00:00");
                    basetime = SystemClock.elapsedRealtime();
                    timerRun = true;
                } else {
                    timerRun = false;
                }
            }
        });

        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click1();
                playSound();
                checkIsCorrect();
            }
        });

        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click2();
                playSound();
                checkIsCorrect();
            }
        });
        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click3();
                playSound();
                checkIsCorrect();
            }
        });
        Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click4();
                playSound();
                checkIsCorrect();
            }
        });
        Button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click5();
                playSound();
                checkIsCorrect();
            }
        });
        Button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click6();
                playSound();
                checkIsCorrect();
            }
        });
        Button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click7();
                playSound();
                checkIsCorrect();
            }
        });
        Button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click8();
                playSound();
                checkIsCorrect();
            }
        });
        Button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click9();
                playSound();
                checkIsCorrect();
            }
        });
        Button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click10();
                playSound();
                checkIsCorrect();
            }
        });
        Button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click11();
                playSound();
                checkIsCorrect();
            }
        });
        Button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click12();
                playSound();
                checkIsCorrect();
            }
        });
        Button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click13();
                playSound();
                checkIsCorrect();
            }
        });
        Button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click14();
                playSound();
                checkIsCorrect();
            }
        });
        Button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click15();
                playSound();
                checkIsCorrect();
            }
        });
        Button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click16();
                playSound();
                checkIsCorrect();
            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                while(timerRun){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int time = (int)((SystemClock.elapsedRealtime() - basetime) / 1000 );
                    int milli = (int)((SystemClock.elapsedRealtime() - basetime) % 1000 );
                    String mm = new DecimalFormat("00").format(time % 3600 / 60);
                    String ss = new DecimalFormat("00").format(time % 60);
                    String ms = new DecimalFormat("000").format(milli);
                    String timeFormart = mm + ":" + ss + ":" + ms;
                    Message msg = new Message();
                    msg.obj = timeFormart;
                    startTimehandler.sendMessage(msg);
                }
            }
        }, 0 ,10L);
    }

    private void findViewByIdforAll() {
        Button1 = (Button)findViewById(R.id.button1);
        Button2 = (Button)findViewById(R.id.button2);
        Button3 = (Button)findViewById(R.id.button3);
        Button4 = (Button)findViewById(R.id.button4);
        Button5 = (Button)findViewById(R.id.button5);
        Button6 = (Button)findViewById(R.id.button6);
        Button7 = (Button)findViewById(R.id.button7);
        Button8 = (Button)findViewById(R.id.button8);
        Button9 = (Button)findViewById(R.id.button9);
        Button10 = (Button)findViewById(R.id.button10);
        Button11 = (Button)findViewById(R.id.button11);
        Button12 = (Button)findViewById(R.id.button12);
        Button13 = (Button)findViewById(R.id.button13);
        Button14 = (Button)findViewById(R.id.button14);
        Button15 = (Button)findViewById(R.id.button15);
        Button16 = (Button)findViewById(R.id.button16);
        mtimer = (TextView)findViewById(R.id.timer);
        reset = (Button) findViewById(R.id.reset);
        gamestart = (Button)findViewById(R.id.gamestart);
    }

    private void buttomInit() {

        for(int i=0;i<15;i++) {
            buttonLists.add(new MyButton());
            buttonLists.get(i).setIsvisible(true);
            buttonLists.get(i).setNumber(String.valueOf(i+1));
        }
        buttonLists.add(new MyButton());
        buttonLists.get(15).setIsvisible(false);
        buttonLists.get(15).setNumber("16");
    }


    @SuppressLint("NewApi")
    private void initSound() {
        soundPool = new SoundPool.Builder().build();
        soundID = soundPool.load(this, R.raw.type, 1);
    }

    private void checkIsCorrect() {
        if (    ("1".equals(buttonLists.get(0).getNumber())) &&
                ("2".equals(buttonLists.get(1).getNumber())) &&
                ("3".equals(buttonLists.get(2).getNumber())) &&
                ("4".equals(buttonLists.get(3).getNumber())) &&
                ("5".equals(buttonLists.get(4).getNumber())) &&
                ("6".equals(buttonLists.get(5).getNumber())) &&
                ("7".equals(buttonLists.get(6).getNumber())) &&
                ("8".equals(buttonLists.get(7).getNumber())) &&
                ("9".equals(buttonLists.get(8).getNumber())) &&
                ("10".equals(buttonLists.get(9).getNumber())) &&
                ("11".equals(buttonLists.get(10).getNumber())) &&
                ("12".equals(buttonLists.get(11).getNumber())) &&
                ("13".equals(buttonLists.get(12).getNumber())) &&
                ("14".equals(buttonLists.get(13).getNumber())) &&
                ("15".equals(buttonLists.get(14).getNumber())) &&
                (!buttonLists.get(15).isvisible())) {
            if (timerRun) {
                timerRun = false;
                String msg = mtimer.getText().toString();
                mtimer.setText(msg);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("恭喜你！");
                builder.setMessage("您的用时为" + msg);
                builder.setCancelable(true);
                builder.create();
                builder.show();
            }
        }
    }

    private void mix(){
        int ram;
        String change;
        for(int i=0; i<15;i++){
            ram = RamdomCreator();
            if(ram != i){
                change = buttonLists.get(i).getNumber();
                buttonLists.get(i).setNumber(buttonLists.get(ram).getNumber());
                buttonLists.get(ram).setNumber(change);
            } else {
                i--;
            }
        }
        //再任意换一次，保证奇偶性，以确保有解
        change = buttonLists.get(1).getNumber();
        buttonLists.get(1).setNumber(buttonLists.get(0).getNumber());
        buttonLists.get(0).setNumber(change);
        for (int i=1;i<=16;i++){
            reflectToButton(i);
        }
    }

    private void click16() {
        if (buttonLists.get(15).isvisible()){
            if(!buttonLists.get(11).isvisible()){
                buttonLists.get(15).setIsvisible(false);
                buttonLists.get(11).setIsvisible(true);
                buttonLists.get(11).setNumber(buttonLists.get(15).getNumber());
            } else if (!buttonLists.get(14).isvisible()) {
                buttonLists.get(15).setIsvisible(false);
                buttonLists.get(14).setIsvisible(true);
                buttonLists.get(14).setNumber(buttonLists.get(15).getNumber());
            }
            reflectToButton(16);
            reflectToButton(12);
            reflectToButton(15);
        }
    }

    private void click15() {
        if (buttonLists.get(14).isvisible()){
            if (!buttonLists.get(15).isvisible()) {
                buttonLists.get(14).setIsvisible(false);
                buttonLists.get(15).setIsvisible(true);
                buttonLists.get(15).setNumber(buttonLists.get(14).getNumber());
            }else if (!buttonLists.get(10).isvisible()) {
                buttonLists.get(14).setIsvisible(false);
                buttonLists.get(10).setIsvisible(true);
                buttonLists.get(10).setNumber(buttonLists.get(14).getNumber());
            }else if (!buttonLists.get(13).isvisible()) {
                buttonLists.get(14).setIsvisible(false);
                buttonLists.get(13).setIsvisible(true);
                buttonLists.get(13).setNumber(buttonLists.get(14).getNumber());
            }
            reflectToButton(15);
            reflectToButton(16);
            reflectToButton(11);
            reflectToButton(14);
        }
    }

    private void click14() {
        if (buttonLists.get(13).isvisible()){
            if(!buttonLists.get(12).isvisible()){
                buttonLists.get(13).setIsvisible(false);
                buttonLists.get(12).setIsvisible(true);
                buttonLists.get(12).setNumber(buttonLists.get(13).getNumber());
            } else if (!buttonLists.get(9).isvisible()) {
                buttonLists.get(13).setIsvisible(false);
                buttonLists.get(9).setIsvisible(true);
                buttonLists.get(9).setNumber(buttonLists.get(13).getNumber());
            }else if (!buttonLists.get(14).isvisible()) {
                buttonLists.get(13).setIsvisible(false);
                buttonLists.get(14).setIsvisible(true);
                buttonLists.get(14).setNumber(buttonLists.get(13).getNumber());
            }
            reflectToButton(14);
            reflectToButton(13);
            reflectToButton(10);
            reflectToButton(15);
        }
    }

    private void click13() {
        if (buttonLists.get(12).isvisible()){
            if(!buttonLists.get(8).isvisible()){
                buttonLists.get(12).setIsvisible(false);
                buttonLists.get(8).setIsvisible(true);
                buttonLists.get(8).setNumber(buttonLists.get(12).getNumber());
            } else if (!buttonLists.get(13).isvisible()) {
                buttonLists.get(12).setIsvisible(false);
                buttonLists.get(13).setIsvisible(true);
                buttonLists.get(13).setNumber(buttonLists.get(12).getNumber());
            }
            reflectToButton(13);
            reflectToButton(9);
            reflectToButton(14);
        }
    }

    private void click12() {
        if (buttonLists.get(11).isvisible()){
            if(!buttonLists.get(7).isvisible()){
                buttonLists.get(11).setIsvisible(false);
                buttonLists.get(7).setIsvisible(true);
                buttonLists.get(7).setNumber(buttonLists.get(11).getNumber());
            } else if (!buttonLists.get(10).isvisible()) {
                buttonLists.get(11).setIsvisible(false);
                buttonLists.get(10).setIsvisible(true);
                buttonLists.get(10).setNumber(buttonLists.get(11).getNumber());
            }else if (!buttonLists.get(15).isvisible()) {
                buttonLists.get(11).setIsvisible(false);
                buttonLists.get(15).setIsvisible(true);
                buttonLists.get(15).setNumber(buttonLists.get(11).getNumber());
            }
            reflectToButton(12);
            reflectToButton(8);
            reflectToButton(11);
            reflectToButton(16);
        }
    }

    private void click11() {
        if (buttonLists.get(10).isvisible()){
            if(!buttonLists.get(6).isvisible()){
                buttonLists.get(10).setIsvisible(false);
                buttonLists.get(6).setIsvisible(true);
                buttonLists.get(6).setNumber(buttonLists.get(10).getNumber());
            } else if (!buttonLists.get(9).isvisible()) {
                buttonLists.get(10).setIsvisible(false);
                buttonLists.get(9).setIsvisible(true);
                buttonLists.get(9).setNumber(buttonLists.get(10).getNumber());
            }else if (!buttonLists.get(11).isvisible()) {
                buttonLists.get(10).setIsvisible(false);
                buttonLists.get(11).setIsvisible(true);
                buttonLists.get(11).setNumber(buttonLists.get(10).getNumber());
            }else if (!buttonLists.get(14).isvisible()) {
                buttonLists.get(10).setIsvisible(false);
                buttonLists.get(14).setIsvisible(true);
                buttonLists.get(14).setNumber(buttonLists.get(10).getNumber());
            }
            reflectToButton(11);
            reflectToButton(7);
            reflectToButton(10);
            reflectToButton(12);
            reflectToButton(15);
        }
    }

    private void click10() {
        if (buttonLists.get(9).isvisible()){
            if(!buttonLists.get(5).isvisible()){
                buttonLists.get(9).setIsvisible(false);
                buttonLists.get(5).setIsvisible(true);
                buttonLists.get(5).setNumber(buttonLists.get(9).getNumber());
            } else if (!buttonLists.get(8).isvisible()) {
                buttonLists.get(9).setIsvisible(false);
                buttonLists.get(8).setIsvisible(true);
                buttonLists.get(8).setNumber(buttonLists.get(9).getNumber());
            }else if (!buttonLists.get(10).isvisible()) {
                buttonLists.get(9).setIsvisible(false);
                buttonLists.get(10).setIsvisible(true);
                buttonLists.get(10).setNumber(buttonLists.get(9).getNumber());
            }else if (!buttonLists.get(13).isvisible()) {
                buttonLists.get(9).setIsvisible(false);
                buttonLists.get(13).setIsvisible(true);
                buttonLists.get(13).setNumber(buttonLists.get(9).getNumber());
            }
            reflectToButton(10);
            reflectToButton(6);
            reflectToButton(9);
            reflectToButton(11);
            reflectToButton(14);
        }
    }

    private void click9() {
        if (buttonLists.get(8).isvisible()){
            if(!buttonLists.get(4).isvisible()){
                buttonLists.get(8).setIsvisible(false);
                buttonLists.get(4).setIsvisible(true);
                buttonLists.get(4).setNumber(buttonLists.get(8).getNumber());
            } else if (!buttonLists.get(9).isvisible()) {
                buttonLists.get(8).setIsvisible(false);
                buttonLists.get(9).setIsvisible(true);
                buttonLists.get(9).setNumber(buttonLists.get(8).getNumber());
            }else if (!buttonLists.get(12).isvisible()) {
                buttonLists.get(8).setIsvisible(false);
                buttonLists.get(12).setIsvisible(true);
                buttonLists.get(12).setNumber(buttonLists.get(8).getNumber());
            }
            reflectToButton(9);
            reflectToButton(5);
            reflectToButton(10);
            reflectToButton(13);
        }
    }

    private void click8() {
        if (buttonLists.get(7).isvisible()){
            if(!buttonLists.get(3).isvisible()){
                buttonLists.get(7).setIsvisible(false);
                buttonLists.get(3).setIsvisible(true);
                buttonLists.get(3).setNumber(buttonLists.get(7).getNumber());
            } else if (!buttonLists.get(6).isvisible()) {
                buttonLists.get(7).setIsvisible(false);
                buttonLists.get(6).setIsvisible(true);
                buttonLists.get(6).setNumber(buttonLists.get(7).getNumber());
            }else if (!buttonLists.get(11).isvisible()) {
                buttonLists.get(7).setIsvisible(false);
                buttonLists.get(11).setIsvisible(true);
                buttonLists.get(11).setNumber(buttonLists.get(7).getNumber());
            }
            reflectToButton(8);
            reflectToButton(4);
            reflectToButton(7);
            reflectToButton(12);
        }
    }

    private void click7() {
        if (buttonLists.get(6).isvisible()){
            if(!buttonLists.get(2).isvisible()){
                buttonLists.get(6).setIsvisible(false);
                buttonLists.get(2).setIsvisible(true);
                buttonLists.get(2).setNumber(buttonLists.get(6).getNumber());
            } else if (!buttonLists.get(5).isvisible()) {
                buttonLists.get(6).setIsvisible(false);
                buttonLists.get(5).setIsvisible(true);
                buttonLists.get(5).setNumber(buttonLists.get(6).getNumber());
            }else if (!buttonLists.get(7).isvisible()) {
                buttonLists.get(6).setIsvisible(false);
                buttonLists.get(7).setIsvisible(true);
                buttonLists.get(7).setNumber(buttonLists.get(6).getNumber());
            }else if (!buttonLists.get(10).isvisible()) {
                buttonLists.get(6).setIsvisible(false);
                buttonLists.get(10).setIsvisible(true);
                buttonLists.get(10).setNumber(buttonLists.get(6).getNumber());
            }
            reflectToButton(7);
            reflectToButton(3);
            reflectToButton(6);
            reflectToButton(8);
            reflectToButton(11);
        }
    }

    private void click6() {
        if (buttonLists.get(5).isvisible()){
            if(!buttonLists.get(1).isvisible()){
                buttonLists.get(5).setIsvisible(false);
                buttonLists.get(1).setIsvisible(true);
                buttonLists.get(1).setNumber(buttonLists.get(5).getNumber());
            } else if (!buttonLists.get(4).isvisible()) {
                buttonLists.get(5).setIsvisible(false);
                buttonLists.get(4).setIsvisible(true);
                buttonLists.get(4).setNumber(buttonLists.get(5).getNumber());
            }else if (!buttonLists.get(6).isvisible()) {
                buttonLists.get(5).setIsvisible(false);
                buttonLists.get(6).setIsvisible(true);
                buttonLists.get(6).setNumber(buttonLists.get(5).getNumber());
            }else if (!buttonLists.get(9).isvisible()) {
                buttonLists.get(5).setIsvisible(false);
                buttonLists.get(9).setIsvisible(true);
                buttonLists.get(9).setNumber(buttonLists.get(5).getNumber());
            }
            reflectToButton(6);
            reflectToButton(2);
            reflectToButton(5);
            reflectToButton(7);
            reflectToButton(10);
        }
    }

    private void click5() {
        if (buttonLists.get(4).isvisible()){
            if(!buttonLists.get(0).isvisible()){
                buttonLists.get(4).setIsvisible(false);
                buttonLists.get(0).setIsvisible(true);
                buttonLists.get(0).setNumber(buttonLists.get(4).getNumber());
            } else if (!buttonLists.get(5).isvisible()) {
                buttonLists.get(4).setIsvisible(false);
                buttonLists.get(5).setIsvisible(true);
                buttonLists.get(5).setNumber(buttonLists.get(4).getNumber());
            }else if (!buttonLists.get(8).isvisible()) {
                buttonLists.get(4).setIsvisible(false);
                buttonLists.get(8).setIsvisible(true);
                buttonLists.get(8).setNumber(buttonLists.get(4).getNumber());
            }
            reflectToButton(5);
            reflectToButton(1);
            reflectToButton(6);
            reflectToButton(9);
        }
    }

    private void click4() {
        if (buttonLists.get(3).isvisible()){
            if(!buttonLists.get(2).isvisible()){
                buttonLists.get(3).setIsvisible(false);
                buttonLists.get(2).setIsvisible(true);
                buttonLists.get(2).setNumber(buttonLists.get(3).getNumber());
            } else if (!buttonLists.get(7).isvisible()) {
                buttonLists.get(3).setIsvisible(false);
                buttonLists.get(7).setIsvisible(true);
                buttonLists.get(7).setNumber(buttonLists.get(3).getNumber());
            }
            reflectToButton(4);
            reflectToButton(3);
            reflectToButton(8);

        }
    }

    private void click3() {
        if (buttonLists.get(2).isvisible()){
            if(!buttonLists.get(1).isvisible()){
                buttonLists.get(2).setIsvisible(false);
                buttonLists.get(1).setIsvisible(true);
                buttonLists.get(1).setNumber(buttonLists.get(2).getNumber());
            } else if (!buttonLists.get(3).isvisible()) {
                buttonLists.get(2).setIsvisible(false);
                buttonLists.get(3).setIsvisible(true);
                buttonLists.get(3).setNumber(buttonLists.get(2).getNumber());
            } else if (!buttonLists.get(6).isvisible()) {
                buttonLists.get(2).setIsvisible(false);
                buttonLists.get(6).setIsvisible(true);
                buttonLists.get(6).setNumber(buttonLists.get(2).getNumber());
            }
            reflectToButton(3);
            reflectToButton(2);
            reflectToButton(4);
            reflectToButton(7);
        }
    }

    private void click2() {
        if (buttonLists.get(1).isvisible()){
            if(!buttonLists.get(0).isvisible()){
                buttonLists.get(1).setIsvisible(false);
                buttonLists.get(0).setIsvisible(true);
                buttonLists.get(0).setNumber(buttonLists.get(1).getNumber());
            } else if (!buttonLists.get(5).isvisible()) {
                buttonLists.get(1).setIsvisible(false);
                buttonLists.get(5).setIsvisible(true);
                buttonLists.get(5).setNumber(buttonLists.get(1).getNumber());
            } else if (!buttonLists.get(2).isvisible()) {
                buttonLists.get(1).setIsvisible(false);
                buttonLists.get(2).setIsvisible(true);
                buttonLists.get(2).setNumber(buttonLists.get(1).getNumber());
            }
            reflectToButton(2);
            reflectToButton(1);
            reflectToButton(6);
            reflectToButton(3);
        }
    }

    private void click1() {
        if (buttonLists.get(0).isvisible()){                      //若1格子是看得见的
            if(!buttonLists.get(1).isvisible()){                  //若2格子是看不见的
                buttonLists.get(0).setIsvisible(false);                   //将1隐藏
                buttonLists.get(1).setIsvisible(true);                    //将2显示
                buttonLists.get(1).setNumber(buttonLists.get(0).getNumber());   //将1中的文字给2
            } else if (!buttonLists.get(4).isvisible()) {         //若4格子是看不见的
                buttonLists.get(0).setIsvisible(false);                   //将1隐藏
                buttonLists.get(4).setIsvisible(true);                    //将4显示
                buttonLists.get(4).setNumber(buttonLists.get(0).getNumber()); //将1中的文字给4
            }
            reflectToButton(1);
            reflectToButton(2);
            reflectToButton(5);
        }
    }




    private void reflectToButton(int btId) {

        switch (btId) {
            case 1:
                if (buttonLists.get(0).isvisible()) {
                    Button1.setVisibility(View.VISIBLE);
                } else {
                    Button1.setVisibility(View.INVISIBLE);
                }
                Button1.setText(buttonLists.get(0).getNumber());
                break;
            case 2:
                if (buttonLists.get(1).isvisible()) {
                    Button2.setVisibility(View.VISIBLE);
                } else {
                    Button2.setVisibility(View.INVISIBLE);
                }
                Button2.setText(buttonLists.get(1).getNumber());
                break;
            case 3:
                if (buttonLists.get(2).isvisible()) {
                    Button3.setVisibility(View.VISIBLE);
                } else {
                    Button3.setVisibility(View.INVISIBLE);
                }
                Button3.setText(buttonLists.get(2).getNumber());
                break;
            case 4:
                if (buttonLists.get(3).isvisible()) {
                    Button4.setVisibility(View.VISIBLE);
                } else {
                    Button4.setVisibility(View.INVISIBLE);
                }
                Button4.setText(buttonLists.get(3).getNumber());
                break;
            case 5:
                if (buttonLists.get(4).isvisible()) {
                    Button5.setVisibility(View.VISIBLE);
                } else {
                    Button5.setVisibility(View.INVISIBLE);
                }
                Button5.setText(buttonLists.get(4).getNumber());
                break;
            case 6:
                if (buttonLists.get(5).isvisible()) {
                    Button6.setVisibility(View.VISIBLE);
                } else {
                    Button6.setVisibility(View.INVISIBLE);
                }
                Button6.setText(buttonLists.get(5).getNumber());
                break;
            case 7:
                if (buttonLists.get(6).isvisible()) {
                    Button7.setVisibility(View.VISIBLE);
                } else {
                    Button7.setVisibility(View.INVISIBLE);
                }
                Button7.setText(buttonLists.get(6).getNumber());
                break;
            case 8:
                if (buttonLists.get(7).isvisible()) {
                    Button8.setVisibility(View.VISIBLE);
                } else {
                    Button8.setVisibility(View.INVISIBLE);
                }
                Button8.setText(buttonLists.get(7).getNumber());
                break;
            case 9:
                if (buttonLists.get(8).isvisible()) {
                    Button9.setVisibility(View.VISIBLE);
                } else {
                    Button9.setVisibility(View.INVISIBLE);
                }
                Button9.setText(buttonLists.get(8).getNumber());
                break;
            case 10:
                if (buttonLists.get(9).isvisible()) {
                    Button10.setVisibility(View.VISIBLE);
                } else {
                    Button10.setVisibility(View.INVISIBLE);
                }
                Button10.setText(buttonLists.get(9).getNumber());
                break;
            case 11:
                if (buttonLists.get(10).isvisible()) {
                    Button11.setVisibility(View.VISIBLE);
                } else {
                    Button11.setVisibility(View.INVISIBLE);
                }
                Button11.setText(buttonLists.get(10).getNumber());
                break;
            case 12:
                if (buttonLists.get(11).isvisible()) {
                    Button12.setVisibility(View.VISIBLE);
                } else {
                    Button12.setVisibility(View.INVISIBLE);
                }
                Button12.setText(buttonLists.get(11).getNumber());
                break;
            case 13:
                if (buttonLists.get(12).isvisible()) {
                    Button13.setVisibility(View.VISIBLE);
                } else {
                    Button13.setVisibility(View.INVISIBLE);
                }
                Button13.setText(buttonLists.get(12).getNumber());
                break;
            case 14:
                if (buttonLists.get(13).isvisible()) {
                    Button14.setVisibility(View.VISIBLE);
                } else {
                    Button14.setVisibility(View.INVISIBLE);
                }
                Button14.setText(buttonLists.get(13).getNumber());
                break;
            case 15:
                if (buttonLists.get(14).isvisible()) {
                    Button15.setVisibility(View.VISIBLE);
                } else {
                    Button15.setVisibility(View.INVISIBLE);
                }
                Button15.setText(buttonLists.get(14).getNumber());
                break;
            case 16:
                if (buttonLists.get(15).isvisible()) {
                    Button16.setVisibility(View.VISIBLE);
                } else {
                    Button16.setVisibility(View.INVISIBLE);
                }
                Button16.setText(buttonLists.get(15).getNumber());
                break;
            default:
                break;

        }
    }

    private void playSound() {
        soundPool.play(
                soundID,
                0.1f,   //左耳道音量【0~1】
                0.5f,   //右耳道音量【0~1】
                0,     //播放优先级【0表示最低优先级】
                0,     //循环模式【0表示循环一次，-1表示一直循环，其他表示数字+1表示当前数字对应的循环次数】
                1     //播放速度【1是正常，范围从0~2】
        );
    }

    private int RamdomCreator(){
        int min = 0;
        int max = 14;
        Random random = new Random();
        return (random.nextInt(max) % ((max - min) + 1)) + min;
    }

    private void closeAndroidPDialog() {
        try {
            Class aClass = Class.forName("android.content.pm.PackageParser$Package");
            Constructor declaredConstructor = aClass.getDeclaredConstructor(String.class);
            declaredConstructor.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Class cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread");
            declaredMethod.setAccessible(true);
            Object activityThread = declaredMethod.invoke(null);
            Field mHiddenApiWarningShown = cls.getDeclaredField("mHiddenApiWarningShown");
            mHiddenApiWarningShown.setAccessible(true);
            mHiddenApiWarningShown.setBoolean(activityThread, true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
