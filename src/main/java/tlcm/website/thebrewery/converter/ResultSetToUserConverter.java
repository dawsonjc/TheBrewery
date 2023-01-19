package tlcm.website.thebrewery.converter;

import tlcm.website.thebrewery.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetToUserConverter {
    private final ResultSet set;
    public ResultSetToUserConverter(ResultSet set) {
        this.set = set;
    }

    /**
     * This retrieves a user from the Database. <bold>And moves the ResultSet cursor.</bold>
     *
     * @return User to the Database
     */
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
