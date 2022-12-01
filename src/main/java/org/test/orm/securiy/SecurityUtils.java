package org.test.orm.securiy;

import org.test.orm.model.User;

public class SecurityUtils {
    private static User user = null;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        SecurityUtils.user = user;
    }

    public static boolean isLogin() {
        return user != null;
    }
}
