package org.test.orm.service;


import org.junit.jupiter.api.*;
import org.test.orm.config.DatabaseConfiguration;
import org.test.orm.exceptions.InvalidUsernamePasswordException;
import org.test.orm.exceptions.UserNotFoundException;
import org.test.orm.model.User;
import org.test.orm.securiy.SecurityUtils;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceTest {
    private static UserService userService =null;

    @BeforeAll
    static void setUp() {
        userService = new UserService();
    }

    @Test
    @Order(1)
    void registerUser() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");
        user.setEmail("admin@gmail.com");
        boolean isRegister = userService.registerUser(user);
        Assertions.assertTrue(isRegister);
    }

    @Test
    @Order(2)
    void loginUser() {
        userService.loginUser("admin","123456");
        Assertions.assertTrue(SecurityUtils.isLogin());

        Assertions.
                assertThrows(UserNotFoundException.class,()-> userService.loginUser("admin1","123456"));

        Assertions.assertThrows(InvalidUsernamePasswordException.class,()->userService.loginUser("admin","1234"));
    }

    @Test
    @Order(3)
    void logout(){
        userService.logout();
        Assertions.assertFalse(SecurityUtils.isLogin());
    }

    @Test
    @Order(4)
    void findById(){
        User user = userService.findById(1l);
        Assertions.assertEquals(1l,user.getId());
    }

    @Test
    @Order(5)
    void findAll(){
        List<User> users = userService.findAll();
        Assertions.assertFalse(users.isEmpty());
    }

    @Test
    @Order(6)
    void count(){
        int count = userService.count();
        Assertions.assertEquals(1,count);
    }

    @Test
    @Order(7)
    void delete(){
        userService.delete(1l);
        User user = userService.findById(1l);
        Assertions.assertNull(user);
    }
}