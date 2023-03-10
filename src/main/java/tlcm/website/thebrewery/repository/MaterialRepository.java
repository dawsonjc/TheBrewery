package tlcm.website.thebrewery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tlcm.website.thebrewery.entities.material.Material;

import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {

    @Query(value = "SELECT m FROM Material m WHERE m.alcoholId = :alcoholId")
    public List<Material> findAllByAlcoholId(@Param(value = "alcoholId") int alcoholId);
}
