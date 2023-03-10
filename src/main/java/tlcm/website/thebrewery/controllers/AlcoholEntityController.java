package tlcm.website.thebrewery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tlcm.website.thebrewery.services.BeerService;

@Controller
@RequestMapping(value = "alcohol")
public class AlcoholEntityController {

    @Autowired
    private BeerService service;

    /*
    TODO: Add other services
     */

    @RequestMapping(value = "beer/{id}")
    public String renderBeer(
            @PathVariable(value = "id") int id,
            Model model
    ) {
        model.addAttribute("alcohol_entity", this.service.getBeerById(id));
        return "alcohol/beer";
    }



}
