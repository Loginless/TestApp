package ua.com.agileboard.service;

import ua.com.agileboard.model.User;
import ua.com.agileboard.util.exception.NotFoundException;

import java.util.List;

public interface UserService {

    User create(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    List<User> getAll();

    User getByEmail(String email) throws NotFoundException;

    void update(User user);

    void enable(int id, boolean enable);

}

