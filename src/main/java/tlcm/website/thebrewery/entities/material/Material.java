package tlcm.website.thebrewery.entities.material;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "material")
public class Material {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private BigInteger id;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "material_type")
    private MaterialType type;

    @Column(name = "alcohol_id")
    private Integer alcoholId;

}
