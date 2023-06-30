package quanam.platzispringclass.persistence.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto;

    private String nombreProducto;

    private Integer id_categoria;

    private String codigoBarras;

    private Double precioVenta;

    private Integer cantidadStock;
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Categoria categoria;


}
