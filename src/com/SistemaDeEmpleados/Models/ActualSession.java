package com.SistemaDeEmpleados.Models;

/**
 * Singleton class for app session
 * @author katto
 */
public class ActualSession {

    private static ActualSession instance;
    private User user;

    /**
     * @return the actual instance in app
     */
    public static ActualSession getInstance() {
        if (instance == null) {
            instance = new ActualSession();
        }
        return instance;
    }

    /**
     * Destroys the actual instance in app
     */
    public void destroyInstance(){
        instance = null;
    }

    /**
     * Sets the user in the session instance
     * @param user instance of {@link com.SistemaDeEmpleados.Models.User}
     */
    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
    
}
