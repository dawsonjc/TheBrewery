package tlcm.website.thebrewery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tlcm.website.thebrewery.converter.UserConverter;
import tlcm.website.thebrewery.entities.users.Users;
import tlcm.website.thebrewery.entities.users.FrontUser;
import tlcm.website.thebrewery.exceptions.UserNotCreatedException;
import tlcm.website.thebrewery.services.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "account")
public class AccountController {

    @Autowired
    private UserService service;

    @GetMapping(value = "")
    public String account() {
        return "account";
    }

    @PostMapping(value = "register")
    public String register(Model model,
                           HttpServletRequest request,
                           @ModelAttribute(value = "new_user") FrontUser user) {
        UserConverter converter = new UserConverter();
        Users theUser = service.createUser(converter.convertFrontUserToBackEndUser(user));
        if(theUser == null) {
            model.addAttribute("error", new UserNotCreatedException());
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
    public String loginVerify(HttpServletRequest request,
                              @ModelAttribute(value = "current_user") FrontUser userToLogin) {
        UserConverter converter = new UserConverter();

        Users user = converter.convertFrontUserToBackEndUser(userToLogin);

        if(!this.service.userExists(userToLogin)) {
            return "redirect:/login?result=false";
        }

        request.getSession().setAttribute("current_user", converter.convertBackEndUserToFrontUser(user));

        return "redirect:/";
    }
}
