package tlcm.website.thebrewery.entities.product;

import tlcm.website.thebrewery.entities.AlcoholEntity;
import tlcm.website.thebrewery.entities.material.Material;
import tlcm.website.thebrewery.services.BeerService;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "beer")
public class Beer implements AlcoholEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "alcohol_content")
    private float alcoholContent;
    @Column(name = "color")
    private String color;
    @Column(name = "style")
    private String style;
    @Column(name = "size")
    private float size;
    @Column(name = "user_id")
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAlcoholContent() {
        return alcoholContent;
    }

    public void setAlcoholContent(float alcoholContent) {
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

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ArrayList<Material> getBeerMaterials(BeerService service) {
        return service.getAllMaterials(this.id);
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
