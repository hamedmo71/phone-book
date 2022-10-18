package ir.maktab74.phonebook.util;


import ir.maktab74.phonebook.entity.User;
import org.springframework.stereotype.Component;

public class SecurityContext {

    private final static ThreadLocal<User> currentUserThread = new ThreadLocal<>();

    public static User getCurrentUser() {
        return currentUserThread.get();
    }

    public static void setCurrentUser(User user) {
        currentUserThread.set(user);
    }

    public static void clear() {
        currentUserThread.remove();
    }
}
