package com.nhnpoker;

public class Card extends CardRule{
    private Suit suit;
    private String rank;

    public Card(Suit suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }
}
