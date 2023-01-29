package tlcm.website.thebrewery.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tlcm.website.thebrewery.converter.UserConverter;
import tlcm.website.thebrewery.entities.BackEndUser;
import tlcm.website.thebrewery.entities.FrontUser;
import tlcm.website.thebrewery.services.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "account")
public class Account {

    @Autowired
    private UserService service;

    @GetMapping(value = "")
    public String account() {
        return "account";
    }

    @PostMapping(value = "register")
    public String register(@ModelAttribute(value = "new_user") FrontUser user,
                           HttpServletRequest request) {
        UserConverter converter = new UserConverter();
        BackEndUser theUser = service.createUser(converter.convertFrontUserToBackEndUser(user));
        if(theUser == null) {
            return "redirect:/error";
        }

        FrontUser frontUser = converter.convertBackEndUserToFrontUser(theUser);

        request.getSession().setAttribute("current_user", frontUser);
        return "redirect:/";
    }

    @RequestMapping(value = "login")
    public String login(Model model) {
        model.addAttribute("current_user", new FrontUser());
        model.addAttribute("new_user", new FrontUser());
        return "Login";
    }

    @PostMapping(value = "login/verify")
    public String loginVerify(@ModelAttribute(value = "current_user") FrontUser userToLogin,
                              HttpServletRequest request) {
        UserConverter converter = new UserConverter();

        BackEndUser user = converter.convertFrontUserToBackEndUser(userToLogin);

        if(!this.service.userExists(user)) {
            return "redirect:/";
        }

        request.getSession().setAttribute("current_user", converter.convertBackEndUserToFrontUser(user));

        return "redirect:/";
    }
}
