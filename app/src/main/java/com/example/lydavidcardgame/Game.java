package com.example.lydavidcardgame;

//Name: David Ly
//Date: January 29, 2021

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Game extends AppCompatActivity {
    //the deck
    Deck deck = new Deck();
    //holds player 1's score
    int score1 = 0;
    //holds player 2's score
    int score2 = 0;
    //holds player 3's score
    int score3 = 0;
    //holds player 4's score
    int score4 = 0;
    //holds player 5's score
    int score5 = 0;
    //holds the amount of players, initial value of 2 because game is two players
    int playernum = 2;
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
    //holds which player wins
    int win = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        display();
        Card h = deck.pop();
        //when user enters game screen, first 3 clues and hint will be on the screen
        TextView clue1 = (TextView) findViewById(R.id.clue1);
        TextView clue2 = (TextView) findViewById(R.id.clue2);
        TextView clue3 = (TextView) findViewById(R.id.clue3);
        TextView hint = (TextView) findViewById(R.id.hint);
        clue1.setText("Clue 1: " + h.getClue1());
        clue2.setText("Clue 2: " + h.getClue2());
        clue3.setText("Clue 3: " + h.getClue3());
        hint.setText(h.getHint());
        //reads in the amount of players
        try {
            FileInputStream in = openFileInput("playernumber.txt");
            playernum = in.read();
            in.close();
            //if 2 players, hide player 3,4,5 score buttons
            if (playernum == 2) {
                View b = findViewById(R.id.p3);
                b.setVisibility(View.INVISIBLE);
                View c = findViewById(R.id.p4);
                c.setVisibility(View.INVISIBLE);
                View d = findViewById(R.id.p5);
                d.setVisibility(View.INVISIBLE);
                //if 3 players, hide player 4,5 score buttons
            } else if (playernum == 3) {
                View b = findViewById(R.id.p3);
                b.setVisibility(View.VISIBLE);
                View c = findViewById(R.id.p4);
                c.setVisibility(View.INVISIBLE);
                View d = findViewById(R.id.p5);
                d.setVisibility(View.INVISIBLE);
            }
            //if 4 players, hide player 5 score button
            else if (playernum == 4) {
                View b = findViewById(R.id.p3);
                b.setVisibility(View.VISIBLE);
                View c = findViewById(R.id.p4);
                c.setVisibility(View.VISIBLE);
                View d = findViewById(R.id.p5);
                d.setVisibility(View.INVISIBLE);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //reads in the names that the users have chosen in name screen
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
            //Display the first name
            Button name1 = (Button) findViewById(R.id.p1);
            //if player 1's name is blank, set their name as the default "Player 1"
            if (namecheck(display1)) {
                display1 = ("Player 1");
            }
            name1.setText(display1 + ": " + score1);
            //How long is the second name?
            nameLength = in.read();
            display2 = "";
            //Read in that many ints, convert to chars
            for (int i = 0; i < nameLength; i++) {
                int data = in.read();
                char letter = (char) data;
                display2 += letter;
            }
            //Display the second name
            Button name2 = (Button) findViewById(R.id.p2);
            //if player 2's name is blank, set their name as the default "Player 2"
            if (namecheck(display2)) {
                display2 = ("Player 2");
            }
            name2.setText(display2 + ": " + score2);
            //How long is the third name?
            nameLength = in.read();
            display3 = "";
            //Read in that many ints, convert to chars
            for (int i = 0; i < nameLength; i++) {
                int data = in.read();
                char letter = (char) data;
                display3 += letter;
            }
            //Display the third name
            Button name3 = (Button) findViewById(R.id.p3);
            //if player 3's name is blank, set their name as the default "Player 3"
            if (namecheck(display3)) {
                display3 = ("Player 3");
            }
            name3.setText(display3 + ": " + score3);
            //How long is the fourth name?
            nameLength = in.read();
            display4 = "";
            //Read in that many ints, convert to chars
            for (int i = 0; i < nameLength; i++) {
                int data = in.read();
                char letter = (char) data;
                display4 += letter;
            }
            //Display the fourth name
            Button name4 = (Button) findViewById(R.id.p4);
            //if player 4's name is blank, set their name as the default "Player 4"
            if (namecheck(display4)) {
                display4 = ("Player 4");
            }
            name4.setText(display4 + ": " + score4);
            //How long is the fifth name?
            nameLength = in.read();
            display5 = "";
            //Read in that many ints, convert to chars
            for (int i = 0; i < nameLength; i++) {
                int data = in.read();
                char letter = (char) data;
                display5 += letter;
            }
            //Display the fourth name
            Button name5 = (Button) findViewById(R.id.p5);
            //if player 5's name is blank, set their name as the default "Player 5"
            if (namecheck(display5)) {
                display5 = ("Player 5");
            }
            name5.setText(display5 + ": " + score5);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //reads in the score once the user comes back from different screen
        try {
            FileInputStream in = openFileInput("score.txt");
            score1 = in.read();
            //sets player 1's button back to its original score
            Button p1 = (Button) findViewById(R.id.p1);
            p1.setText(display1 + ": " + score1);
            score2 = in.read();
            //sets player 2's button back to its original score
            Button p2 = (Button) findViewById(R.id.p2);
            p2.setText(display2 + ": " + score2);
            score3 = in.read();
            //sets player 3's button back to its original score
            Button p3 = (Button) findViewById(R.id.p3);
            p3.setText(display3 + ": " + score3);
            score4 = in.read();
            //sets player 4's button back to its original score
            Button p4 = (Button) findViewById(R.id.p4);
            p4.setText(display4 + ": " + score4);
            score5 = in.read();
            //sets player 5's button back to its original score
            Button p5 = (Button) findViewById(R.id.p5);
            p5.setText(display5 + ": " + score5);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void display() {
        if (!deck.isEmpty()) {
            Card c = deck.pop();
            TextView clue1 = (TextView) findViewById(R.id.clue1);
            TextView clue2 = (TextView) findViewById(R.id.clue2);
            TextView clue3 = (TextView) findViewById(R.id.clue3);
            TextView hint = (TextView) findViewById(R.id.hint);
            clue1.setText("Clue 1: " + c.getClue1());
            clue2.setText("Clue 2: " + c.getClue2());
            clue3.setText("Clue 3: " + c.getClue3());
            hint.setText(c.getHint());
        } else {
            deck.shuffle();
        }
    }

    public void pop(View view) {
        display();
    }

    public void reset(View view) {
        //shuffle the deck
        deck.shuffle();
        display();
        //set score 1 back to 0
        score1 = 0;
        Button p1 = (Button) findViewById(R.id.p1);
        p1.setText(display1 + ": " + score1);
        //set score 2 back to 0
        score2 = 0;
        Button p2 = (Button) findViewById(R.id.p2);
        p2.setText(display2 + ": " + score2);
        //set score 3 back to 0
        score3 = 0;
        Button p3 = (Button) findViewById(R.id.p3);
        p3.setText(display3 + ": " + score3);
        //set score 4 back to 0
        score4 = 0;
        Button p4 = (Button) findViewById(R.id.p4);
        p4.setText(display4 + ": " + score4);
        //set score 5 back to 0
        score5 = 0;
        Button p5 = (Button) findViewById(R.id.p5);
        p5.setText(display5 + ": " + score5);
    }

    public void p1click(View view) {
        //if player 1's button is clicked, add a point
        score1++;
        Button p1 = (Button) findViewById(R.id.p1);
        p1.setText(display1 + ": " + score1);
        //if player 1 reaches 10 points, sends them to win screen
        win();
    }

    public void p2click(View view) {
        //if player 2's button is clicked, add a point
        score2++;
        Button p2 = (Button) findViewById(R.id.p2);
        p2.setText(display2 + ": " + score2);
        //if player 2 reaches 10 points, sends them to win screen
        win();
    }

    public void p3click(View view) {
        //if player 3's button is clicked, add a point
        score3++;
        Button p3 = (Button) findViewById(R.id.p3);
        p3.setText(display3 + ": " + score3);
        //if player 3 reaches 10 points, sends them to win screen
        win();
    }

    public void p4click(View view) {
        //if player 4's button is clicked, add a point
        score4++;
        Button p4 = (Button) findViewById(R.id.p4);
        p4.setText(display4 + ": " + score4);
        //if player 4 reaches 10 points, sends them to win screen
        win();
    }

    public void p5click(View view) {
        //if player 5's button is clicked, add a point
        score5++;
        Button p5 = (Button) findViewById(R.id.p5);
        p5.setText(display5 + ": " + score5);
        //if player 5 reaches 10 points, sends them to win screen
        win();
    }

    //shows the answer in a dialog box with parameter Card c passed
    public void answer(Card c) {
        new AlertDialog.Builder(this)
                //title on dialog box
                .setTitle("Answers")
                //message in dialog box
                .setMessage("Answer 1: " + c.getAnswer1() + "\nAnswer 2: " + c.getAnswer2() + "\nAnswer 3: " + c.getAnswer3())
                //What to do if the button is pressed
                .setPositiveButton("Go!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //do something if they click the button
//otherwise, it just dismisses the dialog
                    }
                }).show();
    }

    //if user clicks on answer button, shows the answer in a dialog box
    public void answerclick(View view) {
        Card c = deck.peek();
        answer(c);
    }

    //sends users to instructions screen
    public void instructions(View view) {
        Intent c = new Intent(this, instructions.class);
        startActivity(c);

        //writes scores to score.txt to save users scores
        try {
            FileOutputStream out = openFileOutput("score.txt", Activity.MODE_PRIVATE);
            out.write(score1);
            out.write(score2);
            out.write(score3);
            out.write(score4);
            out.write(score5);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //checks if names are blank, returns true if it is
    public boolean namecheck(String n1) {
        if (n1.equals(""))
            return true;
        else
            return false;
    }

    //win condition method
    public void win() {
        //if player 1's score is 10, set global variable win to 1
        if (score1 == 10) {
            win = 1;
            //sends user to win screen
            Intent c = new Intent(this, winscreen.class);
            startActivity(c);
            //writes 1 (player 1 win) to whowin.txt, to be used in winscreen
            try {
                FileOutputStream out = openFileOutput("whowin.txt", Activity.MODE_PRIVATE);
                out.write(win);
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //if player 2's score is 10, set global variable win to 2
        else if (score2 == 10) {
            win = 2;
            //sends user to win screen
            Intent c = new Intent(this, winscreen.class);
            startActivity(c);
            //writes 2 (player 2 win) to whowin.txt, to be used in winscreen
            try {
                FileOutputStream out = openFileOutput("whowin.txt", Activity.MODE_PRIVATE);
                out.write(win);
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //if player 3's score is 10, set global variable win to 3
        else if (score3 == 10) {
            win = 3;
            //sends user to win screen
            Intent c = new Intent(this, winscreen.class);
            startActivity(c);
            //writes 3 (player 3 win) to whowin.txt, to be used in winscreen
            try {
                FileOutputStream out = openFileOutput("whowin.txt", Activity.MODE_PRIVATE);
                out.write(win);
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //if player 4's score is 10, set global variable win to 4
        else if (score4 == 10) {
            win = 4;
            //sends user to win screen
            Intent c = new Intent(this, winscreen.class);
            startActivity(c);
            //writes 4 (player 4 win) to whowin.txt, to be used in winscreen
            try {
                FileOutputStream out = openFileOutput("whowin.txt", Activity.MODE_PRIVATE);
                out.write(win);
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //if player 5's score is 10, set global variable win to 5
        else if (score5 == 10) {
            win = 5;
            //sends user to win screen
            Intent c = new Intent(this, winscreen.class);
            startActivity(c);
            //writes 5 (player 5 win) to whowin.txt, to be used in winscreen
            try {
                FileOutputStream out = openFileOutput("whowin.txt", Activity.MODE_PRIVATE);
                out.write(win);
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
