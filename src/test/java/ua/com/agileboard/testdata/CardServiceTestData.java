package ua.com.agileboard.testdata;

import ua.com.agileboard.model.AbstractBaseEntity;
import ua.com.agileboard.model.Card;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ua.com.agileboard.testdata.BoardColumnTestData.*;

public class CardServiceTestData {

    public static final int CARD1_ID = AbstractBaseEntity.START_SEQ + 6;
    public static final int CARD2_ID = AbstractBaseEntity.START_SEQ + 7;
    public static final int CARD3_ID = AbstractBaseEntity.START_SEQ + 8;
    public static final int CARD4_ID = AbstractBaseEntity.START_SEQ + 9;

    public static final Card CARD1 = new Card(CARD1_ID, "Review technical task", "Analyze technical task", COLUMN3);
    public static final Card CARD2 = new Card(CARD2_ID, "Work on the architecture", null, COLUMN2);
    public static final Card CARD3 = new Card(CARD3_ID, "Write code", null, COLUMN1);
    public static final Card CARD4 = new Card(CARD4_ID, "WTest the app", null, COLUMN1);

    public static void assertMatch(Card actual, Card expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Card> actual, Card... expected) {
        assertMatch(actual, List.of(expected));
    }

    public static void assertMatch(Iterable<Card> actual, Iterable<Card> expected) {
        assertThat(actual).isEqualTo(expected);
    }
}
