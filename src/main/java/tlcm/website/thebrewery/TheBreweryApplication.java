package tlcm.website.thebrewery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
public class TheBreweryApplication {
    public static void main(String[] args) {
        SpringApplication.run(TheBreweryApplication.class, args);
    }


    // TODO: need to make error page better and have errors actually redirect here
    @RequestMapping(value = "/error")
    public String error(Model model, HttpServletRequest request) {
        request.setAttribute("errorMessage", model.getAttribute("errorMessage"));
        return "error";
    }
}
