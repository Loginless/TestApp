package ua.com.agileboard.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import ua.com.agileboard.model.Role;
import ua.com.agileboard.model.User;
import ua.com.agileboard.util.exception.NotFoundException;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static ua.com.agileboard.testdata.UserTestData.*;


class UserServiceTest extends AbstractServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void create() throws Exception {
        User newUser = new User(null, "New", "new@gmail.com", "newPass", false, new Date(), Collections.singleton(Role.ROLE_USER));
        User created = userService.create(new User(newUser));
        newUser.setId(created.getId());
        assertMatch(userService.getAll(), ADMIN, newUser, USER1, USER2);
    }

    @Test
    void duplicateMailCreate() throws Exception {
        assertThrows(DataAccessException.class, () ->
                userService.create(new User(null, "Duplicate", "user1@gmail.ru", "newPass", Role.ROLE_USER)));
    }

    @Test
    void update() {
        User updated = new User(USER1);
        updated.setName("UpdatedName");
        updated.setEmail("test@gmail.com");
        userService.update(new User(updated));
        assertMatch(userService.get(USER1_ID), updated);
    }

    @Test
    void delete() {
        userService.delete(USER1_ID);
        userService.delete(USER2_ID);
        assertMatch(userService.getAll(), ADMIN);
    }

    @Test
    void deletedNotFound() throws Exception {
        assertThrows(NotFoundException.class, () ->
                userService.delete(144));
    }

    @Test
    void findById() {
        User user = userService.get(USER1_ID);
        assertMatch(user, USER1);
    }

    @Test
    void findByIdNotFound() throws Exception {
        assertThrows(NotFoundException.class, () ->
                userService.get(1));
    }

    @Test
    void getAll() throws Exception {
        List<User> all = userService.getAll();
        System.out.println(ADMIN);
        assertMatch(all, ADMIN, USER1, USER2);
    }

    @Test
    void findByEmail() {
        User user = userService.getByEmail(USER1_EMAIL);
        assertMatch(user, USER1);
    }

    @Test
    void findByEmailNotFound() throws Exception {
        assertThrows(NotFoundException.class, () ->
                userService.getByEmail(USER1_FALSE_EMAIL));
    }


}