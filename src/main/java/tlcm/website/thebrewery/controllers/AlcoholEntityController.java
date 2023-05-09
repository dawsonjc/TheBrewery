package tlcm.website.thebrewery.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import tlcm.website.thebrewery.services.BeerService;

import java.math.BigInteger;


@Controller
@RequestMapping(value = "alcohol")
public class AlcoholEntityController {

    @Autowired
    private BeerService service;

    /*
    TODO: Add other services
     */

    @ResponseBody
    @GetMapping(value = "get-alcohol-information/{productType}")
    public ResponseEntity<ObjectNode> API(
            @PathVariable(value = "productType") String productType,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ) {
        ObjectMapper mapper = new ObjectMapper();

        ObjectNode jsonResponse = mapper.createObjectNode();
        ArrayNode array = jsonResponse.putArray("headers");

        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));

        switch(productType) {
            case "beer":
                for(String header : this.service.getTableColumns()) {
                    array.add(header);
                }
                jsonResponse.set("body", mapper.convertValue(this.service.findAllBeer(pageable), ObjectNode.class));
                break;
            case "whiskey":
                break;
            case "wine":
                break;
            default:
                jsonResponse.put("responxse", "400");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
        }
        return ResponseEntity.ok(jsonResponse);
    }


    @GetMapping(value = "{productType}/alcohol-entity")
    public String alcoholEntity(
            Model model,
            @PathVariable(value = "productType") String productType,
            @RequestParam(value = "id") BigInteger alcoholId
    ) {

        switch(productType) {
            case "beer":
                model.addAttribute("alcohol_entity", this.service.getBeerById(alcoholId));
                return "alcohol/beer";
            case "whiskey":
                return "alcohol/whiskey";
            case "wine":
                return "alcohol/wine";
        }

        RedirectView e = new RedirectView();


        return "redirect:/";
    }
}
