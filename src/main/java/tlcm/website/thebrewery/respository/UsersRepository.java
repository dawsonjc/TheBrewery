package tlcm.website.thebrewery.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tlcm.website.thebrewery.entities.BackEndUser;

@Repository
public interface UsersRepository extends JpaRepository<BackEndUser, Long> {


    @Query(value = "SELECT user FROM BackEndUser user WHERE user.username = :username")
    public BackEndUser findBackEndUserByUsername(@Param(value="username") String username);

    @Query(value = "SELECT user FROM BackEndUser user WHERE user.username = :username AND user.password = :password")
    public BackEndUser findBackEndUserByUsernameAndPassword(@Param(value="username") String username,
                                                            @Param(value="password") String password);

    @Query(value = "SELECT count(*) FROM BackEndUser")
    public Long getAll();
}
