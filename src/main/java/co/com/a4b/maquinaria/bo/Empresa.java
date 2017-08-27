package co.com.a4b.maquinaria.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Empresa")
public class Empresa implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  private String dni;
  private String nombre;


  public Empresa() {
    super();
  }

  public Empresa(String dni, String nombre) {
    super();
    this.dni = dni;
    this.nombre = nombre;
  }


  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
    Empresa other = (Empresa) obj;
    if (dni == null) {
      if (other.dni != null)
        return false;
    } else if (!dni.equals(other.dni))
      return false;
    return true;
  }

}
