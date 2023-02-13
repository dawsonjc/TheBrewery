package tlcm.website.thebrewery.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;


@Controller
public class FrontPage {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }




}
