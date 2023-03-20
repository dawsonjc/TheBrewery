package tlcm.website.thebrewery.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tlcm.website.thebrewery.entities.material.Material;
import tlcm.website.thebrewery.entities.product.Beer;
import tlcm.website.thebrewery.repository.BeerRepository;
import tlcm.website.thebrewery.repository.MaterialRepository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BeerService {
    private final BeerRepository beerRepo;

    private final MaterialRepository materialRepo;

    public BeerService(BeerRepository beerRepo, MaterialRepository materialRepo) {
        this.beerRepo = beerRepo;
        this.materialRepo = materialRepo;
    }

    public Page<Beer> findAllBeer(Pageable pageable) {
        return this.beerRepo.findAll(pageable);
    }

    public Beer getBeerById(int id) {
        return this.beerRepo.getReferenceById((long) id);
    }

    public List<Material> getAllMaterials(BigInteger id) {
        return this.materialRepo.findAllByAlcoholId(id);
    }

    public List<String> getTableColumns() {
        return this.beerRepo.getColumns();
    }

    /**
     * Gets values from specific columns.<br>
     * Example: <br> <code>this.service.getSpecifiedColumns("id, create_date", 0)</code>
     * @param columns No need for parentheses, values are comma separated
     * @param id The alcohol Id
     * @return Returned record from the database
     */
    public ArrayList<String> getSpecificColumns(String columns, Integer id) {
        return this.beerRepo.getSpecificColumns(columns, id);
    }
}
