import com.nhnpoker.Card;
import com.nhnpoker.CardRule;
import com.nhnpoker.Table;
import com.nhnpoker.User;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class POKERTest {
    @Test
    @DisplayName("카드팩 생성 메서드 테스트")
    void testGeneratedCardPack() {
        ArrayList<Card> cardList = new ArrayList<>();

        for (CardRule.Suit suit : CardRule.Suit.values()) {
            for (CardRule.Ranks rank : CardRule.Ranks.values()) {
                cardList.add(new Card(suit, rank));
            }
        }
        Card card1 = new Card(CardRule.Suit.Clover, CardRule.Ranks.ONE);
        Card card2 = new Card(CardRule.Suit.Clover, CardRule.Ranks.FIVE);
        Assertions.assertEquals(cardList.get(0).getSuit(), card1.getSuit());
        Assertions.assertEquals(cardList.get(4).getRank(), card2.getRank());
    }

    // Dealer.dealing 테스트
    void testDealing() {

    }

    @Test
    @DisplayName("delete Card 테스트")
    void testDeleteCard() {
        ArrayList<Card> cardList = new ArrayList<>();
        Card card1 = new Card(CardRule.Suit.Clover, CardRule.Ranks.FIVE);
        Card card2 = new Card(CardRule.Suit.Clover, CardRule.Ranks.J);
        cardList.add(card1);
        cardList.add(card2);

        Assertions.assertEquals(cardList.remove(0).getSuit(), card1.getSuit());
    }

    @Test
    @DisplayName("delete Card Under flow 테스트")
    void testDeleteCard_underflow() {
        Table table = new Table();
        Assertions.assertThrows(IllegalArgumentException.class, table::deleteCard);
    }
    // Dealer.checkUsersHandRanking 게임 결과 확인 체크

    @Test
    @DisplayName("add Card 테스트")
    void testAddCard() {
        ArrayList<Card> cardList = new ArrayList<>();
        Card card = new Card(CardRule.Suit.Heart, CardRule.Ranks.ONE);
        cardList.add(card);

        Assertions.assertEquals(cardList.get(0).getRank(), card.getRank());
    }

    // User.checkHandRankings 족보 판별 테스트
    @Test
    @DisplayName("checkHandRankings 투페어, 높은숫자")
    void testCheckHandRankings() {
        User user = new User();
        Card card1 = new Card(CardRule.Suit.Heart, CardRule.Ranks.Q);
        Card card2 = new Card(CardRule.Suit.Diamond, CardRule.Ranks.Q);
        Card card3 = new Card(CardRule.Suit.Heart, CardRule.Ranks.FIVE);
        Card card4 = new Card(CardRule.Suit.Clover, CardRule.Ranks.FIVE);
        Card card5 = new Card(CardRule.Suit.Heart, CardRule.Ranks.FIVE);

        user.addCard(card1);
        user.addCard(card2);
        user.addCard(card3);
        user.addCard(card4);
        user.addCard(card5);
        Assertions.assertEquals(CardRule.Ranks.Q, user.getHandRankings().get(CardRule.handRankings.TWOPAIR));
    }

    @Test
    @DisplayName("checkHandRankings 원페어 높은숫자")
    void testCheckHandRankingsOnepair() {
        User user = new User();
        Card card1 = new Card(CardRule.Suit.Heart, CardRule.Ranks.Q);
        Card card2 = new Card(CardRule.Suit.Diamond, CardRule.Ranks.TWO);
        Card card3 = new Card(CardRule.Suit.Heart, CardRule.Ranks.FIVE);
        Card card4 = new Card(CardRule.Suit.Clover, CardRule.Ranks.FIVE);
        Card card5 = new Card(CardRule.Suit.Heart, CardRule.Ranks.FIVE);

        user.addCard(card1);
        user.addCard(card2);
        user.addCard(card3);
        user.addCard(card4);
        user.addCard(card5);
        Assertions.assertEquals(CardRule.Ranks.FIVE, user.getHandRankings().get(CardRule.handRankings.ONEPAIR));
    }

    @Test
    @DisplayName("checkHandRankings 하이카드 높은숫자")
    void testCheckHandRankingsHighCard() {
        User user = new User();
        Card card1 = new Card(CardRule.Suit.Heart, CardRule.Ranks.Q);
        Card card2 = new Card(CardRule.Suit.Diamond, CardRule.Ranks.TWO);
        Card card3 = new Card(CardRule.Suit.Heart, CardRule.Ranks.NINE);
        Card card4 = new Card(CardRule.Suit.Clover, CardRule.Ranks.K);
        Card card5 = new Card(CardRule.Suit.Heart, CardRule.Ranks.A);

        user.addCard(card1);
        user.addCard(card2);
        user.addCard(card3);
        user.addCard(card4);
        user.addCard(card5);
        Assertions.assertEquals(CardRule.Ranks.A, user.getHandRankings().get(CardRule.handRankings.HIGHCARD));
    }
}
