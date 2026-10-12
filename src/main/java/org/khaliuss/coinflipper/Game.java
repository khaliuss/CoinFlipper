package org.khaliuss.coinflipper;

import org.khaliuss.coinflipper.dialog.Dialog;
import org.khaliuss.coinflipper.dialog.IntegerSelectDialog;
import org.khaliuss.coinflipper.models.BetPool;
import org.khaliuss.coinflipper.models.Coin;
import org.khaliuss.coinflipper.models.GameResultAnalyze;
import org.khaliuss.coinflipper.models.players.Bot;
import org.khaliuss.coinflipper.models.players.Player;

import java.util.List;

public class Game {


    private final int MIN = 0;
    private final int MAX = 1;

    private final List<Player> players;
    private final Coin coin;
    private final BetPool betPool = new BetPool();

    public Game(List<Player> players, Coin coin) {
        this.players = players;
        this.coin = coin;
    }

    public void start() {
        Coin.Side side;
        for (Player player : players) {
            if (player instanceof Bot bot) {
                side = inputBetFromBot(bot);
            } else {
                side = inputBetFromRealPlayer(player);
            }
            betPool.put(player, side);
        }

        Coin.Side winSide = coin.toss();
        String winSideName = toStringSideName(winSide);

        System.out.printf("""
                Toss a coin...
                It landed on: %s
                """, winSideName);

        GameResultAnalyze gameResultAnalyze = new GameResultAnalyze(betPool, players, winSide);

        List<Player> winers = gameResultAnalyze.getWiners();
        List<Player> losers = gameResultAnalyze.getLosers();


        printGameResult(winers, losers);


    }

    private Coin.Side inputBetFromRealPlayer(Player player) {
        String title = "%s, please input your toss Head[%d] or Tail[%d]:".formatted(player.getName(), MIN, MAX);
        String error = "Incorrect value!";
        List<Integer> keys = List.of(MIN, MAX);

        Dialog<Integer> dialog = new IntegerSelectDialog(title, error, keys);
        Integer sideKey = dialog.input();
        Coin.Side side = toSide(sideKey);
        return side;
    }

    private Coin.Side inputBetFromBot(Bot bot) {
        String title = "%s, please input your toss Head[%d] or Tail[%d]:".formatted(bot.getName(), MIN, MAX);
        System.out.print(title);
        Coin.Side botBetSide = bot.getBet();
        int sideKey = toSideKey(botBetSide);
        System.out.println(sideKey);
        return botBetSide;
    }

    private int toSideKey(Coin.Side botBetSide) {
        return switch (botBetSide){
            case HEADS ->  MIN;
            case TAILS ->  MAX;
        };
    }

    private void printGameResult(List<Player> winers, List<Player> losers) {
        if (winers.isEmpty()) {
            System.out.println("All players lose!");
        } else if (players.isEmpty()) {
            System.out.println("All players won!");
        } else {
            System.out.print("Winners: ");
            printList(winers);
            System.out.print("Losers: ");
            printList(losers);
        }
    }

    private void printList(List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            System.out.print(players.get(i).getName());
            if (i != players.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    private static Coin.Side toSide(int key) {
        return switch (key) {
            case 0 -> Coin.Side.HEADS;
            case 1 -> Coin.Side.TAILS;
            default -> throw new IllegalStateException("Illegal value " + key);
        };
    }

    private static String toStringSideName(Coin.Side side) {
        return switch (side) {
            case HEADS -> "Head";
            case TAILS -> "Tail";
        };
    }


}
