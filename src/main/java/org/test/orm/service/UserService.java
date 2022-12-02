package org.test.orm.service;

import org.test.orm.exceptions.InvalidUsernamePasswordException;
import org.test.orm.exceptions.UserNotFoundException;
import org.test.orm.model.User;
import org.test.orm.repository.UserRepository;
import org.test.orm.securiy.SecurityUtils;

import java.util.List;

public class UserService {

    private final UserRepository userRepository = new UserRepository();

    public boolean registerUser(User user) {
        return userRepository.create(user);
    }

    public void loginUser(String username, String password) throws UserNotFoundException, InvalidUsernamePasswordException {
        User user = userRepository.getUserByUsername(username);
        if (user == null)
            throw new UserNotFoundException("user with given username :-- " + username + " -- not found.");

        if (user.getPassword().equals(password)) {
            SecurityUtils.setUser(user);
        } else {
            throw new InvalidUsernamePasswordException("password is wrong.");
        }
    }

    public void logout() {
        SecurityUtils.setUser(null);
    }

    public User findById(Long id){
        return userRepository.findById(id);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public int count(){
        return userRepository.findAll().size();
    }

    public void delete(Long id){
        userRepository.delete(id);
    }

    public User getUserByWalletId(Long id){
        return userRepository.getUserByWalletId(id);
    }
}
