package tlcm.website.thebrewery.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tlcm.website.thebrewery.entities.users.BackEndUser;
import tlcm.website.thebrewery.entities.users.FrontUser;
import tlcm.website.thebrewery.repository.UsersRepository;

@Service
public class UserService {

    @Autowired
    private UsersRepository repo;

    public BackEndUser createUser(BackEndUser user) {
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
    public BackEndUser readUserById(int id) {
        return repo.getReferenceById((long) id);
    }

    public boolean userExists(FrontUser user) {
        BackEndUser user1 = this.getDBUserByFrontEndUser(user);

        return user1 != null;
    }

    public BackEndUser getDBUserByFrontEndUser(FrontUser user) {
        return this.repo.findBackEndUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    public BackEndUser updateUser(FrontUser newUser) {
        tlcm.website.thebrewery.converter.
                UserConverter converter = new tlcm.website.thebrewery.converter.UserConverter();
        return this.updateUser(converter.convertFrontUserToBackEndUser(newUser));
    }

    public BackEndUser updateUser(BackEndUser newUser) {
        BackEndUser existingUser = this.readUserById(newUser.getId());
        if(existingUser == null) {
            return null;
        }

        BackEndUser updatedUser = existingUser.toBuilder()
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

    public Page<BackEndUser> findAllUsers(Pageable pageable) {
        return this.repo.findAll(pageable);
    }

}
