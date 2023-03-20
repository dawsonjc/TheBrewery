package tlcm.website.thebrewery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tlcm.website.thebrewery.entities.material.Material;

import java.math.BigInteger;
import java.util.ArrayList;

@Repository
public interface MaterialRepository extends JpaRepository<Material, BigInteger> {

    @Query(value = "SELECT m FROM Material m WHERE m.alcoholId = :alcoholId")
    public ArrayList<Material> findAllByAlcoholId(@Param(value = "alcoholId") BigInteger alcoholId);
}
