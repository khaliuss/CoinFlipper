package org.khaliuss.coinflipper;

import org.khaliuss.coinflipper.dialog.Dialog;
import org.khaliuss.coinflipper.dialog.IntegerMinMaxDialog;
import org.khaliuss.coinflipper.models.Coin;
import org.khaliuss.coinflipper.models.players.Player;

import java.util.ArrayList;
import java.util.List;

public class GameRunner {

    private final static String GAME_TITLE = """
            \u001B[32m
            *******************
            *     Heads       *
            *       &         *
            *     Tails       *
            *******************
            \u001B[0m
            """;

    private final static int MAX_PLAYERS=10;
    private final static int MIN_PLAYERS=1;

    static void main() {

        System.out.println(GAME_TITLE);

        Dialog<Integer> dialog = new IntegerMinMaxDialog(
                "Input quantity of players min[%d] max[%d]: ".formatted(MIN_PLAYERS,MAX_PLAYERS),
                "Pleas input correct value!",
                MIN_PLAYERS,
                MAX_PLAYERS
        );
        
        Integer amount = dialog.input();
        List<Player> players = creatPlayers(amount);
        Coin coin = new Coin();

        Game game = new Game(players,coin);
        game.start();

    }

    private static List<Player> creatPlayers(int amount){
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            players.add(new Player("Player "+i));
        }
        return players;
    }


}


