package tlcm.website.thebrewery.entities.product.alcohol;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "whiskey")
@JsonDeserialize(builder = Whiskey.Builder.class)
public class Whiskey extends AbstractAlcoholEntity<Whiskey.Builder> {


    public Whiskey.Builder builder() {
        return new Whiskey.Builder();
    }

    @Override
    public Whiskey.Builder toBuilder() {
        return new Whiskey.Builder()
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

        public Whiskey.Builder withId(BigInteger id) {
            this.id = id;
            return this;
        }

        public Whiskey.Builder withCreateDate(LocalDateTime createDate) {
            if(this.createDate == null) {
                this.createDate = createDate;
            }

            return this;
        }

        public Whiskey.Builder withUpdateDate(LocalDateTime updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public Whiskey.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Whiskey.Builder withAlcoholContent(Float alcoholContent) {
            this.alcoholContent = alcoholContent;
            return this;
        }

        public Whiskey.Builder withStyle(String style) {
            this.style = style;
            return this;
        }

        public Whiskey.Builder withSize(Float size) {
            this.size = size;
            return this;
        }

        public Whiskey.Builder withUserId(UUID userId) {
            this.userId = userId;
            return this;
        }

        public Whiskey build() {
            Whiskey whiskey = new Whiskey();
            whiskey.id = this.id;
            whiskey.createDate = this.createDate;
            whiskey.updateDate = this.updateDate;
            whiskey.name = this.name;
            whiskey.alcoholContent = this.alcoholContent;
            whiskey.style = this.style;
            whiskey.userId = this.userId;
            whiskey.size = this.size;

            return whiskey;
        }
    }
}
