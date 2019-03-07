package ua.com.agileboard.web.controller;

import ua.com.agileboard.model.User;

import static ua.com.agileboard.util.SecurityUtil.authUserId;

public class ProfileRestController extends AbstractUserController {

    public User get() {
        return super.get(authUserId());
    }

    public void delete() {
        super.delete(authUserId());
    }

    public void update(User user) {
        super.update(user, authUserId());
    }

}
