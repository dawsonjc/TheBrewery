package tlcm.website.thebrewery.entities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    private UserType type;
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public static Builder builder() {
        return new Builder();
    }

    public UserType getType() {
        return this.type;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.update(password.getBytes());

            byte[] bytes = messageDigest.digest();

            StringBuilder sb = new StringBuilder();

            for(byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }

            this.password = sb.toString();
        } catch(NoSuchAlgorithmException ignore) {}
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

        if(!this.username.equals(thatUser.username) && !this.password.equals(thatUser.password)) {
            return false;
        }

        return true;
    }

    public String toJavascriptObject() {
        return "User { " +
                "type:" + this.type +
                ", id:" + this.id +
                ", firstName: '" + this.firstName + '\'' +
                ", lastName: '" + this.lastName + '\'' +
                ", username: '" + this.username + '\'' +
                " }";
    }

    public static class Builder {
        private UserType userType;
        private int id;
        private String firstName;
        private String lastName;
        private String username;
        private String password;

        public Builder withUserType(UserType userType) {
            this.userType = userType;
            return this;
        }

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            User user = new User();
            user.type = this.userType;
            user.id = this.id;
            user.firstName = this.firstName;
            user.lastName = this.lastName;
            user.username = this.username;
            user.password = this.password;

            return user;
        }
    }
}
