package org.test.orm.service;

import org.junit.jupiter.api.*;
import org.test.orm.model.Transaction;
import org.test.orm.model.User;
import org.test.orm.model.Wallet;

import java.time.ZonedDateTime;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TransactionServiceTest {
    private final WalletService walletService = new WalletService();
    private final UserService userService = new UserService();

    private final TransactionService transactionService = new TransactionService();

    @Test
    @Order(1)
    void doTransaction() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");
        user.setEmail("admin@gmail.com");
        userService.registerUser(user);

        Wallet wallet = new Wallet();
        wallet.setActive(true);
        wallet.setBalance(0d);
        wallet.setUser(user);

        walletService.initWallet(wallet);

        Transaction transaction = new Transaction();
        transaction.setAmount(100d);
        transaction.setCreatedDate(ZonedDateTime.now().toEpochSecond());
        transaction.setType(4);
        transaction.setWallet(wallet);

        boolean result = transactionService.doTransaction(transaction);

        Assertions.assertTrue(result);

    }

    @Test
    @Order(2)
    public void checkBalance() {
        Wallet wallet = walletService.findById(1L);
        Assertions.assertEquals(100d, wallet.getBalance());
    }


}