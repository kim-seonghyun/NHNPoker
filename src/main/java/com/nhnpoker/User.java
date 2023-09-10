package com.nhnpoker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private final ArrayList<Card> cardList = new ArrayList<>();

    public String getUserName() {
        return userName;
    }
    public Map<CardRule.handRankings, CardRule.Ranks> getHandRankings() {
        cardList.sort(Comparator.comparingInt(o -> o.getRank().getValue()));
        //변수 2개 가지고 pair 개수를 확인할 수 있다.
        //같은 숫자 카드 개수
        int sameRankCardCounter = 0;
        //pair 개수
        int pairCardCounter = 1;
        CardRule.Ranks previousRank = null;

        CardRule.Ranks highNumber = CardRule.Ranks.ONE;


        for (Card card : cardList) {
            if(previousRank == null){
                previousRank = card.getRank();
                continue;
            }

            if(previousRank.getValue() == card.getRank().getValue()){
                pairCardCounter++;
                if(highNumber.getValue() <= card.getRank().getValue()){
                    highNumber =card.getRank();
                }
            }else{
                if(pairCardCounter >=2){
                    sameRankCardCounter++;
                    if(highNumber.getValue() <= previousRank.getValue()){
                        highNumber =previousRank;
                    }
                }
                previousRank = card.getRank();
                pairCardCounter = 1;
            }
        }

        if(pairCardCounter >=2){
            sameRankCardCounter++;
            if(highNumber.getValue() <= previousRank.getValue()){
                highNumber = previousRank;
            }
        }

        Map<CardRule.handRankings, CardRule.Ranks> map = new HashMap();


        if(sameRankCardCounter == 1){
            map.put(CardRule.handRankings.ONEPAIR, highNumber);
            return map;
        }else if(sameRankCardCounter == 2){
            map.put(CardRule.handRankings.TWOPAIR, highNumber);
            return map;
        }else{
            highNumber = cardList.get(cardList.size()-1).getRank();
            map.put(CardRule.handRankings.HIGHCARD, highNumber);
            return map;
        }
    }

    private String userName;
    private String handRankings;

    //카드를 가져옴.
    public void addCard(Card card) {
        this.cardList.add(card);
    }

    // 족보 확인
    public void checkHandRankings() {

    }
}
