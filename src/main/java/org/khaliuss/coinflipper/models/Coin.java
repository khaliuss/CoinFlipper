package org.khaliuss.coinflipper.models;

import java.util.Random;

public class Coin {

    public Side toss(){
        Random random = new Random();
        int sideNumber = random.nextInt(Side.values().length);
        return Side.values()[sideNumber];
    }

    public enum Side {
        HEADS, TAILS;
    }
}
