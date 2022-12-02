package org.test.orm.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.test.orm.model.User;

import java.util.List;

public class UserRepository extends BaseRepository<User> {
    public UserRepository() {
        super("User", User.class);
    }

    public User getUserByUsername(String username) {
        Session session = sessionFactory.openSession();
        Query<User> query =
                session.createQuery("select u from User u where u.username=:username", User.class)
                        .setParameter("username", username);
        List<User> list = query.list();
        session.close();
        if (list.isEmpty())
            return null;

        return list.get(0);
    }

    public User getUserByWalletId(Long walletId) {
//        String sqlQuery = "select u.* from wallets w inner join users u on w.user_id = u.id where w.id=:walletId";
//        String hqlQuery = "select u from Wallet w join w.user u where w.id=:walletId";
        Session session = sessionFactory.openSession();
        Query<User> query =
                session.createQuery("select u from Wallet w join w.user u where w.id=:walletId", User.class)
                        .setParameter("walletId", walletId);

        List<User> list = query.list();
        session.close();
        if (list.isEmpty())
            return null;

        return list.get(0);
    }
}