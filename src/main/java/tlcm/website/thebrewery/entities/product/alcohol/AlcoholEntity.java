package tlcm.website.thebrewery.entities.product.alcohol;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public abstract class AlcoholEntity<BUILDER> {

    @Id
    @GeneratedValue
    @Column(name = "id")
    protected BigInteger id;

    @Column(name="create_date")
    protected LocalDateTime createDate;

    @Column(name="update_date")
    protected LocalDateTime updateDate;

    @Column(name = "name")
    protected String name;

    @Column(name = "alcohol_content")
    protected Float alcoholContent;

    @Column(name = "style")
    protected String style;

    @Column(name = "size")
    protected Float size;

    @Column(name = "user_id")
    protected UUID userId;

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
