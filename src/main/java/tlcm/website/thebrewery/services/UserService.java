package tlcm.website.thebrewery.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tlcm.website.thebrewery.entities.users.Users;
import tlcm.website.thebrewery.entities.users.FrontUser;
import tlcm.website.thebrewery.repository.UsersRepository;

@Service
public class UserService {

    @Autowired
    private UsersRepository repo;

    public Users createUser(Users user) {
        if(repo.findBackEndUserByUsername(user.getUsername()) == null) {
            return null;
        }
        return repo.save(user);
    }

    /**
     *
     * @param id the ID of the user
     * @return A user object of the id
     */
    public Users readUserById(int id) {
        return repo.getReferenceById((long) id);
    }

    public boolean userExists(FrontUser user) {
        Users user1 = this.getDBUserByFrontEndUser(user);

        return user1 != null;
    }

    public Users getDBUserByFrontEndUser(FrontUser user) {
        return this.repo.findBackEndUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    public Users updateUser(FrontUser newUser) {
        tlcm.website.thebrewery.converter.
                UserConverter converter = new tlcm.website.thebrewery.converter.UserConverter();
        return this.updateUser(converter.convertFrontUserToBackEndUser(newUser));
    }

    public Users updateUser(Users newUser) {
        Users existingUser = this.readUserById(newUser.getId());
        if(existingUser == null) {
            return null;
        }

        Users updatedUser = existingUser.toBuilder()
                .withFirstName(newUser.getFirstName())
                .withLastName(newUser.getLastName())
                .withUsername(newUser.getUsername())
                .withPassword(newUser.getPassword())
                .build();

        return this.repo.save(updatedUser);
    }

    public boolean deleteUser(FrontUser user) {
        return false;
    }

    public Page<Users> findAllUsers(Pageable pageable) {
        return this.repo.findAll(pageable);
    }

}
