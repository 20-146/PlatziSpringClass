package quanam.platzispringclass.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_compra;
    private Integer id_cliente;
    private LocalDate fecha;
    private String medioPago;
    private String comentario;
    private char estado;

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Cliente clientes;

    @OneToMany(mappedBy = "productos")
    private List<ComprasProducto> productos;
}
