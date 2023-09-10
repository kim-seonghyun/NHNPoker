package com.nhnpoker;

public class CardRule {
    public enum Rank {
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

        Rank(int value) {
            this.value = value;
        }

        public int getValue() {
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

        Suit(int value) {
            this.value = value;
        }

    }

    public enum HandRanking {
        HIGHCARD(0),
        ONEPAIR(1),
        TWOPAIR(2),
        TRIPLE(3);

        public int getValue() {
            return value;
        }

        private final int value;

        HandRanking(int value) {
            this.value = value;
        }
    }

    public static class HandRankingAndHighNumber {
        private HandRanking handRanking;
        private Rank highNumber;

        public HandRankingAndHighNumber(HandRanking handRanking, Rank highNumber) {
            this.handRanking = handRanking;
            this.highNumber = highNumber;
        }

        public HandRanking getHandRanking() {
            return handRanking;
        }

        public Rank getHighNumber() {
            return highNumber;
        }
    }


}
