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
}