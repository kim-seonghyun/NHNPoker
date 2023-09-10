package com.nhnpoker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PokerShell {
    private static final Logger logger = LoggerFactory.getLogger(PokerShell.class);

    public static void main(String[] args) {
        Table table = new Table();
        table.startGame();

        Dealer dealer = new Dealer();

        dealer.dealing(table);
        table.printPlayersHand();
        User winner = dealer.checkUsersHandRanking(table.getUserList());
        table.declaredWinner(winner);
    }
}
