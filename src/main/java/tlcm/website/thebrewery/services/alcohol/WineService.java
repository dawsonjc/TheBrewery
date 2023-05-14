package tlcm.website.thebrewery.services.alcohol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tlcm.website.thebrewery.entities.product.alcohol.Wine;
import tlcm.website.thebrewery.repository.alcohol.WhiskeyRepository;

import java.math.BigInteger;

@Service
public class WineService {

    @Autowired
    private WhiskeyRepository repo;

    public Wine getWineById(BigInteger id) {
        return null;
    }
}
