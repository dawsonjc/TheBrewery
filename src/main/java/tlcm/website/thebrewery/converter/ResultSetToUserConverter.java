package tlcm.website.thebrewery.converter;

import tlcm.website.thebrewery.object.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetToUserConverter {
    private final ResultSet set;
    public ResultSetToUserConverter(ResultSet set) {
        this.set = set;
    }

    public User convert() {
        User user = new User();
        try {
            user.setId(set.getString("id"));
            user.setFirstName(set.getString("first_name"));

        } catch(SQLException ignore) {}

        return user;
    }
}
