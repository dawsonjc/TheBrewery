package tlcm.website.thebrewery.controllers.alcohol;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tlcm.website.thebrewery.entities.product.alcohol.Beer;
import tlcm.website.thebrewery.services.BeerService;

import java.math.BigInteger;

@Controller
@RequestMapping(value = "alcohol/beer")
public class BeerController {

    @Autowired
    private BeerService service;

    @GetMapping(value = "")
    public ResponseEntity<Beer> getBeerById(@RequestParam(value = "id") BigInteger id) {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
