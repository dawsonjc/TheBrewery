package tlcm.website.thebrewery.services;

import org.springframework.stereotype.Service;
import tlcm.website.thebrewery.entities.users.UserType;
import tlcm.website.thebrewery.entities.users.Users;
import tlcm.website.thebrewery.repository.UsersRepository;

import java.time.LocalDateTime;
import java.util.UUID;

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
    public Users getUserById(UUID id) {
        return repo.getReferenceById(id);
    }

    public Users getUserbyUsername(String username) {
        return this.repo.findUserByUsername(username);
    }

    public Users updateUser(Users newUser) {
        Users existingUser = this.getUserById(newUser.getId());
        if(existingUser == null) {
            return null;
        }

        String currentPassword = existingUser.getPassword();
        String potentialPassword = Users.encryptPassword(newUser.getPassword(), existingUser.getPasswordSalt());

        // potential bug with null values [newUser has all fields are not null]
        Users updatedUser = existingUser.toBuilder()
                .withUpdateDate(LocalDateTime.now())
                .withFirstName(newUser.getFirstName())
                .withLastName(newUser.getLastName())
                .withEmail(newUser.getEmail())
                .withUsername(newUser.getUsername())
                .withPassword(
                        // does the current password equal the inputed password?
                        !currentPassword.equals(potentialPassword) ? potentialPassword : existingUser.getPassword()
                )
                .build();

        return this.repo.save(updatedUser);
    }

    public String getUsernameById(UUID id) {
        return this.getUserById(id).getUsername();
    }


    public boolean deleteUser(Users user) {
        return false;
    }
}
