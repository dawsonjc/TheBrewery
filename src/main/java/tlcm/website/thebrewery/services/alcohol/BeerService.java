package tlcm.website.thebrewery.services.alcohol;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tlcm.website.thebrewery.entities.material.Material;
import tlcm.website.thebrewery.entities.product.alcohol.Beer;
import tlcm.website.thebrewery.exceptions.AlcoholEntityNotFoundException;
import tlcm.website.thebrewery.repository.BeerRepository;
import tlcm.website.thebrewery.repository.MaterialRepository;
import tlcm.website.thebrewery.services.MaterialService;

import java.math.BigInteger;
import java.util.List;

@Service
public class BeerService {
    private final BeerRepository beerRepo;

    private final MaterialService materialService;

    public BeerService(BeerRepository beerRepo, MaterialService materialService) {
        this.beerRepo = beerRepo;
        this.materialService = materialService;
    }

    public Page<Beer> findAllBeer(Pageable pageable) {
        return this.beerRepo.findAll(pageable);
    }

    public Beer getBeerById(BigInteger id) throws AlcoholEntityNotFoundException {
        return this.beerRepo.findById(id).orElseThrow(AlcoholEntityNotFoundException::new);
    }

    public Beer createBeer(Beer beer) {
        return this.beerRepo.save(beer);
    }

    public List<Material> getAllMaterialsById(BigInteger id) {
        return this.materialService.findAllByAlcoholId(id);
    }

    public List<String> getTableColumns() {
        return this.beerRepo.getColumns();
    }
}
