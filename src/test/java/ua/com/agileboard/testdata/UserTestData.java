package ua.com.agileboard.testdata;

import org.springframework.test.web.servlet.ResultMatcher;
import ua.com.agileboard.model.AbstractBaseEntity;
import ua.com.agileboard.model.Role;
import ua.com.agileboard.model.User;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ua.com.agileboard.TestUtil.*;
public class UserTestData {
    public static final int ADMIN_ID = AbstractBaseEntity.START_SEQ;
    public static final int USER1_ID = AbstractBaseEntity.START_SEQ + 1;
    public static final int USER2_ID = AbstractBaseEntity.START_SEQ + 2;

    public static final String USER1_EMAIL = "user1@gmail.ru";
    public static final String USER1_FALSE_EMAIL = "dfdf@yandex.ru";

    public static final User ADMIN = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin", Role.ROLE_ADMIN, Role.ROLE_USER);
    public static final User USER1 = new User(USER1_ID, "User_1", "user1@gmail.ru", "password1", Role.ROLE_USER);
    public static final User USER2 = new User(USER2_ID, "User_2", "user2@gmail.ru", "password2", Role.ROLE_USER);

    public static final List<User> USERLIST = List.of(ADMIN, USER1, USER2);


    public static void assertMatch(User actual, User expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "registered", "password");
    }

    public static void assertMatch(Iterable<User> actual, User... expected) {
        assertMatch(actual, List.of(expected));
    }

    public static void assertMatch(Iterable<User> actual, Iterable<User> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("registered", "password").isEqualTo(expected);
    }

    public static ResultMatcher getUserMatcher(User expected) {
        return result -> assertMatch(readFromJsonMvcResult(result, User.class), expected);
    }

    public static ResultMatcher getUserMatcher(User... expected) {
        return result -> assertMatch(readListFromJsonMvcResult(result, User.class), List.of(expected));
    }

}
