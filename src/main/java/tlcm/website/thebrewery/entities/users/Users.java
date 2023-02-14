package tlcm.website.thebrewery.entities.users;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name="user_type")
    @Enumerated(EnumType.ORDINAL)
    private UserType type;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    public static Builder builder() {
        return new Builder();
    }

    public Builder toBuilder() {
        return new Builder()
                .withId(this.id)
                .withUserType(this.type)
                .withFirstName(this.firstName)
                .withLastName(this.lastName)
                .withUsername(this.username)
                .withPassword(this.password);
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
        this.password = password;
    }

    @Override
    public boolean equals(Object that) {
        if(this == that) {
            return true;
        }

        if(!(that instanceof Users)) {
            return false;
        }

        Users thatUser = (Users) that;

        if(!this.username.equals(thatUser.username) && !this.password.equals(thatUser.password)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return this.id;
    }

    public String toJavascriptObject() {
        return "{ " +
                "type:" + this.type +
                ", id:" + this.id +
                ", firstName: '" + this.firstName + '\'' +
                ", lastName: '" + this.lastName + '\'' +
                ", username: '" + this.username + '\'' +
                " }";
    }

    @Override
    public String toString() {
        return "BackEndUser{" +
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

        public Users build() {
            Users user = new Users();
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
