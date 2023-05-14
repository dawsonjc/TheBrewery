package tlcm.website.thebrewery.controllers.alcohol;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tlcm.website.thebrewery.entities.product.alcohol.Beer;
import tlcm.website.thebrewery.exceptions.AlcoholEntityNotFoundException;
import tlcm.website.thebrewery.services.alcohol.BeerService;
import tlcm.website.thebrewery.services.UserService;

import java.math.BigInteger;

@Controller
@RequestMapping(value = { "alcohol/beer" })
public class BeerController {

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private BeerService beerService;
    @Autowired
    private UserService userService;

    // load
    @GetMapping(value = { "" })
    public String getBeerByIdPage(
                            @RequestParam(value = "id") BigInteger id,
                            Model model
    ) {
        Beer beer = this.beerService.getBeerById(id);
        model.addAttribute("created-by", userService.getUsernameById(beer.getUserId()));
        model.addAttribute("alcohol-entity", beer);

        return "beer";
    }

    @ResponseBody
    @GetMapping(value = { "{id}"} )
    public ResponseEntity<ObjectNode> getBeerJsonById(@PathVariable(value = "id") BigInteger id) {
        Beer beer;
        try {
            beer = this.beerService.getBeerById(id);
        } catch(AlcoholEntityNotFoundException e) {
            ObjectNode response = this.mapper.createObjectNode();

            response.put("message", e.getMessage());
            response.put("id", e.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        return ResponseEntity.ok(this.mapper.convertValue(beer, ObjectNode.class));
    }

    @ResponseBody
    @PostMapping(value = { "" })
    public ResponseEntity<ObjectNode> createBeer(@RequestAttribute(value = "new-beer") Beer beer) {
        if(beer == null) {
            return ResponseEntity.noContent().build();
        }

        Beer savedBeer = this.beerService.createBeer(beer);

        if(savedBeer == null) {
            return ResponseEntity.badRequest().build();
        }

        ObjectNode json = this.mapper.convertValue(savedBeer, ObjectNode.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(json);
    }

    @ResponseBody
    @PutMapping(value = { "" })
    public ResponseEntity<ObjectNode> updateBeerByObject(@RequestAttribute(value = "new-beer") Beer beer) {
        if(beer == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

}
