package org.test.orm.service;

import org.junit.jupiter.api.*;
import org.test.orm.model.User;
import org.test.orm.model.Wallet;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WalletServiceTest {
    private final WalletService walletService = new WalletService();
    private final UserService userService = new UserService();

    @Test
    @Order(1)
    void initWallet() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");
        user.setEmail("admin@gmail.com");
        userService.registerUser(user);

        Wallet wallet = new Wallet();
        wallet.setActive(true);
        wallet.setBalance(0d);
        wallet.setUser(user);

        boolean result = walletService.initWallet(wallet);

        Assertions.assertTrue(result);

    }

    @Test
    @Order(2)
    void getUserByWalletId(){
        User user = userService.getUserByWalletId(1L);

        Assertions.assertEquals(1L,user.getId());
    }
}