package tlcm.website.thebrewery.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tlcm.website.thebrewery.entities.product.Beer;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Integer> {
    @Override
    public Page<Beer> findAll(Pageable pageable);
}
