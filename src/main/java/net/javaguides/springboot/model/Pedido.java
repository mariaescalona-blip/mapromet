package net.javaguides.springboot.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    private String estado;
    private Date fechaCreacion;
    private int cantidad;

    // Relación con Asesor (sin preocuparte por ahora)
    @ManyToOne
    @JoinColumn(name = "asesor_id")
    private AsesorComercial asesor;

    public Pedido() {}

    // Getters y setters
    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public AsesorComercial getAsesor() {
        return asesor;
    }

    public void setAsesor(AsesorComercial asesor) {
        this.asesor = asesor;
    }
}
