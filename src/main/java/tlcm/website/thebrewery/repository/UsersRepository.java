package tlcm.website.thebrewery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tlcm.website.thebrewery.entities.users.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    @Query(value = "SELECT user FROM Users user WHERE user.username = :username")
    public Users findBackEndUserByUsername(@Param(value="username") String username);

    @Query(value = "SELECT user FROM Users user WHERE user.username = :username AND user.password = :password")
    public Users findBackEndUserByUsernameAndPassword(@Param(value="username") String username,
                                                      @Param(value="password") String password);



}
