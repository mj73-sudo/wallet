package org.test.orm.repository;

import org.test.orm.model.Wallet;

public class WalletRepository extends BaseRepository<Wallet> {
    public WalletRepository() {
        super("Wallet", Wallet.class);
    }
}
