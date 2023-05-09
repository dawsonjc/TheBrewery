package tlcm.website.thebrewery.entities.product.alcohol;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "whiskey")
@JsonDeserialize(builder = Whiskey.Builder.class)
public class Whiskey extends AlcoholEntity<Whiskey.Builder> {




    @Override
    public Builder toBuilder() {
        return null;
    }

    public static class Builder {

    }
}
