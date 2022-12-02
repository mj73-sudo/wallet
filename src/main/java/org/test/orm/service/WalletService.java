package org.test.orm.service;

import org.test.orm.model.Wallet;
import org.test.orm.repository.WalletRepository;

public class WalletService {
    private final WalletRepository walletRepository = new WalletRepository();

    public boolean initWallet(Wallet wallet) {
        return walletRepository.create(wallet);
    }

    public Wallet findById(Long id){
        return walletRepository.findById(id);
    }
}
