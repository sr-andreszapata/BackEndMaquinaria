package co.com.a4b.maquinaria.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private String dni;
  private String nombre;
  private int telefono;
  private String departamento;
  private String ciudad;
  private String direccion;
  private String correo;

  public Cliente() {
    super();
  }

  public Cliente(String dni, String nombre, int telefono, String departamento, String ciudad,
      String direccion, String correo) {
    super();
    this.dni = dni;
    this.nombre = nombre;
    this.telefono = telefono;
    this.departamento = departamento;
    this.ciudad = ciudad;
    this.direccion = direccion;
    this.correo = correo;
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

  public int getTelefono() {
    return telefono;
  }

  public void setTelefono(int telefono) {
    this.telefono = telefono;
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

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
    result = prime * result + ((correo == null) ? 0 : correo.hashCode());
    result = prime * result + ((departamento == null) ? 0 : departamento.hashCode());
    result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
    result = prime * result + ((dni == null) ? 0 : dni.hashCode());
    result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
    result = prime * result + telefono;
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
    Cliente other = (Cliente) obj;
    if (ciudad == null) {
      if (other.ciudad != null)
        return false;
    } else if (!ciudad.equals(other.ciudad))
      return false;
    if (correo == null) {
      if (other.correo != null)
        return false;
    } else if (!correo.equals(other.correo))
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
    if (dni == null) {
      if (other.dni != null)
        return false;
    } else if (!dni.equals(other.dni))
      return false;
    if (nombre == null) {
      if (other.nombre != null)
        return false;
    } else if (!nombre.equals(other.nombre))
      return false;
    if (telefono != other.telefono)
      return false;
    return true;
  }
}
