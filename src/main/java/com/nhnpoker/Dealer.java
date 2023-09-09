package com.nhnpoker;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    public void dealing(Table table){
        List<User> userList =  table.getUserList();

        for(User user: userList) {
            for (int i = 0; i < 5; i++) {
                user.addCard(table.deleteCard());
            }
        }
    }


    //유저들의 족보
    public void checkUsersHandRanking(Table table){

    }
}
