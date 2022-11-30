package org.test.orm;

import com.github.javafaker.Faker;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.test.orm.config.DatabaseConfiguration;
import org.test.orm.model.Role;
import org.test.orm.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        createUser();
        printAllUser();
        deleteUser(1l);
        printAllUser();
        updateUser(2l);
        printAllUser();
        DatabaseConfiguration.shutdown();
    }

    public static void createUser() {
        Faker faker = new Faker();

        Session session = DatabaseConfiguration.getSessionFactory().openSession();
        session.beginTransaction();
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setUsername(faker.name().username());
            user.setPassword(faker.name().title());
            user.setEmail(faker.name().firstName() + "@gmail.com");

            Role role = new Role();
            role.setTitle(faker.name().title());

            user.setRole(role);
            session.save(user);
        }
        session.getTransaction().commit();
    }

    public static void printAllUser() {
        Session session = DatabaseConfiguration.getSessionFactory().openSession();
        Query query = session.createQuery("select u from User u inner join fetch u.role r " +
                "");
        List<User> list = query.list();
        for (User user : list) {
            System.out.println(user);
        }
    }

    public static void deleteUser(Long id) {
        Session session = DatabaseConfiguration.getSessionFactory().openSession();
        session.beginTransaction();
        User user = session.load(User.class, id);
        session.delete(user);
        session.getTransaction().commit();
    }


    public static void updateUser(Long id) {
        Session session = DatabaseConfiguration.getSessionFactory().openSession();
        Faker faker = new Faker();
        session.beginTransaction();
        User user = session.load(User.class, id);
        user.setUsername(faker.name().username());
        session.update(user);
        session.getTransaction().commit();
    }
}
