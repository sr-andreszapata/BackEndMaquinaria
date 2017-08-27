package co.com.a4b.maquinaria.bo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import co.com.a4b.maquinaria.utils.UtilidadFecha;

@Entity
@Table(name = "HistoricoEmpleadoMaquina")
public class HistoricoEmpleadoMaquina implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idHistoricoEmpleadoMaquina;
  @ManyToOne
  @JoinColumn(name = "dniEmpleado")
  private Empleado empleado;
  @ManyToOne
  @JoinColumn(name = "idMaquina")
  private Maquina maquina;
  private Date fechaAsignacion;
  private String fechaRetiro;


  @PrePersist
  protected void onCreate() {
    fechaAsignacion = new Date();
  }


  public HistoricoEmpleadoMaquina() {
    super();
  }

  public HistoricoEmpleadoMaquina(int idHistoricoEmpleadoMaquina, Empleado empleado,
      Maquina maquina, Date fechaAsignacion, String fechaRetiro) {
    super();
    this.idHistoricoEmpleadoMaquina = idHistoricoEmpleadoMaquina;
    this.empleado = empleado;
    this.maquina = maquina;
    this.fechaAsignacion = fechaAsignacion;
    this.fechaRetiro = fechaRetiro;
  }

  public int getIdHistoricoEmpleadoMaquina() {
    return idHistoricoEmpleadoMaquina;
  }

  public void setIdHistoricoEmpleadoMaquina(int idHistoricoEmpleadoMaquina) {
    this.idHistoricoEmpleadoMaquina = idHistoricoEmpleadoMaquina;
  }

  public Empleado getEmpleado() {
    return empleado;
  }

  public void setEmpleado(Empleado empleado) {
    this.empleado = empleado;
  }

  public Maquina getMaquina() {
    return maquina;
  }

  public void setMaquina(Maquina maquina) {
    this.maquina = maquina;
  }

  public Date getFechaAsignacion() {
    return fechaAsignacion;
  }

  public void setFechaAsignacion(Date fechaAsignacion) {
    this.fechaAsignacion = fechaAsignacion;
  }

  public String getFechaRetiro() {
    return fechaRetiro;
  }

  public void setFechaRetiro(String fechaRetiro) {
    this.fechaRetiro = UtilidadFecha.formatearFecha(fechaRetiro);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((empleado == null) ? 0 : empleado.hashCode());
    result = prime * result + ((fechaAsignacion == null) ? 0 : fechaAsignacion.hashCode());
    result = prime * result + ((fechaRetiro == null) ? 0 : fechaRetiro.hashCode());
    result = prime * result + idHistoricoEmpleadoMaquina;
    result = prime * result + ((maquina == null) ? 0 : maquina.hashCode());
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
    HistoricoEmpleadoMaquina other = (HistoricoEmpleadoMaquina) obj;
    if (empleado == null) {
      if (other.empleado != null)
        return false;
    } else if (!empleado.equals(other.empleado))
      return false;
    if (fechaAsignacion == null) {
      if (other.fechaAsignacion != null)
        return false;
    } else if (!fechaAsignacion.equals(other.fechaAsignacion))
      return false;
    if (fechaRetiro == null) {
      if (other.fechaRetiro != null)
        return false;
    } else if (!fechaRetiro.equals(other.fechaRetiro))
      return false;
    if (idHistoricoEmpleadoMaquina != other.idHistoricoEmpleadoMaquina)
      return false;
    if (maquina == null) {
      if (other.maquina != null)
        return false;
    } else if (!maquina.equals(other.maquina))
      return false;
    return true;
  }

}
