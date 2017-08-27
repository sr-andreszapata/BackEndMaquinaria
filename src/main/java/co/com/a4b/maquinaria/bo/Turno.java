package co.com.a4b.maquinaria.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Turno")
public class Turno implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idTurno;
  private String descripcion;



  public Turno() {
    super();
  }

  public Turno(int idTurno, String descripcion) {
    super();
    this.idTurno = idTurno;
    this.descripcion = descripcion;
  }

  public int getIdTurno() {
    return idTurno;
  }

  public void setIdTurno(int idTurno) {
    this.idTurno = idTurno;
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
    result = prime * result + idTurno;
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
    Turno other = (Turno) obj;
    if (descripcion == null) {
      if (other.descripcion != null)
        return false;
    } else if (!descripcion.equals(other.descripcion))
      return false;
    if (idTurno != other.idTurno)
      return false;
    return true;
  }

}
