package tlcm.website.thebrewery.converter;

import tlcm.website.thebrewery.entities.BackEndUser;
import tlcm.website.thebrewery.entities.FrontUser;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserConverter {

    /**
     * Converts Front End User to Backend user.
     *
     * @return User to the Database
     */
    public BackEndUser convertFrontUserToBackEndUser(FrontUser frontUser) {
        return BackEndUser.builder()
                .withId(frontUser.getId())
                .withFirstName(frontUser.getFirstName())
                .withLastName(frontUser.getLastName())
                .withUsername(frontUser.getUsername())
                .withPassword(frontUser.getPassword())
                .build();
    }

    public FrontUser convertBackEndUserToFrontUser(BackEndUser backEndUser) {
        return FrontUser.builder()
                .withId(backEndUser.getId())
                .withFirstName(backEndUser.getFirstName())
                .withLastName(backEndUser.getLastName())
                .withUsername(backEndUser.getUsername())
                .withPassword(backEndUser.getPassword())
                .build();
    }


}
