package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserRepository;
import web.model.User;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void delete(long id) {
        Optional<User> user=userRepository.findById(id);
        user.ifPresent(value -> userRepository.delete(value));

    }


    @Transactional(readOnly = true)
    @Override
    public User findUserbyId(Long id) {
        return userRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    @Override
    public User findByEmail(String s) {
        return userRepository.findByEmail(s);
    }
}
