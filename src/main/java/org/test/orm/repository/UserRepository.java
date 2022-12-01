package org.test.orm.repository;

import org.test.orm.model.User;

public class UserRepository extends BaseRepository<User>{
    public UserRepository() {
        super("User", User.class);
    }
}
