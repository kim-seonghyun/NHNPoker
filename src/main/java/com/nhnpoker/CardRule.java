package com.nhnpoker;

public class CardRule {
    public enum Ranks {
        ONE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        J(11),
        Q(12),
        K(13),
        A(14);

        private final int value;

        Ranks(int value) {
            this.value = value;
        }

        public int getValue(){
            return value;
        }
    }


    public enum Suit {
        Clover(0),
        Diamond(1),
        Heart(2),
        Spade(3);

        public int getValue() {
            return value;
        }

        private final int value;

        Suit(int value){
            this.value = value;
        }

    }

    public enum handRankings {
        HIGHCARD(0),
        ONEPAIR(1),
        TWOPAIR(2),
        TRIPLE(3);

        public int getValue() {
            return value;
        }

        private final int value;
        handRankings(int value) {
            this.value = value;
        }
    }
}
