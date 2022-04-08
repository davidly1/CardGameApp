package com.example.lydavidcardgame;

//Name: David Ly
//Date: January 29, 2021
//Purpose: Unit 7 Project - Card Game

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class instructions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
    }

    //sends user to game screen
    public void click(View view) {
        Intent c = new Intent(this, Game.class);
        startActivity(c);
    }
}