package tlcm.website.thebrewery.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tlcm.website.thebrewery.entities.material.Material;
import tlcm.website.thebrewery.entities.product.Beer;
import tlcm.website.thebrewery.repository.BeerRepository;
import tlcm.website.thebrewery.repository.MaterialRepository;

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
        return this.beerRepo.getReferenceById(id);
    }

    public List<Material> getAllMaterials(int id) {
        return this.materialRepo.findAllByAlcoholId(id);
    }

    public List<String> getTableColumns() {
        return this.beerRepo.getColumns();
    }
}
