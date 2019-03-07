package ua.com.agileboard.web.controller;

import org.springframework.stereotype.Controller;
import ua.com.agileboard.model.User;

import static ua.com.agileboard.util.SecurityUtil.authUserId;

@Controller
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
