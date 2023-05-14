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
import org.springframework.web.bind.annotation.*;
import tlcm.website.thebrewery.services.alcohol.BeerService;


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
                jsonResponse.put("response", "400");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
        }
        return ResponseEntity.ok(jsonResponse);
    }
}
