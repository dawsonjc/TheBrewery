package tlcm.website.thebrewery.services;

import org.springframework.stereotype.Service;
import tlcm.website.thebrewery.entities.material.Material;
import tlcm.website.thebrewery.repository.MaterialRepository;

import java.math.BigInteger;
import java.util.List;

@Service
public class MaterialService {

    private final MaterialRepository repo;

    public MaterialService(MaterialRepository repo) {
        this.repo = repo;
    }

    public List<Material> findAllByAlcoholId(BigInteger id) {
        return this.repo.findAllByAlcoholId(id);
    }
}
