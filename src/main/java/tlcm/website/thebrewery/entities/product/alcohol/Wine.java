package tlcm.website.thebrewery.entities.product.alcohol;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "wine")
@JsonDeserialize(builder = Wine.Builder.class)
public class Wine extends AbstractAlcoholEntity<Wine.Builder> {

    public Wine.Builder builder() {
        return new Wine.Builder();
    }

    @Override
    public Wine.Builder toBuilder() {
        return new Wine.Builder()
                .withId(this.id)
                .withCreateDate(this.createDate)
                .withUpdateDate(this.updateDate)
                .withName(this.name)
                .withAlcoholContent(this.alcoholContent)
                .withStyle(this.style)
                .withSize(this.size)
                .withUserId(this.userId);
    }

    @JsonPOJOBuilder
    public static class Builder {
        private BigInteger id;
        private LocalDateTime createDate;
        private LocalDateTime updateDate;
        private String name;
        private Float alcoholContent;
        private String style;
        private Float size;
        private UUID userId;

        private Builder() {}

        public Wine.Builder withId(BigInteger id) {
            this.id = id;
            return this;
        }

        public Wine.Builder withCreateDate(LocalDateTime createDate) {
            if(this.createDate == null) {
                this.createDate = createDate;
            }

            return this;
        }

        public Wine.Builder withUpdateDate(LocalDateTime updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public Wine.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Wine.Builder withAlcoholContent(Float alcoholContent) {
            this.alcoholContent = alcoholContent;
            return this;
        }

        public Wine.Builder withStyle(String style) {
            this.style = style;
            return this;
        }

        public Wine.Builder withSize(Float size) {
            this.size = size;
            return this;
        }

        public Wine.Builder withUserId(UUID userId) {
            this.userId = userId;
            return this;
        }

        public Wine build() {
            Wine wine = new Wine();
            wine.id = this.id;
            wine.createDate = this.createDate;
            wine.updateDate = this.updateDate;
            wine.name = this.name;
            wine.alcoholContent = this.alcoholContent;
            wine.style = this.style;
            wine.userId = this.userId;
            wine.size = this.size;

            return wine;
        }
    }
}
