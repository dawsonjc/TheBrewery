package tlcm.website.thebrewery.entities.product.alcohol;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import tlcm.website.thebrewery.entities.material.Material;
import tlcm.website.thebrewery.services.alcohol.BeerService;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "beer")
@JsonDeserialize(builder = Beer.Builder.class)
public class Beer extends AbstractAlcoholEntity<Beer.Builder> {

    @Column(name = "color")
    private String color;

    public static Beer.Builder builder() {
        return new Builder();
    }

    @Override
    public Beer.Builder toBuilder() {
        return new Builder()
                .withId(this.id)
                .withCreateDate(this.createDate)
                .withUpdateDate(this.updateDate)
                .withName(this.name)
                .withAlcoholContent(this.alcoholContent)
                .withStyle(this.style)
                .withSize(this.size)
                .withUserId(this.userId)
                .withColor(this.color);
    }

    public List<Material> getBeerMaterialsById(BeerService service) {
        return service.getAllMaterialsById(this.id);
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alcoholContent=" + alcoholContent +
                ", color='" + color + '\'' +
                ", style='" + style + '\'' +
                ", size=" + size +
                ", userId=" + userId +
                '}';
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
        private String color;

        private Builder() {}

        public Beer.Builder withId(BigInteger id) {
            this.id = id;
            return this;
        }

        public Beer.Builder withCreateDate(LocalDateTime createDate) {
            if(this.createDate == null) {
                this.createDate = createDate;
            }

            return this;
        }

        public Beer.Builder withUpdateDate(LocalDateTime updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public Beer.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Beer.Builder withAlcoholContent(Float alcoholContent) {
            this.alcoholContent = alcoholContent;
            return this;
        }

        public Beer.Builder withStyle(String style) {
            this.style = style;
            return this;
        }

        public Beer.Builder withSize(Float size) {
            this.size = size;
            return this;
        }

        public Beer.Builder withUserId(UUID userId) {
            this.userId = userId;
            return this;
        }

        public Beer.Builder withColor(String color) {
            this.color = color;
            return this;
        }

        public Beer build() {
            Beer beer = new Beer();
            beer.id = this.id;
            beer.createDate = this.createDate;
            beer.updateDate = this.updateDate;
            beer.name = this.name;
            beer.alcoholContent = this.alcoholContent;
            beer.style = this.style;
            beer.userId = this.userId;
            beer.size = this.size;
            beer.color = this.color;

            return beer;
        }
    }
}
