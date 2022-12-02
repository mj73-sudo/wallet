package org.test.orm.repository;

import org.test.orm.model.Transaction;

public class TransactionRepository extends BaseRepository<Transaction> {
    public TransactionRepository() {
        super("Transaction", Transaction.class);
    }
}
