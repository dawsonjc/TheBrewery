package tlcm.website.thebrewery.services.alcohol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tlcm.website.thebrewery.entities.product.alcohol.Whiskey;
import tlcm.website.thebrewery.exceptions.AlcoholEntityNotFoundException;
import tlcm.website.thebrewery.repository.alcohol.WhiskeyRepository;

import java.math.BigInteger;

@Service
public class WhiskeyService {

    @Autowired
    private WhiskeyRepository repo;

    public Whiskey getWhiskeyById(BigInteger id) throws AlcoholEntityNotFoundException {
        return this.repo.findById(id)
                .orElseThrow(AlcoholEntityNotFoundException::new);
    }

}
