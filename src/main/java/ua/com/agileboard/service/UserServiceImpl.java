package ua.com.agileboard.service;

import ua.com.agileboard.model.User;
import ua.com.agileboard.repository.UserRepository;
import ua.com.agileboard.util.exception.NotFoundException;

import java.util.List;

import static ua.com.agileboard.util.ValidationUtil.checkNotFound;
import static ua.com.agileboard.util.ValidationUtil.checkNotFoundWithId;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(userRepository.delete(id), id);
    }

    @Override
    public User get(int id) throws NotFoundException {
        return checkNotFoundWithId(userRepository.get(id), id);
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        return checkNotFound(userRepository.getByEmail(email), "email=" + email);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public void update(User user) {
        checkNotFoundWithId(userRepository.save(user), user.getId());
    }

}
