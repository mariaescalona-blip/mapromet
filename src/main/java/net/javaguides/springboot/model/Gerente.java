package net.javaguides.springboot.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "gerente")
public class Gerente extends Empleado {

    // Ejemplo: un gerente puede gestionar varios productos
    @OneToMany(mappedBy = "gerente", cascade = CascadeType.ALL)
    private List<Producto> productos;

    public Gerente() {}

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
