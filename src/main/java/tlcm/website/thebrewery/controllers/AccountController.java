package tlcm.website.thebrewery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tlcm.website.thebrewery.entities.users.Users;
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
                           @ModelAttribute(value = "new_user") Users user
    ) {
        user = user.toBuilder()
                .withPassword(Users.encryptPassword(user.getPassword()))
                .build();

        Users theUser = this.service.createUser(user);
        if(theUser == null) {
            model.addAttribute("error", new UserNotCreatedException());
            return "redirect:/error";
        }

        request.getSession().setAttribute("current_user", theUser);
        return "redirect:/";
    }

    @RequestMapping(value = "login")
    public String login(Model model) {
        model.addAttribute("current_user", new Users());
        model.addAttribute("new_user", new Users());
        return "login";
    }

    @PostMapping(value = "login/verify")
    public String loginVerify(HttpServletRequest request,
                              @ModelAttribute(value = "current_user") Users userToLogin) {
        if(!this.service.userExists(userToLogin)) {
            return "redirect:/account/login?result=false";
        }
        Users currentUser = this.service.getUserByUserNameAndPassword(userToLogin);
        request.getSession().setAttribute("current_user", currentUser);

        return "redirect:/";
    }
}
