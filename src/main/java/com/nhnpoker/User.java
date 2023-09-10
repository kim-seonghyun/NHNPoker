package com.nhnpoker;

import java.util.ArrayList;
import java.util.Comparator;

public class User {
    private final ArrayList<Card> cardList = new ArrayList<>();

    public String getUserName() {
        return userName;
    }

    public CardRule.HandRankingAndHighNumber getHandRankings() {
        cardList.sort(Comparator.comparingInt(o -> o.getRank().getValue()));
        //변수 2개 가지고 pair 개수를 확인할 수 있다.
        //같은 숫자 카드 개수
        int sameRankCardCounter = 0;
        //pair 개수
        int pairCardCounter = 1;
        CardRule.Rank previousRank = null;

        CardRule.Rank highNumber = CardRule.Rank.ONE;


        for (Card card : cardList) {
            if (previousRank == null) {
                previousRank = card.getRank();
                continue;
            }

            if (previousRank.getValue() == card.getRank().getValue()) {
                pairCardCounter++;
                if (highNumber.getValue() <= card.getRank().getValue()) {
                    highNumber = card.getRank();
                }
            } else {
                if (pairCardCounter >= 2) {
                    sameRankCardCounter++;
                    if (highNumber.getValue() <= previousRank.getValue()) {
                        highNumber = previousRank;
                    }
                }
                previousRank = card.getRank();
                pairCardCounter = 1;
            }
        }

        if (pairCardCounter >= 2) {
            sameRankCardCounter++;
            if (highNumber.getValue() <= previousRank.getValue()) {
                highNumber = previousRank;
            }
        }

        if (sameRankCardCounter == 1) {
            return new CardRule.HandRankingAndHighNumber(CardRule.HandRanking.ONEPAIR, highNumber);
        } else if (sameRankCardCounter == 2) {
            return new CardRule.HandRankingAndHighNumber(CardRule.HandRanking.TWOPAIR, highNumber);
        } else {
            highNumber = cardList.get(cardList.size() - 1).getRank();
            return new CardRule.HandRankingAndHighNumber(CardRule.HandRanking.HIGHCARD, highNumber);
        }
    }

    public User(String userName) {
        this.userName = userName;
    }

    private final String userName;

    //카드를 가져옴.
    public void addCard(Card card) {
        this.cardList.add(card);
    }

}
