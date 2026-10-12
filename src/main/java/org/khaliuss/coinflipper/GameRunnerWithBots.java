package org.khaliuss.coinflipper;

import org.khaliuss.coinflipper.models.Coin;
import org.khaliuss.coinflipper.models.players.Bot;

import java.util.List;

public class GameRunnerWithBots {


    static void main() {
        Bot bot1 = new Bot("Bot 1");
        Bot bot2 = new Bot("Bot 2");
        Bot bot3 = new Bot("Bot 3");

        Coin coin = new Coin();

        Game game = new Game(List.of(bot1,bot2,bot3),coin);
        game.start();
    }
}


