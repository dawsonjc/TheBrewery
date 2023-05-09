package tlcm.website.thebrewery.controllers.alcohol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tlcm.website.thebrewery.entities.product.alcohol.Beer;
import tlcm.website.thebrewery.services.BeerService;
import tlcm.website.thebrewery.services.UserService;

import java.math.BigInteger;

@Controller
@RequestMapping(value = "alcohol/beer")
public class BeerController {

    @Autowired
    private BeerService beerService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public String getBeerById(@RequestParam(value = "id") BigInteger id,
                              Model model
    ) {
        Beer beer = this.beerService.getBeerById(id);
        model.addAttribute("created-by", userService.getUsernameById(beer.getUserId()));
        model.addAttribute("alcohol_entity", beer);

        return "beer";
    }

}
