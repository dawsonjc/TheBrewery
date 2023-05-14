package tlcm.website.thebrewery.controllers.alcohol;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tlcm.website.thebrewery.services.UserService;
import tlcm.website.thebrewery.services.alcohol.WineService;

import java.math.BigInteger;

@Controller
@RequestMapping(value = { "alcohol/wine" })
public class WineController {

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private WineService wineService;

    @Autowired
    private UserService userService;

    @GetMapping(value = { "" })
    public String wineView(@RequestParam(value = "id") BigInteger id,
                           Model model
    ) {

        model.addAttribute("alcohol-entity", this.wineService.getWineById(id));
        model.addAttribute("created-by", "");

        return "alcohol/wine";
    }
}
