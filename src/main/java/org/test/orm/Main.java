package org.test.orm;

import com.github.javafaker.Faker;
import org.test.orm.config.DatabaseConfiguration;
import org.test.orm.model.User;
import org.test.orm.repository.UserRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        createUser();
        printAllUser();
        deleteUser(1l);
        printAllUser();
        updateUser(2l);
        printAllUser();
        DatabaseConfiguration.shutdown();
    }

    public static void createUser() {
        Faker faker = new Faker();
        UserRepository userRepository = new UserRepository();

        User user = new User();
        user.setUsername(faker.name().username());
        user.setPassword(faker.name().title());
        user.setEmail(faker.name().firstName() + "@gmail.com");

        User user1 = new User();
        user1.setUsername(faker.name().username());
        user1.setPassword(faker.name().title());
        user1.setEmail(faker.name().firstName() + "@gmail.com");

        userRepository.create(user);
        userRepository.create(user1);

    }

    public static void printAllUser() {
        UserRepository userRepository = new UserRepository();
        List<User> list = userRepository.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }

    public static void deleteUser(Long id) {
        UserRepository userRepository = new UserRepository();
        userRepository.delete(id);
    }


    public static void updateUser(Long id) {
        UserRepository userRepository = new UserRepository();

        Faker faker = new Faker();
        User user = new User();
        user.setUsername(faker.name().username());
        user.setPassword(faker.name().title());
        user.setEmail(faker.name().firstName() + "@gmail.com");

        userRepository.update(user,2l);
    }
}
