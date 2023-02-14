package tlcm.website.thebrewery.converter;

import tlcm.website.thebrewery.entities.users.Users;
import tlcm.website.thebrewery.entities.users.FrontUser;

public class UserConverter {

    /**
     * Converts Front End User to Backend user.
     *
     * @return User to the Database
     */
    public Users convertFrontUserToBackEndUser(FrontUser frontUser) {
        return Users.builder()
                .withId(frontUser.getId())
                .withFirstName(frontUser.getFirstName())
                .withLastName(frontUser.getLastName())
                .withUsername(frontUser.getUsername())
                .withPassword(frontUser.getPassword())
                .build();
    }

    public FrontUser convertBackEndUserToFrontUser(Users backEndUser) {
        return FrontUser.builder()
                .withId(backEndUser.getId())
                .withFirstName(backEndUser.getFirstName())
                .withLastName(backEndUser.getLastName())
                .withUsername(backEndUser.getUsername())
                .withPassword(backEndUser.getPassword())
                .build();
    }
}
