package quanam.platzispringclass.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
public class ComprasProductoPK implements Serializable {

    private Integer id_compra;
    private Integer id_producto;
}
