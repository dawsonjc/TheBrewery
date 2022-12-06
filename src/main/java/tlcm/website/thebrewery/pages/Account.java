package tlcm.website.thebrewery.pages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tlcm.website.thebrewery.object.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Controller
@RequestMapping(value = "account")
public class Account {

    @GetMapping(value = "")
    public String account() {
        return "account";
    }

    @PutMapping(value = "register")
    public String register() {

        return "redirect:/account";
    }

    @RequestMapping(value = "login")
    public String login(Model model) {
        model.addAttribute("current_user", new User());
        model.addAttribute("new_user", new User());
        return "Login";
    }

    @PostMapping(value = "login/verify")
    public String loginVerify(@ModelAttribute(value="current_user") User user,
                              HttpServletRequest request) {
        final String username = "root";
        final String password = "password";

        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", username, password)) {

        } catch(SQLException e){
            e.getSQLState();
        }
        return null;
    }

}
