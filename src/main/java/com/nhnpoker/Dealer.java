package com.nhnpoker;

import java.util.List;

public class Dealer {
    public void dealing(Table table) {
        List<User> userList = table.getUserList();

        for (User user : userList) {
            for (int i = 0; i < 5; i++) {
                user.addCard(table.deleteCard());
            }
        }
    }


    //유저들의 족보
    public User checkUsersHandRanking(List<User> userList) {
        // 유저들의 족보를 확인하고 승자 가리기.
        //
        CardRule.HandRanking highHandRanking = CardRule.HandRanking.HIGHCARD;

        for (User user : userList) {
            if (highHandRanking.getValue() < user.getHandRankings().getHandRanking().getValue()) {
                highHandRanking = user.getHandRankings().getHandRanking();
            }
        }

        CardRule.HandRanking finalHighHandRanking = highHandRanking;
        userList.removeIf(user -> user.getHandRankings().getHandRanking().getValue() < finalHighHandRanking.getValue());

        userList.sort((o1, o2) -> o2.getHandRankings().getHighNumber().getValue() -
                o1.getHandRankings().getHighNumber().getValue());

        return userList.get(0);
    }
}
