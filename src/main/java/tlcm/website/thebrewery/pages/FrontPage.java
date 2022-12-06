package tlcm.website.thebrewery.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class FrontPage {

    @RequestMapping(value = "/")
    public String index(Model model) {
        return "index";
    }
}
