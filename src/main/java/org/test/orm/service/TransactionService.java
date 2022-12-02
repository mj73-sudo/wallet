package org.test.orm.service;

import org.test.orm.exceptions.BalanceNotEnoughException;
import org.test.orm.model.Transaction;
import org.test.orm.model.Wallet;
import org.test.orm.repository.TransactionRepository;
import org.test.orm.repository.WalletRepository;

public class TransactionService {
    private final TransactionRepository transactionRepository = new TransactionRepository();
    private final WalletRepository walletRepository = new WalletRepository();

    public boolean doTransaction(Transaction transaction) {
        Wallet wallet = walletRepository.findById(transaction.getWallet().getId());

        double newBalance = 0d;

        newBalance = wallet.getBalance() + transaction.getAmount();
        if (newBalance < 0) {
            throw new BalanceNotEnoughException("your credit not enough.");
        }

        wallet.setBalance(newBalance);
        walletRepository.update(wallet, wallet.getId());

        Wallet updatedWallet = walletRepository.findById(transaction.getWallet().getId());
        transaction.setWallet(updatedWallet);

        return transactionRepository.create(transaction);
    }
}
