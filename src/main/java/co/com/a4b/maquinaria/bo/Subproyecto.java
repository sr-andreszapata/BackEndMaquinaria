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
@Table(name = "Subproyecto")
public class Subproyecto implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idSubproyecto;
  private String nombre;
  private String departamento;
  private String ciudad;
  private String direccion;
  @ManyToOne
  @JoinColumn(name = "idProyecto")
  private Proyecto proyecto;

  public Subproyecto() {
    super();
  }

  public Subproyecto(int idSubproyecto, String nombre, String departamento, String ciudad,
      String direccion, Proyecto proyecto) {
    super();
    this.idSubproyecto = idSubproyecto;
    this.nombre = nombre;
    this.departamento = departamento;
    this.ciudad = ciudad;
    this.direccion = direccion;
    this.proyecto = proyecto;
  }

  public int getIdSubproyecto() {
    return idSubproyecto;
  }

  public void setIdSubproyecto(int idSubproyecto) {
    this.idSubproyecto = idSubproyecto;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDepartamento() {
    return departamento;
  }

  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public Proyecto getProyecto() {
    return proyecto;
  }

  public void setProyecto(Proyecto proyecto) {
    this.proyecto = proyecto;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
    result = prime * result + ((departamento == null) ? 0 : departamento.hashCode());
    result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
    result = prime * result + idSubproyecto;
    result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
    result = prime * result + ((proyecto == null) ? 0 : proyecto.hashCode());
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
    Subproyecto other = (Subproyecto) obj;
    if (ciudad == null) {
      if (other.ciudad != null)
        return false;
    } else if (!ciudad.equals(other.ciudad))
      return false;
    if (departamento == null) {
      if (other.departamento != null)
        return false;
    } else if (!departamento.equals(other.departamento))
      return false;
    if (direccion == null) {
      if (other.direccion != null)
        return false;
    } else if (!direccion.equals(other.direccion))
      return false;
    if (idSubproyecto != other.idSubproyecto)
      return false;
    if (nombre == null) {
      if (other.nombre != null)
        return false;
    } else if (!nombre.equals(other.nombre))
      return false;
    if (proyecto == null) {
      if (other.proyecto != null)
        return false;
    } else if (!proyecto.equals(other.proyecto))
      return false;
    return true;
  }
}
