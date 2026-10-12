package org.khaliuss.coinflipper;


import org.khaliuss.coinflipper.models.BetPool;
import org.khaliuss.coinflipper.models.Coin;
import org.khaliuss.coinflipper.models.Player;

public class MainTest {

    static void main() {
        /*Coin coin = new Coin();

        for (int i = 0; i < 20; i++) {
            System.out.println(coin.toss());
        }*/

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player player3 = new Player("Player 3");
        Coin coin = new Coin();

        BetPool betPool = new BetPool();
        betPool.put(player1,coin.toss());
        betPool.put(player2,coin.toss());

        System.out.printf("%s: %s\n",player1.getName(),betPool.get(player1));
        System.out.printf("%s: %s\n",player2.getName(),betPool.get(player2));
        System.out.printf("%s: %s\n",player3.getName(),betPool.get(player3));


    }


}
