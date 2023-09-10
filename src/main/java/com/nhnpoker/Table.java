package com.nhnpoker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Table {
    private static final Logger logger = LoggerFactory.getLogger(Table.class);
    private final ArrayList<Card> cardList = new ArrayList<>();
    private final ArrayList<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }


    //삭제된 카드.
    public Card deleteCard() {
        if (cardList.isEmpty()) {
            throw new IllegalArgumentException("카드가 없습니다.");
        }
        return cardList.remove(0);
    }

    //카드 생성 후 shuffle
    private void generateCardPack() {
        for (CardRule.Suit suit : CardRule.Suit.values()) {
            for (CardRule.Rank rank : CardRule.Rank.values()) {
                this.cardList.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(this.cardList);
    }

    private void createUser() {
        Scanner sc = new Scanner(System.in);
        logger.info("플레이어의 이름을 공백으로 구분하여 적어주세요");

        String input = sc.nextLine();
        String[] names = input.split(" ");
        for (String name : names) {
            this.userList.add(new User(name));
        }
    }

    public void startGame() {

        this.generateCardPack();
        this.createUser();
    }

    public void declaredWinner(User winner) {
        logger.info(winner.getUserName() + "님이 " + winner.getHandRankings().getHandRanking() + " " + winner.getHandRankings().getHighNumber()+ "으로 승리하셨습니다");
    }

    public void printPlayersHand() {
        for (User user : this.userList) {
            logger.info(user.getUserName() + "님 :" + user.getHandRankings().getHandRanking() + " " +
                    user.getHandRankings().getHighNumber() + "을 가지고 있습니다");
        }
    }
}
