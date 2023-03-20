package tlcm.website.thebrewery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping(value = "/admin")
    public String admin() {
        return "admin";
    }
}
