package edu.objects;

public class Admin {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    /**
     * 
     * @param firstName
     *            First name of the admin
     * @param lastName
     *            Last name of the admin
     * @param userName
     *            User name of the admin
     * @param password
     *            Password for the account of this admin
     */
    public Admin(String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    /**
     * 
     * @return The first name of the admin
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @return the last name of the admin
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @return the user name of the admin
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 
     * @return the password of the admin
     */
    public String getPassword() {
        return password;
    }
}
