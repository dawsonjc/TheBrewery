package tlcm.website.thebrewery.pages;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tlcm.website.thebrewery.converter.ResultSetToUserConverter;
import tlcm.website.thebrewery.entities.User;

import java.sql.*;
import java.util.LinkedList;

@RestController
public class GetAllInformation {

    @GetMapping("/getAll")
    public ResponseEntity<LinkedList<User>> getAll() {
        final String username = "root";
        final String password = "password";
        LinkedList<User> users = new LinkedList<User>();
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/brewery", username, password)) {
            String sql = "SELECT * FROM users";
            Statement st = conn.createStatement();
            ResultSet set = st.executeQuery(sql);
            Enum
            ResultSetToUserConverter converter = new ResultSetToUserConverter(set);
            do {
                users.add(converter.convert());
            } while(!set.isLast());
        } catch(SQLException ignore) { }

        return ResponseEntity.ok(users);
    }

}
