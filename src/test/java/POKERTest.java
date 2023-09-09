import com.nhnpoker.Card;
import com.nhnpoker.CardRule;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class POKERTest {
    @Test
    @DisplayName("카드팩 생성 메서드 테스트")
    void testGeneratedCardPack(){
        ArrayList<Card> cardList = new ArrayList<>();

        for (CardRule.Suit suit : CardRule.Suit.values()) {
            for (String rank : CardRule.ranks) {
                cardList.add(new Card(suit, rank));
            }
        }
        Card card1= new Card(CardRule.Suit.Clover, CardRule.ranks[1]);
        Card card2 = new Card(CardRule.Suit.Clover, CardRule.ranks[5]);
        Assertions.assertEquals(cardList.get(1).getSuit(), card1.getSuit());
        Assertions.assertEquals(cardList.get(5).getRank(), card2.getRank());
    }




}
