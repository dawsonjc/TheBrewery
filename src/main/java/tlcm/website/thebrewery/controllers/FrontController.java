package tlcm.website.thebrewery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tlcm.website.thebrewery.entities.product.Beer;
import tlcm.website.thebrewery.services.BeerService;


@Controller
@RequestMapping(value = "/")
public class FrontController {

    @Autowired
    private BeerService service;

    @RequestMapping(value = "")
    public String index(Model model) {
        int totalPages = service.findAllBeer(PageRequest.of(1, 10, Sort.by("id"))).getTotalPages();
        model.addAttribute("totalPages", totalPages);
        return "index";
    }


    /**
     * An API call to get a paginated query for the beer table.
     * @param page Page Number
     * @param size Amount of elements per page
     * @return Paginated Query
     */
    @ResponseBody
    @GetMapping(value = "beer/get-beer-page")
    public Page<Beer> getPaginatedBeers(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        return this.service.findAllBeer(pageable);
    }
}
