package com.example.lydavidcardgame;

//Name: David Ly
//Date: January 29, 2021

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class winscreen extends AppCompatActivity {

    //checks who wins
    int win = 0;
    //holds player 1's name
    String display1 = "";
    //holds player 2's name
    String display2 = "";
    //holds player 3's name
    String display3 = "";
    //holds player 4's name
    String display4 = "";
    //holds player 5's name
    String display5 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winscreen);
        //win music
        MediaPlayer ring = MediaPlayer.create(winscreen.this, R.raw.win);
        ring.start();

        //reads in the user's names they chose in name screen
        try {
            FileInputStream in = openFileInput("names.txt");
            display1 = "";
            //How long is the first name?
            int nameLength = in.read();
            //Read in that many ints, convert to chars
            for (int i = 0; i < nameLength; i++) {
                int data = in.read();
                char letter = (char) data;
                display1 += letter;
            }
            //checks if player 1's name is blank, if it is, then set their name to the default "Player 1"
            if (namecheck(display1)) {
                display1 = ("Player 1");
            }
            //How long is the second name?
            nameLength = in.read();
            display2 = "";
            //Read in that many ints, convert to chars
            for (int i = 0; i < nameLength; i++) {
                int data = in.read();
                char letter = (char) data;
                display2 += letter;
            }
            //checks if player 2's name is blank, if it is, then set their name to the default "Player 2"
            if (namecheck(display2)) {
                display2 = ("Player 2");
            }
            //How long is the third name?
            nameLength = in.read();
            display3 = "";
            //Read in that many ints, convert to chars
            for (int i = 0; i < nameLength; i++) {
                int data = in.read();
                char letter = (char) data;
                display3 += letter;
            }
            //checks if player 3's name is blank, if it is, then set their name to the default "Player 3"
            if (namecheck(display3)) {
                display3 = ("Player 3");
            }
            //How long is the fourth name?
            nameLength = in.read();
            display4 = "";
            //Read in that many ints, convert to chars
            for (int i = 0; i < nameLength; i++) {
                int data = in.read();
                char letter = (char) data;
                display4 += letter;
            }
            //checks if player 4's name is blank, if it is, then set their name to the default "Player 4"
            if (namecheck(display4)) {
                display4 = ("Player 4");
            }
            //How long is the fifth name?
            nameLength = in.read();
            display5 = "";
            //Read in that many ints, convert to chars
            for (int i = 0; i < nameLength; i++) {
                int data = in.read();
                char letter = (char) data;
                display5 += letter;
            }
            //checks if player 5's name is blank, if it is, then set their name to the default "Player 5"
            if (namecheck(display5)) {
                display5 = ("Player 5");
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //reads in who won from game screen
        try {
            FileInputStream in = openFileInput("whowin.txt");
            win = in.read();
            //if player 1 won, change the textviews to congratulate player 1
            if (win == 1) {
                TextView txt = (TextView) findViewById(R.id.haswon);
                TextView wintxt = (TextView) findViewById(R.id.wintext);
                txt.setText(display1 + " has won!");
                wintxt.setText("Congratulations to " + display1 + " for winning the game of Rhyme Out! Click to play again.");
            }
            //if player 2 won, change the textviews to congratulate player 2
            else if (win == 2) {
                TextView txt = (TextView) findViewById(R.id.haswon);
                TextView wintxt = (TextView) findViewById(R.id.wintext);
                txt.setText(display2 + " has won!");
                wintxt.setText("Congratulations to " + display2 + " for winning the game of Rhyme Out! Click to play again.");
            }
            //if player 3 won, change the textviews to congratulate player 3
            else if (win == 3) {
                TextView txt = (TextView) findViewById(R.id.haswon);
                TextView wintxt = (TextView) findViewById(R.id.wintext);
                txt.setText(display3 + " has won!");
                wintxt.setText("Congratulations to " + display3 + " for winning the game of Rhyme Out! Click to play again.");
            }
            //if player 4 won, change the textviews to congratulate player 4
            else if (win == 4) {
                TextView txt = (TextView) findViewById(R.id.haswon);
                TextView wintxt = (TextView) findViewById(R.id.wintext);
                txt.setText(display4 + " has won!");
                wintxt.setText("Congratulations to " + display4 + " for winning the game of Rhyme Out! Click to play again.");
            }
            //if player 5 won, change the textviews to congratulate player 5
            else if (win == 5) {
                TextView txt = (TextView) findViewById(R.id.haswon);
                TextView wintxt = (TextView) findViewById(R.id.wintext);
                txt.setText(display5 + " has won!");
                wintxt.setText("Congratulations to " + display5 + " for winning the game of Rhyme Out! Click to play again.");
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //sends user back to game screen
    public void click(View view) {
        Intent c = new Intent(this, Game.class);
        startActivity(c);
        //write all scores back to 0
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

    //checks if the user's name is blank, returns true if it is
    public boolean namecheck(String n1) {
        if (n1.equals(""))
            return true;
        else
            return false;
    }

}
