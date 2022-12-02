package org.test.orm.service;

import org.test.orm.model.User;
import org.test.orm.model.Wallet;
import org.test.orm.repository.WalletRepository;

public class WalletService {
    private final WalletRepository walletRepository = new WalletRepository();

    public boolean initWallet(Wallet wallet) {
        return walletRepository.create(wallet);
    }
}
