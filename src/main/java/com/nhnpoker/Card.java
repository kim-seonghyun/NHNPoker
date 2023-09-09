package com.nhnpoker;

public class Card extends CardRule{
    private Suit suit;
    private Ranks rank;

    public Card(Suit suit, Ranks rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Ranks getRank() {
        return rank;
    }
}
