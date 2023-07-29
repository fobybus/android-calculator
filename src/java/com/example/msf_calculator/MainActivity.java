package com.example.msf_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.util.Log;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.media.MediaPlayer;

public class MainActivity extends AppCompatActivity {

    private ToggleButton tg;
    MediaPlayer md;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setup music
        tg=(ToggleButton) findViewById(R.id.toggleButton);
        md=MediaPlayer.create(this,R.raw.lilnas);
        if (tg.isChecked()){
            md.start();
        } else {
            md.stop();
        }
    }


    public void calculate(View view)
    {
        TextView screen=(TextView) findViewById(R.id.screen);
        EditText fe=(EditText) findViewById(R.id.firstedit);
        EditText se=(EditText) findViewById(R.id.secondedit);
        Spinner sp=(Spinner) findViewById(R.id.spinner);


      int first_number=Integer.valueOf(fe.getText().toString());
      int second_number=Integer.valueOf(se.getText().toString());
      int op=sp.getSelectedItemPosition();
      double result=0;

      switch(op){
          case 0:result=first_number+second_number;
          break;
          case 1:result=first_number-second_number;
          break;
          case 2:result=first_number*second_number;
          break;
          case 3:result=first_number/(double)second_number;
          break;

      }
        //debug
        Log.d("result",String.valueOf(result));
        //set screen
        screen.setText(String.valueOf(result));
    } //end on create

    public void checked(View view)
    {
        //setup music
        if (tg.isChecked()){
            md.reset();
            md.start();
        } else {
            md.pause();
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
      //  Toast.makeText(this, "the app started", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "wellcome bro", Toast.LENGTH_SHORT).show();
    }
}