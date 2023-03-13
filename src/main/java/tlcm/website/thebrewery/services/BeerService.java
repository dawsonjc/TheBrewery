package tlcm.website.thebrewery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tlcm.website.thebrewery.entities.material.Material;
import tlcm.website.thebrewery.entities.product.Beer;
import tlcm.website.thebrewery.repository.BeerRepository;
import tlcm.website.thebrewery.repository.MaterialRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BeerService {
    @Autowired
    private BeerRepository repo;

    @Autowired
    private MaterialRepository materialRepo;

    public Page<Beer> findAllBeer(Pageable pageable) {
        return this.repo.findAll(pageable);
    }

    public Beer getBeerById(int id) {
        return this.repo.getReferenceById(id);
    }

    public ArrayList<Material> getAllMaterials(int id) {
        return this.materialRepo.findAllByAlcoholId(id);
    }

    public ArrayList<String> getTableColumns() {
        return this.repo.getColumns();
    }
}
