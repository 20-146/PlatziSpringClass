package quanam.platzispringclass.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ComprasProducto {

    @EmbeddedId
    private ComprasProductoPK id;
    private Integer cantidad;
    private Double total;
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto productos;

    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Compra compra;
}
