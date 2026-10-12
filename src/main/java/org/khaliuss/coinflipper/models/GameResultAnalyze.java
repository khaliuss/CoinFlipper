package org.khaliuss.coinflipper.models;

import java.util.ArrayList;
import java.util.List;

public class GameResultAnalyze {

    private final BetPool betPool;
    private final List<Player> players;
    private final Coin.Side winSide;

    public GameResultAnalyze(BetPool betPool, List<Player> players, Coin.Side winSide) {
        this.betPool = betPool;
        this.players = players;
        this.winSide = winSide;
    }

    public List<Player> getWiners(){
        return getPlayers(winSide);
    }

    public List<Player> getLosers(){
        Coin.Side loseSide = (winSide == Coin.Side.HEADS) ? Coin.Side.TAILS : Coin.Side.HEADS;
        return getPlayers(loseSide);
    }

    private List<Player> getPlayers(Coin.Side side) {
        List<Player> out = new ArrayList<>();
        for (Player player : players){
            Coin.Side playerBetSide = betPool.get(player);
            if (playerBetSide == side){
                out.add(player);
            }
        }
        return out;
    }


}
