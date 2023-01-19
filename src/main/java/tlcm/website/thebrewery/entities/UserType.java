package tlcm.website.thebrewery.entities;

public enum UserType {
    ADMIN("Admin"),
    USER("User");

    private final String name;

    UserType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
