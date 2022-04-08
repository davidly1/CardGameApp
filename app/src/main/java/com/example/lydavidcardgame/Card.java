package com.example.lydavidcardgame;

//Name: David Ly
//Date: January 29, 2021
//Purpose: Unit 7 Project - Card Game

public class Card {
    private int picnum;
    private String clue1;
    private String clue2;
    private String clue3;
    private String hint;
    private String answer1;
    private String answer2;
    private String answer3;

    public Card() {
        int picnums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72};
        String clues1[] = {"A black liquid used to make gasoline", "He marries the bride", "Something you do in this game", "Something that forms on a skinned knee", "Another word for a pig's nose", "A kind of flower", "Another word for a rabbit", "The sound a cow makes", "A metal necklace", "A drink prepared by a wizard", "What bees do if you make them mad", "Worn on a king's head", "A measurement on a ruler", "Something you sleep on", "The brothers orville and wilbur", "Part of an egg", "What seven days equal", "A preserved cucumber", "This is waved at the winning race car", "To move to music", "Not as strong", "The opposite of save", "A game played on ice", "Something you do on a keyboard", "Something you read", "A vegetable that is on a cob", "A brace for a broken bone", "The opposite of empty", "Two of a kind", "Something that travels on water", "An instructor in school", "A person who is not an adult", "A heavy snow storm", "The opposite of give", "A very large animal similar to an elk", "The opposite of present", "You wear this on halloween", "What you do with your tongue", "A light shade of hair", "The back part of your foot", "It hangs upside down in a cave", "Something you wear on your foot", "Where a kangaroo carries her baby", "What you do on a phone", "To take something that's not yours'", "An ice cream holder that you eat", "Something from which you eat corn", "A buck or a doe", "A sweet breath freshener", "A nickname for robert", "A can of fishing worms", "Knock over a glass of milk", "A teacher helps you do this", "The 1st letter of the alphabet", "The opposite of short", "To ride on a plane", "The upper part of your leg", "These are used to hear sounds", "A baby's toy", "Something on the side of your head", "A round object used in sports", "Another word for your belly", "A walk in the woods", "A baby deer", "Going too fast in a car", "Something you send to a friend on his or her birthday", "You wave this to say goodbye", "What a candle is made from", "You breathe it through your nose", "The price of something", "Something you walk up or down", "A cardboard container"};
        String clues2[] = {"To heat water until it bubbles", "A loud thundering sound", "A green citrus fruit", "A place where you do experiments", "Someone who is always prepared", "When you don't feel like doing anything", "Two rabbits", "The sound a ghost makes", "A narrow street", "A hand and body cream", "What bells do when shaken", "The opposite of up", "To squeeze between your fingers", "Something you ride on in the snow", "The U.S. president's house", "Something fire makes", "The top of a mountain", "A way to make something laugh", "A game where You're it", "The eiffel tower is found in this country", "Produces the sound from your computer", "The opposite of beginning", "A person who rides a race horse", "A tube that water flows through", "To prepare food", "A car's warning device", "A violent explosion", "The opposite of push", "To look without blinking", "To drift on water", "An animal in a scary movie", "An animal that is not tame", "A sorcerer", "The opposite of real", "An orange breakfast drink", "The opposite of first", "To state a question", "The garbage you throw away", "A small body of water", "The outer part of an orange", "It's a house pet that purrs", "What you do to get someone to open a door", "What you say when you stub your toe", "A teacher's erasable writing marker", "To pass out playing cards", "A communication device", "Something you turn to open a door", "A 12-month period", "A suggestion to help you get an answer", "A handle on a drawer", "A door in a fence", "Something that's hard to climb with your bike", "Logs do this in a fire", "The 10th letter of the alphabet", "The opposite of right", "To produce tears", "To tint eggs", "Sounds made to support your team", "To tell on someone ", "Something underneath your back pocket", "A passageway in school", "Something delicious", "A hard hit in volleyball", "The grass around a house", "Being in front during a race", "Someone who watches over prisoners", "You do this at the end of a plane ride", "What a lumberjack uses", "It grows on your head", "A light coating of ice on a window", "Furniture that is placed around the table", "A sly animal of the forest"};
        String clues3[] = {"Another word for dirt", "It's used to sweep the floor", "An act that is against the law", "To take something quickly", "The opposite of in", "When you are acting nutty", "A rabbit trap", "The sound you make to chase something away", "Not fancy", "A large body of salt water", "What birds do in the morning", "A bride's dress", "He stole christmas", "Something that sits on your shoulders", "Ben franklin flew one", "Something that makes you laugh", "A bird's mouth", "A very slow flow of water", "A plastic carrier for your groceries", "The possibility of something happening", "A glass container used in a laboratory", "The opposite of enemy", "A U.S. mountain range", "Something on a skunk's back", "To see", "A prickly part of a rose bush", "A tall pole on a boat that holds a sail", "The opposite of a cow", "To play with each other's toys", "A water-filled ditch around a castle", "A church minister", "A salsa that is not hot", "A reptile", "To cook in the oven", "The opposite of tight", "The opposite of slow", "A chore you have to do", "The white glue you use for crafts", "A magical stick", "The part of a fishing rod that you wind", "It keeps your head warm", "Something that beats scissors but not paper", "Where you sit to watch tv", "Put one foot in front of the other", "To touch something", "An exact copy of you", "Something you do when you cry for a long time", "A water droplet from the eye", "To look with eyes partly closed", "A very messy person", "Not on time", "A porcupine's needle", "To move in a different direction", "The 11th letter of the alphabet", "The opposite of weak", "The opposite of wet", "A dessert with a crust", "Gets closer", "A fight in a war", "Something on your ten-speed bike", "A room divider", "A preserved body of an ancient egyptian", "A lightning hit", "Something you do when you're tired or bored", "Giving a worm to a baby bird", "Something that is difficult", "You do this on two feet", "What you eat between meals", "When everyone plays by the same rules", "When you don't know where you are", "Grizzly animals", "An animal that pulls a cart"};
        String hints[] = {"Rhymes with coil", "Rhymes with zoom", "Rhymes with time", "Rhymes with cab", "Rhymes with pout", "Rhymes with hazy", "Rhymes with dare", "Rhymes with do", "Rhymes with rain", "Rhymes with motion", "Rhymes with king", "Rhymes with frown", "Rhymes with finch", "Rhymes with red", "Rhymes with fight", "Rhymes with poke", "Rhymes with leak", "Rhymes with fickle", "Rhymes with rag", "Rhymes with glance", "Rhymes with seeker", "Rhymes with bend", "Rhymes with stocky", "Rhymes with wipe", "Rhymes with hook", "Rhymes with born", "Rhymes with fast", "Rhymes with wool", "Rhymes with air", "Rhymes with goat", "Rhymes with feature", "Rhymes with piled", "Rhymes with gizzard", "Rhymes with make", "Rhymes with goose", "Rhymes with cast", "Rhymes with bask", "Rhymes with haste", "Rhymes with bond", "Rhymes with steel", "Rhymes with rat", "Rhymes with lock", "Rhymes with grouch", "Rhymes with squawk", "Rhymes with meal", "Rhymes with bone", "Rhymes with job", "Rhymes with fear", "Rhymes with lint", "Rhymes with sob", "Rhymes with date", "Rhymes with bill", "Rhymes with churn", "Rhymes with day", "Rhymes with song", "Rhymes with shy", "Rhymes with my", "Rhymes with fears", "Rhymes with cattle", "Rhymes with near", "Rhymes with tall", "Rhymes with dummy", "Rhymes with like", "Rhymes with dawn", "Rhymes with reading", "Rhymes with yard", "Rhymes with band", "Rhymes with tax", "Rhymes with pair", "Rhymes with crossed", "Rhymes with pairs", "Rhymes with locks"};
        String answers1[] = {"oil", "groom", "rhyme", "scab", "snout", "daisy", "hare", "moo", "chain", "potion", "sting", "crown", "inch", "bed", "wright", "yolk", "week", "pickle", "flag", "dance", "weaker", "spend", "hockey", "type", "book", "corn", "cast", "full", "pair", "boat", "teacher", "child", "blizzard", "take", "moose", "past", "mask", "taste", "blonde", "heel", "bat", "sock", "pouch", "talk", "steal", "cone", "cob", "deer", "mint", "bob", "bait", "spill", "leark", "a", "long", "fly", "thigh", "ears", "rattle", "ear", "ball", "tummy", "hike", "fawn", "speeding", "card", "hand", "wax", "air", "cost", "stairs", "box"};
        String answers2[] = {"boil", "boom", "lime", "lab", "scout", "lazy", "pair", "boo", "lane", "lotion", "ring", "down", "pinch", "sled", "white", "smoke", "peak", "tickle", "tag", "france", "speaker", "end", "jockey", "pipe", "cook", "horn", "blast", "pull", "stare", "float", "creature", "wild", "wizard", "fake", "juice", "last", "ask", "waste", "pond", "peel", "cat", "knock", "ouch", "chalk", "deal", "phone", "knob", "year", "hint", "knob", "gate", "hill", "burn", "j", "wrong", "cry", "dye", "cheers", "tattle", "rear", "hall", "yummy", "spike", "lawn", "leading", "guard", "land", "axe", "hair", "frost", "chairs", "fox"};
        String answers3[] = {"soil", "broom", "crime", "grab", "out", "crazy", "snare", "shoo", "plain", "ocean", "sing", "gown", "grinch", "head", "kite", "joke", "beak", "trickle", "bag", "chance", "beaker", "friend", "rocky", "stripe", "look", "thorn", "mast", "bull", "share", "moat", "preacher", "mild", "lizard", "bake", "loose", "fast", "task", "paste", "wand", "reel", "hat", "rock", "couch", "walk", "feel", "clone", "sob", "tear", "squint", "slob", "late", "quill", "turn", "k", "strong", "dry", "pie", "nears", "battle", "gear", "wall", "mummy", "strike", "yawn", "feeding", "hard", "stand", "snacks", "fair", "lost", "bears", "ox"};
        int rand = (int) (Math.random() * clues1.length);
        picnum = picnums[rand];
        clue1 = clues1[rand];
        clue2 = clues2[rand];
        clue3 = clues3[rand];
        hint = hints[rand];
        answer1 = answers1[rand];
        answer2 = answers2[rand];
        answer3 = answers3[rand];
    }

    public Card(int pnum, String c1, String c2, String c3, String h, String a1, String a2, String a3) {
        picnum = pnum;
        clue1 = c1;
        clue2 = c2;
        clue3 = c3;
        hint = h;
        answer1 = a1;
        answer2 = a2;
        answer3 = a3;
    }

    public void setPicnum(int pnum) {
        picnum = pnum;
    }

    public void setClue1(String c1) {
        clue1 = c1;
    }

    public void setClue2(String c2) {
        clue2 = c2;
    }

    public void setClue3(String c3) {
        clue3 = c3;
    }

    public void setHint(String h) {
        hint = h;
    }

    public void setAnswer1(String a1) {
        answer1 = a1;
    }

    public void setAnswer2(String a2) {
        answer2 = a2;
    }

    public void setAnswer3(String a3) {
        answer3 = a3;
    }

    public int getPicnum() {
        return picnum;
    }

    public String getClue1() {
        return clue1;
    }

    public String getClue2() {
        return clue2;
    }

    public String getClue3() {
        return clue3;
    }

    public String getHint() {
        return hint;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }


    public boolean equals(Card r) {
        if (r.getClue1().equals(clue1) && r.getClue2().equals(clue2) && r.getClue3().equals(clue3) && r.getPicnum() == picnum && r.getHint().equals(hint) && r.getAnswer1().equals(answer1) && r.getAnswer2().equals(answer2) && r.getAnswer3().equals(answer3))
            return true;
        else
            return false;
    }

    public int compareTo(Card r) {
        //if they are equal return 0, otherwise return based on relative areas
        if (r.equals(this))
            return 0;
        else if (r.picnum > this.picnum)
            return -1;
        else
            return 1;
    }

    public String toString() {
        return "Clue 1 =" + clue1 + ", Clue 2 =" + clue2 + ", Clue 3 =" + clue3 + "\n Hint =" + hint + "\n Answers =" + answer1 + ", " + answer2 + ", " + answer3;
    }


}
