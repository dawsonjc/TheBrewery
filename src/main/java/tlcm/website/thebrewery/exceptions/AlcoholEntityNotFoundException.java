package tlcm.website.thebrewery.exceptions;

public class AlcoholEntityNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -1009719778763559717L;

    public AlcoholEntityNotFoundException() {
    }

    @Override
    public String toString() {
        return "Alcohol entity not found";
    }
}
