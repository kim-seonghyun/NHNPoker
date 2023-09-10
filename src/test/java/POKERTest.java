import com.nhnpoker.Card;
import com.nhnpoker.CardRule;
import com.nhnpoker.Dealer;
import com.nhnpoker.Table;
import com.nhnpoker.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class POKERTest {
    @Test
    @DisplayName("유저 생성 테스트")
    void testStartGame() {


        List<User> userList = new ArrayList<>();
        String input = "김성현 현성김";
        String[] names = input.split(" ");
        for (String name : names) {
            userList.add(new User(name));
        }
        Assertions.assertEquals("현성김", userList.get(1).getUserName());
    }


    @Test
    @DisplayName("카드팩 생성 메서드 테스트")
    void testGeneratedCardPack() {
        ArrayList<Card> cardList = new ArrayList<>();

        for (CardRule.Suit suit : CardRule.Suit.values()) {
            for (CardRule.Rank rank : CardRule.Rank.values()) {
                cardList.add(new Card(suit, rank));
            }
        }
        Card card1 = new Card(CardRule.Suit.Clover, CardRule.Rank.ONE);
        Card card2 = new Card(CardRule.Suit.Clover, CardRule.Rank.FIVE);
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
        Card card1 = new Card(CardRule.Suit.Clover, CardRule.Rank.FIVE);
        Card card2 = new Card(CardRule.Suit.Clover, CardRule.Rank.J);
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
    @DisplayName("딜러 , 게임 결과 확인 메서드")
    void testcheckUsersHandRanking() {
        User user1 = new User("김성현");
        Card card1 = new Card(CardRule.Suit.Heart, CardRule.Rank.Q);
        Card card2 = new Card(CardRule.Suit.Diamond, CardRule.Rank.Q);
        Card card3 = new Card(CardRule.Suit.Heart, CardRule.Rank.FIVE);
        Card card4 = new Card(CardRule.Suit.Clover, CardRule.Rank.FIVE);
        Card card5 = new Card(CardRule.Suit.Heart, CardRule.Rank.FIVE);

        user1.addCard(card1);
        user1.addCard(card2);
        user1.addCard(card3);
        user1.addCard(card4);
        user1.addCard(card5);

        User user2 = new User("현성김");
        Card card6 = new Card(CardRule.Suit.Heart, CardRule.Rank.Q);
        Card card7 = new Card(CardRule.Suit.Diamond, CardRule.Rank.Q);
        Card card8 = new Card(CardRule.Suit.Heart, CardRule.Rank.A);
        Card card9 = new Card(CardRule.Suit.Clover, CardRule.Rank.J);
        Card card10 = new Card(CardRule.Suit.Heart, CardRule.Rank.K);

        user2.addCard(card6);
        user2.addCard(card7);
        user2.addCard(card8);
        user2.addCard(card9);
        user2.addCard(card10);

        ArrayList<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        Dealer dealer = new Dealer();
        User winner = dealer.checkUsersHandRanking(userList);

        Assertions.assertEquals("김성현", winner.getUserName());
        Assertions.assertEquals(CardRule.HandRanking.TWOPAIR, winner.getHandRankings().getHandRanking());
        Assertions.assertEquals(CardRule.Rank.Q, winner.getHandRankings().getHighNumber());
    }


    @Test
    @DisplayName("add Card 테스트")
    void testAddCard() {
        ArrayList<Card> cardList = new ArrayList<>();
        Card card = new Card(CardRule.Suit.Heart, CardRule.Rank.ONE);
        cardList.add(card);

        Assertions.assertEquals(cardList.get(0).getRank(), card.getRank());
    }

    // User.checkHandRankings 족보 판별 테스트
    @Test
    @DisplayName("checkHandRankings 투페어, 높은숫자")
    void testCheckHandRankings() {
        User user = new User("김성현");
        Card card1 = new Card(CardRule.Suit.Heart, CardRule.Rank.Q);
        Card card2 = new Card(CardRule.Suit.Diamond, CardRule.Rank.Q);
        Card card3 = new Card(CardRule.Suit.Heart, CardRule.Rank.FIVE);
        Card card4 = new Card(CardRule.Suit.Clover, CardRule.Rank.FIVE);
        Card card5 = new Card(CardRule.Suit.Heart, CardRule.Rank.FIVE);

        user.addCard(card1);
        user.addCard(card2);
        user.addCard(card3);
        user.addCard(card4);
        user.addCard(card5);
        Assertions.assertEquals(CardRule.Rank.Q, user.getHandRankings().getHighNumber());
    }

    @Test
    @DisplayName("checkHandRankings 원페어 높은숫자")
    void testCheckHandRankingsOnepair() {
        User user = new User("김성현");
        Card card1 = new Card(CardRule.Suit.Heart, CardRule.Rank.Q);
        Card card2 = new Card(CardRule.Suit.Diamond, CardRule.Rank.TWO);
        Card card3 = new Card(CardRule.Suit.Heart, CardRule.Rank.FIVE);
        Card card4 = new Card(CardRule.Suit.Clover, CardRule.Rank.FIVE);
        Card card5 = new Card(CardRule.Suit.Heart, CardRule.Rank.FIVE);

        user.addCard(card1);
        user.addCard(card2);
        user.addCard(card3);
        user.addCard(card4);
        user.addCard(card5);
        Assertions.assertEquals(CardRule.Rank.FIVE, user.getHandRankings().getHighNumber());
    }

    @Test
    @DisplayName("checkHandRankings 하이카드 높은숫자")
    void testCheckHandRankingsHighCard() {
        User user = new User("김성현");
        Card card1 = new Card(CardRule.Suit.Heart, CardRule.Rank.Q);
        Card card2 = new Card(CardRule.Suit.Diamond, CardRule.Rank.TWO);
        Card card3 = new Card(CardRule.Suit.Heart, CardRule.Rank.NINE);
        Card card4 = new Card(CardRule.Suit.Clover, CardRule.Rank.K);
        Card card5 = new Card(CardRule.Suit.Heart, CardRule.Rank.A);

        user.addCard(card1);
        user.addCard(card2);
        user.addCard(card3);
        user.addCard(card4);
        user.addCard(card5);
        Assertions.assertEquals(CardRule.Rank.A, user.getHandRankings().getHighNumber());
    }
}
