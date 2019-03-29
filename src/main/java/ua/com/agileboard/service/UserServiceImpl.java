package ua.com.agileboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ua.com.agileboard.AuthorizedUser;
import ua.com.agileboard.model.User;
import ua.com.agileboard.repository.UserRepository;
import ua.com.agileboard.to.UserTo;
import ua.com.agileboard.util.UserUtil;
import ua.com.agileboard.util.exception.NotFoundException;

import java.util.List;

import static ua.com.agileboard.util.ValidationUtil.checkNotFound;
import static ua.com.agileboard.util.ValidationUtil.checkNotFoundWithId;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    private static final Sort SORT_NAME_EMAIL = new Sort(Sort.Direction.ASC, "name", "email");

    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return userRepository.save(user);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(userRepository.delete(id) != 0, id);
    }

    @Override
    public User get(int id) {
        return checkNotFoundWithId(userRepository.findById(id).orElse(null), id);
    }

    @Override
    public User getByEmail(String email) {
        Assert.notNull(email, "email must not be null");
        return checkNotFound(userRepository.getByEmail(email), "email=" + email);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll(SORT_NAME_EMAIL);
    }

    @Override
    public void update(User user) {
        Assert.notNull(user, "user must not be null");
        checkNotFoundWithId(userRepository.save(UserUtil.prepareToSave(user, passwordEncoder)), user.getId());
    }

    @Transactional
    @Override
    public void update(UserTo userTo) {
        User user = get(userTo.getId());
        userRepository.save(UserUtil.prepareToSave(user, passwordEncoder));
    }


    @Override
    @Transactional
    public void enable(int id, boolean enabled) {
        User user = get(id);
        user.setEnabled(enabled);
        userRepository.save(user);
    }

    @Override
    public AuthorizedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getByEmail(email.toLowerCase());
        if (user == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        return new AuthorizedUser(user);
    }
}
