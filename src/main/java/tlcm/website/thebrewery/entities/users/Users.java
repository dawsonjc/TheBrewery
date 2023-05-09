package tlcm.website.thebrewery.entities.users;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import javax.persistence.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@JsonDeserialize(builder = Users.Builder.class)
public class Users {
    @Id
    @GeneratedValue
    @Column(name="id")
    private UUID id;

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

    public UUID getId() {
        return id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public UserType getType() {
        return type;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // NEED TO UPDATE! UNSAFE AS FUCK!
    public static String encryptPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.update(password.getBytes());

            byte[] bytes = messageDigest.digest();

            StringBuilder sb = new StringBuilder();

            for(byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }

            return sb.toString();
        } catch(NoSuchAlgorithmException ignore) {}

        return null;
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

    @JsonPOJOBuilder
    public static class Builder {
        private UUID id;
        private LocalDateTime createDate;
        private LocalDateTime updateDate;
        private UserType userType;
        private String firstName;
        private String lastName;
        private String email;
        private String username;
        private String password;

        private Builder() {}

        public Builder withId(UUID id) {
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
