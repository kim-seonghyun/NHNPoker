package com.nhnpoker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Table {
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
            for (CardRule.Ranks rank: CardRule.Ranks.values()) {
                this.cardList.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(this.cardList);
    }

    private void createUser(int userCount) {
        for (int i = 0; i < userCount; i++) {
            this.userList.add(new User());
        }
    }

    public void startGame(int userCount) {
        this.generateCardPack();
        this.createUser(userCount);
    }
}
