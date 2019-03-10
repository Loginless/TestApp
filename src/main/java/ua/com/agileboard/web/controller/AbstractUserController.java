//package ua.com.agileboard.web.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import ua.com.agileboard.model.User;
//import ua.com.agileboard.service.UserService;
//
//import static ua.com.agileboard.util.ValidationUtil.*;
//
//import java.util.List;
//
//public class AbstractUserController {
//    protected final Logger log = LoggerFactory.getLogger(getClass());
//
//    @Autowired
//    private UserService userService;
//
//    public List<User> getAll() {
//        log.info("getAll");
//        return userService.findAll();
//    }
//
//    public User get(int id) {
//        log.info("get {}", id);
//        return userService.findById(id);
//    }
//
//    public User create(User user) {
//        log.info("create {}", user);
//        checkNew(user);
//        return userService.create(user);
//    }
//
//    public void delete(int id) {
//        log.info("delete {}", id);
//        userService.delete(id);
//    }
//
//    public void update(User user, int id) {
//        log.info("update {} with id={}", user, id);
//        assureIdConsistent(user, id);
//        userService.update(user);
//    }
//
//    public User getByMail(String email) {
//        log.info("getByEmail {}", email);
//        return userService.findByEmail(email);
//    }
//}
