package tlcm.website.thebrewery.repository.alcohol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tlcm.website.thebrewery.entities.product.alcohol.Wine;

import java.math.BigInteger;

@Repository
public interface WineRepository extends JpaRepository<Wine, BigInteger> {
}
