package co.com.a4b.maquinaria.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Actividad")
public class Actividad implements Serializable {

  private static final long serialVersionUID = -3910224263013995918L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idActividad;
  private String descripcion;

  public Actividad() {
    super();
  }

  public Actividad(int idActividad, String descripcion) {
    super();
    this.idActividad = idActividad;
    this.descripcion = descripcion;
  }

  public int getIdActividad() {
    return idActividad;
  }

  public void setIdActividad(int idActividad) {
    this.idActividad = idActividad;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
    result = prime * result + idActividad;
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
    Actividad other = (Actividad) obj;
    if (descripcion == null) {
      if (other.descripcion != null)
        return false;
    } else if (!descripcion.equals(other.descripcion))
      return false;
    if (idActividad != other.idActividad)
      return false;
    return true;
  }

}
