package tlcm.website.thebrewery.converter;

import tlcm.website.thebrewery.object.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetToUserConverter {
    private ResultSet set;
    public ResultSetToUserConverter(ResultSet set) {
        this.set = set;
    }

    public User convert() {
        User user = null;
        try {
            this.set.next();

            user = User.builder()
                    .withId(this.set.getInt(2))
                    .withFirstName(this.set.getString(3))
                    .withLastName(this.set.getString(4))
                    .withUsername(this.set.getString(5))
                    .withPassword(this.set.getString(6))
                    .build();
        } catch(SQLException ignore) { }
        return user;
    }
}
