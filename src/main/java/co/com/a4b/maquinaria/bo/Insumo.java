package co.com.a4b.maquinaria.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Insumo")
public class Insumo implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idInsumo;
  private String nombre;
  private String Medida;

  public Insumo() {
    super();
  }

  public Insumo(int idInsumo, String nombre, String medida) {
    super();
    this.idInsumo = idInsumo;
    this.nombre = nombre;
    Medida = medida;
  }

  public int getIdInsumo() {
    return idInsumo;
  }

  public void setIdInsumo(int idInsumo) {
    this.idInsumo = idInsumo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getMedida() {
    return Medida;
  }

  public void setMedida(String medida) {
    Medida = medida;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((Medida == null) ? 0 : Medida.hashCode());
    result = prime * result + idInsumo;
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
    Insumo other = (Insumo) obj;
    if (Medida == null) {
      if (other.Medida != null)
        return false;
    } else if (!Medida.equals(other.Medida))
      return false;
    if (idInsumo != other.idInsumo)
      return false;
    if (nombre == null) {
      if (other.nombre != null)
        return false;
    } else if (!nombre.equals(other.nombre))
      return false;
    return true;
  }

}
