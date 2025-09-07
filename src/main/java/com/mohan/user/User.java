package com.mohan.user;

import com.mohan.user.balance.UserExpenseBalanceSheet;

import java.util.Objects;

/**
 * Represents a user in the system.
 * <p>
 * Each user has a unique {@code userId}, a display {@code userName},
 * and an associated {@link UserExpenseBalanceSheet} that tracks
 * their balances with other users (amounts owed or to be received).
 * </p>
 *
 * <p>
 * This class is immutable in terms of identity (userId, userName cannot change),
 * but the {@link UserExpenseBalanceSheet} maintains a mutable state of the user's
 * financial interactions. This design ensures user identity consistency while
 * allowing dynamic updates of expense balances.
 * </p>
 *
 * Example usage:
 * <pre>
 *     User user = new User("u101", "Mohan");
 *     String id = user.getUserId(); // "u101"
 *     user.getUserExpenseBalanceSheet()
 * </pre>
 */
public class User{

    /** Unique identifier for every user */
    private final String userId;

    /** Display name of the user */
    private final String userName;

    /**
     * Balance sheet associated with every user
     * Tracks the net expenses with respect to other users
     */
    private final UserExpenseBalanceSheet userExpenseBalanceSheet;

    /**
     * Constructs a new user with the given identifier and name.
     * Initializes an empty {@link UserExpenseBalanceSheet}.
     *
     * @param userId   unique identifier of the user
     * @param userName display name of the user
     */

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.userExpenseBalanceSheet = new UserExpenseBalanceSheet();
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public UserExpenseBalanceSheet getUserExpenseBalanceSheet() {
        return userExpenseBalanceSheet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName);
    }
}
