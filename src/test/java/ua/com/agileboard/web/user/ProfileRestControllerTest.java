package ua.com.agileboard.web.user;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import ua.com.agileboard.TestUtil;
import ua.com.agileboard.model.Role;
import ua.com.agileboard.model.User;
import ua.com.agileboard.web.AbstractControllerTest;
import ua.com.agileboard.web.controller.AdminRestController;
import ua.com.agileboard.web.controller.ProfileRestController;
import ua.com.agileboard.web.json.JsonUtil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ua.com.agileboard.testdata.UserTestData.*;

class ProfileRestControllerTest extends AbstractControllerTest {

    @Test
    void testGet() throws Exception {
        TestUtil.print(
                mockMvc.perform(get(ProfileRestController.REST_URL))
                        .andExpect(status().isOk())
                        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                        .andExpect(getUserMatcher(ADMIN))
        );
    }

    @Test
    void testDelete() throws Exception {
        mockMvc.perform(delete(ProfileRestController.REST_URL))
                .andExpect(status().isNoContent());
        assertMatch(userService.getAll(), USER1, USER2);
    }

    @Test
    void testUpdate() throws Exception {
        User updated = new User(ADMIN_ID, "newName", "newemail@ya.ru", "newPassword", Role.ROLE_USER);
        mockMvc.perform(put(ProfileRestController.REST_URL).contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andDo(print())
                .andExpect(status().isNoContent());

        assertMatch(userService.getByEmail("newemail@ya.ru"), updated);
    }
}