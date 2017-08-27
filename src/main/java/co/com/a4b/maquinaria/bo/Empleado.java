package co.com.a4b.maquinaria.bo;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import co.com.a4b.maquinaria.utils.UtilidadFecha;

@Entity
@Table(name = "Empleado")
public class Empleado implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  private String dni;
  private String nombre;
  private String correo;
  private long telefono;
  private long celular;
  private String fechaAlta;
  private String fechaBaja;

  @ManyToOne
  @JoinColumn(name = "idEmpresa")
  private Empresa empresa;

  public Empleado() {
    super();
  }

  public Empleado(String dni, String nombre, String correo, long telefono, long celular,
      String fechaAlta, String fechaBaja, Empresa empresa) {
    super();
    this.dni = dni;
    this.nombre = nombre;
    this.correo = correo;
    this.telefono = telefono;
    this.celular = celular;
    this.fechaAlta = fechaAlta;
    this.fechaBaja = fechaBaja;
    this.empresa = empresa;
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

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public long getTelefono() {
    return telefono;
  }

  public void setTelefono(long telefono) {
    this.telefono = telefono;
  }

  public long getCelular() {
    return celular;
  }

  public void setCelular(long celular) {
    this.celular = celular;
  }

  public String getFechaAlta() {
    return fechaAlta;
  }

  public void setFechaAlta(String fechaAlta) {
    this.fechaAlta = UtilidadFecha.formatearFecha(fechaAlta);
  }

  public String getFechaBaja() {
    return fechaBaja;
  }

  public void setFechaBaja(String fechaBaja) {
    this.fechaBaja = UtilidadFecha.formatearFecha(fechaBaja);
  }

  public Empresa getEmpresa() {
    return empresa;
  }

  public void setEmpresa(Empresa empresa) {
    this.empresa = empresa;
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
    Empleado other = (Empleado) obj;
    if (dni == null) {
      if (other.dni != null)
        return false;
    } else if (!dni.equals(other.dni))
      return false;
    return true;
  }
}
