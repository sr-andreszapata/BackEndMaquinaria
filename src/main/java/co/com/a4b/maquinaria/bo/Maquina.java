package co.com.a4b.maquinaria.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Maquina")
public class Maquina implements Serializable {

  private static final long serialVersionUID = -7935453606453323735L;

  @Id
  private String IdMaquina;
  private String nombre;

  public Maquina() {
    super();
  }

  public Maquina(String IdMaquina, String nombre) {
    super();
    this.IdMaquina = IdMaquina;
    this.nombre = nombre;
  }

  public String getIdMaquina() {
    return IdMaquina;
  }

  public void setIdMaquina(String idMaquina) {
    IdMaquina = idMaquina;
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
    result = prime * result + ((IdMaquina == null) ? 0 : IdMaquina.hashCode());
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
    Maquina other = (Maquina) obj;
    if (IdMaquina == null) {
      if (other.IdMaquina != null)
        return false;
    } else if (!IdMaquina.equals(other.IdMaquina))
      return false;
    if (nombre == null) {
      if (other.nombre != null)
        return false;
    } else if (!nombre.equals(other.nombre))
      return false;
    return true;
  }

}
