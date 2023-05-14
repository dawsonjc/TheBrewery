package tlcm.website.thebrewery.exceptions;

public class UserNotCreatedException extends RuntimeException {
    private static final long serialVersionUID = 2540520574437753309L;

    @Override
    public String toString() {
        return "The creation of this User encountered an error";
    }
}
