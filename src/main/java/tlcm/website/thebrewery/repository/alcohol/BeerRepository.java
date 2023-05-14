package tlcm.website.thebrewery.repository.alcohol;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tlcm.website.thebrewery.entities.product.alcohol.Beer;

import javax.persistence.TypedQuery;
import java.math.BigInteger;
import java.util.ArrayList;

@Repository
public interface BeerRepository extends JpaRepository<Beer, BigInteger> {


    @Query(value = "SELECT COLUMN_NAME FROM information_schema.COLUMNS WHERE TABLE_NAME = 'beer'", nativeQuery = true)
    public ArrayList<String> getColumns();
}
