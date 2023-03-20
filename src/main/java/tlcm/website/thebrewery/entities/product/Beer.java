package tlcm.website.thebrewery.entities.product;

import tlcm.website.thebrewery.entities.AlcoholEntity;
import tlcm.website.thebrewery.entities.material.Material;
import tlcm.website.thebrewery.services.BeerService;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

@Entity
@Table(name = "beer")
public class Beer implements AlcoholEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name="create_date")
    private LocalDateTime createDate;

    @Column(name="update_date")
    private LocalDateTime updateDate;

    @Column(name = "name")
    private String name;

    @Column(name = "alcohol_content")
    private Float alcoholContent;

    @Column(name = "color")
    private String color;

    @Column(name = "style")
    private String style;

    @Column(name = "size")
    private Float size;

    @Column(name = "user_id")
    private BigInteger userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getAlcoholContent() {
        return alcoholContent;
    }

    public void setAlcoholContent(Float alcoholContent) {
        this.alcoholContent = alcoholContent;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public List<Material> getBeerMaterials(BeerService service) {
        return service.getAllMaterials(BigInteger.valueOf((long) this.id));
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
}
