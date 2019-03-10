package ua.com.agileboard.testdata;

import ua.com.agileboard.model.AbstractBaseEntity;
import ua.com.agileboard.model.BoardColumn;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardColumnTestData {

    public static final int COLUMN1_ID = AbstractBaseEntity.START_SEQ + 3;
    public static final int COLUMN2_ID = AbstractBaseEntity.START_SEQ + 4;
    public static final int COLUMN3_ID = AbstractBaseEntity.START_SEQ + 5;

    public static final BoardColumn COLUMN1 = new BoardColumn(COLUMN1_ID, "To Do", "New tasks");
    public static final BoardColumn COLUMN2 = new BoardColumn(COLUMN2_ID, "In Progress", "Ongoing tasks");
    public static final BoardColumn COLUMN3 = new BoardColumn(COLUMN3_ID, "Done", "Completed tasks");


    public static void assertMatch(BoardColumn actual, BoardColumn expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<BoardColumn> actual, BoardColumn... expected) {
        assertMatch(actual, List.of(expected));
    }

    public static void assertMatch(Iterable<BoardColumn> actual, Iterable<BoardColumn> expected) {
        assertThat(actual).isEqualTo(expected);
    }

}
