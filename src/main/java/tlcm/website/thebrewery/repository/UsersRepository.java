package tlcm.website.thebrewery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tlcm.website.thebrewery.entities.users.Users;

import java.math.BigInteger;

@Repository
public interface UsersRepository extends JpaRepository<Users, BigInteger> {

    @Query(value = "SELECT user FROM Users user WHERE user.username = :username")
    public Users findUserByUsername(@Param(value = "username") String username);

    @Query(value = "SELECT user FROM Users user WHERE user.username = :username AND user.password = :password")
    public Users findUserByUsernameAndPassword(@Param(value = "username") String username,
                                               @Param(value = "password") String password);

}
