package tlcm.website.thebrewery.object;

public class User {
    private UserType type;
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public UserType getType() {
        return this.type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object that) {
        if(this == that) {
            return true;
        }

        if(!(that instanceof User)) {
            return false;
        }

        User thatUser = (User) that;

        if(this.id != thatUser.id) {
            return false;
        }
        if(!this.username.equals(thatUser.username) && !this.password.equals(thatUser.password)) {
            return false;
        }

        return true;
    }

}
