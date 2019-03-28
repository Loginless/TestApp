package ua.com.agileboard.web.user;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import ua.com.agileboard.TestUtil;
import ua.com.agileboard.model.User;
import ua.com.agileboard.to.UserTo;
import ua.com.agileboard.util.UserUtil;
import ua.com.agileboard.web.AbstractControllerTest;
import ua.com.agileboard.web.controller.ProfileRestController;
import ua.com.agileboard.web.json.JsonUtil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ua.com.agileboard.TestUtil.userHttpBasic;
import static ua.com.agileboard.testdata.UserTestData.*;

class ProfileRestControllerTest extends AbstractControllerTest {

    @Test
    void testGet() throws Exception {
        TestUtil.print(
                mockMvc.perform(get(ProfileRestController.REST_URL)
                        .with(userHttpBasic(USER1)))
                        .andExpect(status().isOk())
                        .andDo(print())
                        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                        .andExpect(getUserMatcher(USER1))
        );
    }

    @Test
    void testGetUnAuth() throws Exception {
        mockMvc.perform(get(ProfileRestController.REST_URL))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void testDelete() throws Exception {
        mockMvc.perform(delete(ProfileRestController.REST_URL)
                .with(userHttpBasic(USER1)))
                .andExpect(status().isNoContent());
        assertMatch(userService.getAll(), ADMIN, USER2);
    }

    @Test
    void testUpdate() throws Exception {
        UserTo updatedTo = new UserTo(null, "newName", "newemail@ya.ru", "newPassword");

        mockMvc.perform(put(ProfileRestController.REST_URL).contentType(MediaType.APPLICATION_JSON)
                .with(userHttpBasic(USER1))
                .content(JsonUtil.writeValue(updatedTo)))
                .andDo(print())
                .andExpect(status().isNoContent());

        assertMatch(userService.getByEmail("newemail@ya.ru"), UserUtil.updateFromTo(new User(USER1), updatedTo));
    }


}