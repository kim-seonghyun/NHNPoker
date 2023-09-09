package com.nhnpoker;

public class PokerShell {
    public static void main(String[] args) {
        Table table = new Table();

        table.generateCardPack();
        Dealer dealer = new Dealer();

        dealer.dealing(table);

        dealer.checkUsersHandRanking(table);

    }
}
