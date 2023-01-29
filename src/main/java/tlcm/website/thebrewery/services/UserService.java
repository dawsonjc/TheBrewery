package tlcm.website.thebrewery.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tlcm.website.thebrewery.entities.BackEndUser;
import tlcm.website.thebrewery.entities.FrontUser;
import tlcm.website.thebrewery.respository.UsersRepository;

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

    public boolean userExists(BackEndUser user) {
        BackEndUser user1 = this.repo.findBackEndUserByUsernameAndPassword(user.getUsername(), user.getPassword());

        return user1 != null;
    }


    public BackEndUser updateUser(FrontUser newUser) {
        BackEndUser existingUser = this.readUserById(newUser.getId());
        if(existingUser == null) {
            return null;
        }



        return null;
    }

    public BackEndUser updateUser(BackEndUser newUser) {
        return null;
    }

    public boolean deleteUser(FrontUser user) {
        return false;
    }


}
