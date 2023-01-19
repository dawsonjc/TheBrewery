package tlcm.website.thebrewery.pages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tlcm.website.thebrewery.converter.ResultSetToUserConverter;
import tlcm.website.thebrewery.entities.User;
import tlcm.website.thebrewery.entities.UserType;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;

@Controller
@RequestMapping(value = "account")
public class Account {

    @GetMapping(value = "")
    public String account() {
        return "account";
    }

    @PostMapping(value = "register")
    public String register(@ModelAttribute(value = "new_user") User user,
                           HttpServletRequest request) {

        final String username = "root";
        final String password = "password";

        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/brewery", username, password)) {
            String sql = "INSERT INTO users (user_type, first_name, last_name, username, password) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, UserType.USER.toString());
            st.setString(2, user.getFirstName());
            st.setString(3, user.getLastName());
            st.setString(4, user.getUsername());
            st.setString(5, user.getPassword());

            st.execute();
        } catch(SQLException e) {
            return "redirect:/error";
        }

        request.getSession().setAttribute("current_user", user);
        return "redirect:/";
    }

    @RequestMapping(value = "login")
    public String login(Model model) {
        model.addAttribute("current_user", new User());
        model.addAttribute("new_user", new User());
        return "Login";
    }

    @PostMapping(value = "login/verify")
    public String loginVerify(@ModelAttribute(value = "current_user") User user,
                              HttpServletRequest request) {
        final String username = "root";
        final String password = "password";

        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/brewery", username, password)) {

            PreparedStatement st = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());

            ResultSetToUserConverter converter = new ResultSetToUserConverter(st.executeQuery());

            User userToLogin = converter.convert();
            if(!user.equals(userToLogin)) {
                return "redirect:/login?result=false";
            }

            request.getSession().setAttribute("current_user", userToLogin);
        } catch(SQLException e) {
            return "redirect:/error";
        }
        return "redirect:/";
    }
}
