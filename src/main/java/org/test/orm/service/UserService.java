package org.test.orm.service;

import org.test.orm.exceptions.InvalidUsernamePasswordException;
import org.test.orm.exceptions.UserNotFoundException;
import org.test.orm.model.User;
import org.test.orm.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository = new UserRepository();

    public void registerUser(User user) {
        userRepository.create(user);
    }

    public void loginUser(String username, String password) throws UserNotFoundException, InvalidUsernamePasswordException {
        User user = userRepository.getUserByUsername(username);
        if (user == null)
            throw new UserNotFoundException("user with given username :-- " + username + " -- not found.");

        if (user.getPassword().equals(password)) {
            //todo success login
            System.out.println("Login success");
        } else {
            throw new InvalidUsernamePasswordException("password is wrong.");
        }
    }

}
