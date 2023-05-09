package tlcm.website.thebrewery.entities.product.alcohol;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "wine")
@JsonDeserialize(builder = Wine.Builder.class)
public class Wine extends AlcoholEntity<Wine.Builder> {


    @Override
    public Builder toBuilder() {
        return null;
    }

    public static class Builder {


    }
}
