package net.javaguides.springboot.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "asesor_comercial")
public class AsesorComercial extends Empleado {

    // Ejemplo: un asesor puede tener varios pedidos
    @OneToMany(mappedBy = "asesor", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

    public AsesorComercial() {}

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
