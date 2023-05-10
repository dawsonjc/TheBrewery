package tlcm.website.thebrewery.entities.product.alcohol;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public abstract class AbstractAlcoholEntity<BUILDER> {

    @Id
    @GeneratedValue
    @Column(name = "id")
    BigInteger id;

    @Column(name="create_date")
    LocalDateTime createDate;

    @Column(name="update_date")
    LocalDateTime updateDate;

    @Column(name = "name")
    String name;

    @Column(name = "alcohol_content")
    Float alcoholContent;

    @Column(name = "style")
    String style;

    @Column(name = "size")
    Float size;

    @Column(name = "user_id")
    UUID userId;

    public BigInteger getId() {
        return id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public String getName() {
        return name;
    }

    public Float getAlcoholContent() {
        return alcoholContent;
    }

    public String getStyle() {
        return style;
    }

    public Float getSize() {
        return size;
    }

    public UUID getUserId() {
        return userId;
    }

    /*
        Need to also implement a static builder method
     */

    public abstract BUILDER toBuilder();
}
