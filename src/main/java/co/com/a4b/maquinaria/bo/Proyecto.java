package co.com.a4b.maquinaria.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Proyecto")
public class Proyecto implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idProyecto;
  private String nombre;
  @ManyToOne
  @JoinColumn(name = "dniCliente")
  private Cliente cliente;

  public Proyecto() {
    super();
  }

  public Proyecto(int idProyecto, String nombre, Cliente cliente) {
    super();
    this.idProyecto = idProyecto;
    this.nombre = nombre;
    this.cliente = cliente;
  }

  public int getIdProyecto() {
    return idProyecto;
  }

  public void setIdProyecto(int idProyecto) {
    this.idProyecto = idProyecto;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
    result = prime * result + idProyecto;
    result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Proyecto other = (Proyecto) obj;
    if (cliente == null) {
      if (other.cliente != null)
        return false;
    } else if (!cliente.equals(other.cliente))
      return false;
    if (idProyecto != other.idProyecto)
      return false;
    if (nombre == null) {
      if (other.nombre != null)
        return false;
    } else if (!nombre.equals(other.nombre))
      return false;
    return true;
  }

}
