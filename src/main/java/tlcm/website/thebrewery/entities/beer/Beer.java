package tlcm.website.thebrewery.entities.beer;

import tlcm.website.thebrewery.entities.material.Material;

import java.util.ArrayList;

public class Beer {
    private Integer id;
    private String title;
    private String color;
    private String style;
    private Integer brewedById;
    private ArrayList<Material> materials;


}
