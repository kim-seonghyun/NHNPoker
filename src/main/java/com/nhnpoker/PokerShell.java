package com.nhnpoker;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PokerShell {
    private static final Logger logger = LoggerFactory.getLogger(PokerShell.class);

    public static void main(String[] args) {
        logger.info("몇명의 플레이어가 있나요?");
        Scanner sc = new Scanner(System.in);
        int userCount = sc.nextInt();

        Table table = new Table();
        table.startGame(userCount);

        Dealer dealer = new Dealer();

        dealer.dealing(table);

        dealer.checkUsersHandRanking(table);

        sc.close();
    }
}
