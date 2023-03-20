package tlcm.website.thebrewery.entities.users;

import javax.persistence.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue
    @Column(name="id")
    private BigInteger id;

    @Column(name="create_date")
    private LocalDateTime createDate;

    @Column(name="update_date")
    private LocalDateTime updateDate;

    @Column(name="user_type")
    @Enumerated(EnumType.ORDINAL)
    private UserType type;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

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
                .withCreateDate(this.createDate)
                .withUpdateDate(this.updateDate)
                .withUserType(this.type)
                .withFirstName(this.firstName)
                .withLastName(this.lastName)
                .withEmail(this.email)
                .withUsername(this.username)
                .withPassword(this.password);
    }

    public UserType getType() {
        return this.type;
    }

    public BigInteger getId() {
        return this.id;
    }

    @Deprecated
    public void setId(BigInteger id) {
        if(this.id != null) {
            return;
        }
        this.id = id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * Note: can only be used once
     * @param type User Type (admin, user)
     */
    public void setType(UserType type) {
        if(this.type != null) {
            return;
        }
        this.type = type;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        if(this.firstName != null) {
            return;
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        if(this.lastName != null) {
            return;
        }
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        if(this.username != null) {
            return;
        }
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    // NEED TO UPDATE! UNSAFE AS FUCK!
    public void setPassword(String password) {
        if(this.password != null) {
            return;
        }

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

        if(!(that instanceof Users)) {
            return false;
        }

        Users thatUser = (Users) that;

        if(!this.username.equals(thatUser.username) && !this.password.equals(thatUser.password)) {
            return false;
        }

        return true;
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
        return "Users{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", type=" + type +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder {
        private BigInteger id;
        private LocalDateTime createDate;
        private LocalDateTime updateDate;
        private UserType userType;
        private String firstName;
        private String lastName;
        private String email;
        private String username;
        private String password;

        private Builder() {}

        public Builder withId(BigInteger id) {
            this.id = id;
            return this;
        }

        public Builder withCreateDate(LocalDateTime createDate) {
            this.createDate = createDate;
            return this;
        }

        public Builder withUpdateDate(LocalDateTime updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public Builder withUserType(UserType userType) {
            this.userType = userType;
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

        public Builder withEmail(String email) {
            this.email = email;
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
            user.id = this.id;
            user.createDate = this.createDate;
            user.updateDate = this.updateDate;
            user.type = this.userType;
            user.firstName = this.firstName;
            user.lastName = this.lastName;
            user.email = this.email;
            user.username = this.username;
            user.password = this.password;

            return user;
        }
    }
}
