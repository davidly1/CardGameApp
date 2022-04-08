package com.example.lydavidcardgame;

//Name: David Ly
//Date: January 29, 2021
//Purpose: Unit 7 Project - Card Game

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //resets all scores back to 0
        try {
            FileOutputStream out = openFileOutput("score.txt", Activity.MODE_PRIVATE);
            out.write(0);
            out.write(0);
            out.write(0);
            out.write(0);
            out.write(0);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //sends user to the naming screen
    public void gonext(View view) {
        Intent i = new Intent(this, namescreen.class);
        startActivity(i);
    }
}