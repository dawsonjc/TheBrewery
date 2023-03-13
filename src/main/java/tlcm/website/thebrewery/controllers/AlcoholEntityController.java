package tlcm.website.thebrewery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tlcm.website.thebrewery.entities.AlcoholEntity;
import tlcm.website.thebrewery.services.BeerService;

@Controller
@RequestMapping(value = "alcohol")
public class AlcoholEntityController {



    /*
    TODO: Add other services
     */
    @RestController
    @RequestMapping(value = "alcohol")
    public static class bruh {
        @Autowired private BeerService service;

        @GetMapping(value = "get-alcohol-information/{productType}/{returnType}")
        public String API(
                @PathVariable(value = "productType") String productType,
                @PathVariable(value = "returnType") String returnType
        ) {
            AlcoholEntity entity;


            return "{\n\tresponse:500\n}";
        }

    }


}
