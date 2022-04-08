package com.example.lydavidcardgame;

//Name: David Ly
//Date: January 29, 2021
//Purpose: Unit 7 Project - Card Game

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class namescreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //holds the amount of players that will be participating in the game
    int playernum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_namescreen);
        //create spinner
        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        //if user chooses 2 players, hide players 3, 4, 5's edittexts
        if (text.equals("2")) {
            //set global variable playernum to 2
            playernum = 2;
            View b = findViewById(R.id.p3);
            b.setVisibility(View.GONE);
            View c = findViewById(R.id.p4);
            c.setVisibility(View.GONE);
            View e = findViewById(R.id.name3);
            e.setVisibility(View.GONE);
            View f = findViewById(R.id.name4);
            f.setVisibility(View.GONE);
            View g = findViewById(R.id.name5);
            g.setVisibility(View.GONE);
            View h = findViewById(R.id.p5);
            h.setVisibility(View.GONE);
        }
        //if user chooses 3 players, hide players 4, 5's edittexts
        else if (text.equals("3")) {
            //set global variable playernum to 3
            playernum = 3;
            View b = findViewById(R.id.p3);
            b.setVisibility(View.VISIBLE);
            View c = findViewById(R.id.p4);
            c.setVisibility(View.GONE);
            View e = findViewById(R.id.name3);
            e.setVisibility(View.VISIBLE);
            View f = findViewById(R.id.name4);
            f.setVisibility(View.GONE);
            View g = findViewById(R.id.name5);
            g.setVisibility(View.GONE);
            View h = findViewById(R.id.p5);
            h.setVisibility(View.GONE);
        }
        //if user chooses 4 players, hide players 5's edittexts and show players 1,2,3,4's edittexts
        else if (text.equals("4")) {
            //set global variable playernum to 4
            playernum = 4;
            View b = findViewById(R.id.p3);
            b.setVisibility(View.VISIBLE);
            View c = findViewById(R.id.p4);
            c.setVisibility(View.VISIBLE);
            View d = findViewById(R.id.name3);
            d.setVisibility(View.VISIBLE);
            View e = findViewById(R.id.name4);
            e.setVisibility(View.VISIBLE);
            View g = findViewById(R.id.name5);
            g.setVisibility(View.GONE);
            View h = findViewById(R.id.p5);
            h.setVisibility(View.GONE);
        }
        //if user chooses 5 players, show all edittexts
        else if (text.equals("5")) {
            //set global variable playernum to 5
            playernum = 5;
            View b = findViewById(R.id.p3);
            b.setVisibility(View.VISIBLE);
            View c = findViewById(R.id.p4);
            c.setVisibility(View.VISIBLE);
            View d = findViewById(R.id.name3);
            d.setVisibility(View.VISIBLE);
            View e = findViewById(R.id.name4);
            e.setVisibility(View.VISIBLE);
            View g = findViewById(R.id.name5);
            g.setVisibility(View.VISIBLE);
            View h = findViewById(R.id.p5);
            h.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //sends user to instructions screen
    public void click(View view) {
        Intent c = new Intent(this, instructions.class);
        startActivity(c);
        //writes playernum to know how many players are participating
        try {
            FileOutputStream out = openFileOutput("playernumber.txt", Activity.MODE_PRIVATE);
            out.write(playernum);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Get the names out of the EditTexts
        EditText name1 = (EditText) findViewById(R.id.name1);
        EditText name2 = (EditText) findViewById(R.id.name2);
        EditText name3 = (EditText) findViewById(R.id.name3);
        EditText name4 = (EditText) findViewById(R.id.name4);
        EditText name5 = (EditText) findViewById(R.id.name5);
        String n1 = name1.getText().toString();
        String n2 = name2.getText().toString();
        String n3 = name3.getText().toString();
        String n4 = name4.getText().toString();
        String n5 = name5.getText().toString();
        //Print them out to a file.
        try {
            FileOutputStream out = openFileOutput("names.txt", Activity.MODE_PRIVATE);
            //Print out the length of name 1
            out.write(n1.length());
            //Print out each ASCII letter in the name
            for (int i = 0; i < n1.length(); i++) {
                out.write((int) (n1.charAt(i)));
            }
            //Print out the length of name 2
            out.write(n2.length());
            //Print out each ASCII letter in the name
            for (int i = 0; i < n2.length(); i++) {
                out.write((int) (n2.charAt(i)));
            }
            //Print out the length of name 3
            out.write(n3.length());
            //Print out each ASCII letter in the name
            for (int i = 0; i < n3.length(); i++) {
                out.write((int) (n3.charAt(i)));
            }
            //Print out the length of name 4
            out.write(n4.length());
            //Print out each ASCII letter in the name
            for (int i = 0; i < n4.length(); i++) {
                out.write((int) (n4.charAt(i)));
            }
            //Print out the length of name 5
            out.write(n5.length());
            //Print out each ASCII letter in the name
            for (int i = 0; i < n5.length(); i++) {
                out.write((int) (n5.charAt(i)));
            }
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}