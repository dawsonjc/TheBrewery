package tlcm.website.thebrewery.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tlcm.website.thebrewery.entities.product.Beer;

import java.util.ArrayList;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Integer> {
    @Override
    public Page<Beer> findAll(Pageable pageable);

    @Query(value = "SELECT COLUMN_NAME FROM information_schema.COLUMNS WHERE TABLE_NAME = 'beer'", nativeQuery = true)
    public ArrayList<String> getColumns();
}
