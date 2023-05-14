package tlcm.website.thebrewery.controllers.alcohol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tlcm.website.thebrewery.services.alcohol.WhiskeyService;

import java.math.BigInteger;

@Controller
@RequestMapping(value = { "alcohol/whiskey" })
public class WhiskeyController {

    @Autowired
    private WhiskeyService whiskeyService;

    @GetMapping(value = { "" })
    public String whiskeyView(@RequestParam(value = "id") BigInteger id,
                              Model model
    ) {
        model.addAttribute("alcohol-entity", this.whiskeyService.getWhiskeyById(id));

        return "alcohol/whiskey";
    }
}
