package tlcm.website.thebrewery.entities.users;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FrontUser {
    private int id;
    private UserType type;
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public static Builder builder() {
        return new Builder();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
    public String toString() {
        return "FrontUser{" +
                "id=" + id +
                ", type=" + type +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder {
        private UserType userType;
        private int id;
        private String firstName;
        private String lastName;
        private String username;
        private String password;

        public FrontUser.Builder withUserType(UserType userType) {
            this.userType = userType;
            return this;
        }

        public FrontUser.Builder withId(int id) {
            this.id = id;
            return this;
        }

        public FrontUser.Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public FrontUser.Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public FrontUser.Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public FrontUser.Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public FrontUser build() {
            FrontUser user = new FrontUser();
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


