package tlcm.website.thebrewery.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tlcm.website.thebrewery.entities.users.UserType;
import tlcm.website.thebrewery.entities.users.Users;
import tlcm.website.thebrewery.repository.UsersRepository;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

@Service
public class UserService {

    private final UsersRepository repo;

    public UserService(UsersRepository repo) {
        this.repo = repo;
    }

    public Users createUser(Users user) {
        if(repo.findUserByUsername(user.getUsername()) != null) {
            return null;
        }

        LocalDateTime d = LocalDateTime.now();
        user = user.toBuilder()
                .withCreateDate(d)
                .withUpdateDate(d)
                .withUserType(UserType.USER)
                .withPassword(user.getPassword())
                .build();

        return repo.save(user);
    }

    /**
     *
     * @param id the ID of the user
     * @return A user object of the id
     */
    public Users readUserById(BigInteger id) {
        return repo.getReferenceById(id);
    }

    public boolean userExists(Users user) {
        Users user1 = this.getUserByUserNameAndPassword(user);

        return user1 != null;
    }

    public Users getUserByUserNameAndPassword(Users user) {
        return this.repo.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    public Users updateUser(Users newUser) {
        Users existingUser = this.readUserById(newUser.getId());
        if(existingUser == null) {
            return null;
        }

        // potential bug with null values [newUser has all fields are not null]
        Users updatedUser = existingUser.toBuilder()
                .withUpdateDate(java.time.LocalDateTime.now())
                .withFirstName(newUser.getFirstName())
                .withLastName(newUser.getLastName())
                .withEmail(newUser.getEmail())
                .withUsername(newUser.getUsername())
                .withPassword(newUser.getPassword())
                .build();

        return this.repo.save(updatedUser);
    }

    public boolean deleteUser(Users user) {
        return false;
    }

    public Page<Users> findAllUsers(Pageable pageable) {
        return this.repo.findAll(pageable);
    }

}
