package org.khaliuss.coinflipper.models;

import java.util.HashMap;
import java.util.Map;

public class BetPool {
    private final Map<Player,Coin.Side> bets;

    public BetPool() {
        this.bets = new HashMap<Player,Coin.Side>();
    }

    public void put(Player player,Coin.Side side) {
        bets.put(player,side);
    }

    public Coin.Side get(Player player) {
        Coin.Side side = bets.get(player);
        if (side == null){
            throw new IllegalArgumentException("BetPool doesn't contain player: "+player);
        }
        return side;
    }


}
