package org.khaliuss.coinflipper.models.players;

import org.khaliuss.coinflipper.models.Coin;

import java.util.Random;

public class Bot extends Player{

    public Bot(String name) {
        super(name);
    }

    public Coin.Side getBet(){
        Random random = new Random();
        int sideNumber = random.nextInt(Coin.Side.values().length);
        return Coin.Side.values()[sideNumber];
    }


}
