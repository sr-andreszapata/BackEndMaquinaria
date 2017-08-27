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

@Entity
@Table(name = "ReporteVolqueta")
public class ReporteVolqueta implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idReporteVolqueta;
  private int numeroRecibo;
  private double horasTrabajadas;
  private int numeroViajes;
  private String observaciones;
  private Date fechaRegistro;

  @ManyToOne
  @JoinColumn(name = "placa")
  private Volqueta volqueta;

  @ManyToOne
  @JoinColumn(name = "idSubproyecto")
  private Subproyecto subproyecto;
  @ManyToOne
  @JoinColumn(name = "idTurno")
  private Turno turno;
  @ManyToOne
  @JoinColumn(name = "idRuta")
  private Ruta ruta;


  @PrePersist
  protected void onCreate() {
    fechaRegistro = new Date();
  }


  public ReporteVolqueta() {
    super();
  }

  public ReporteVolqueta(int idReporteVolqueta, int numeroRecibo, double horasTrabajadas,
      int numeroViajes, String observaciones, Date fechaRegistro, Volqueta volqueta,
      Subproyecto subproyecto, Turno turno, Ruta ruta) {
    super();
    this.idReporteVolqueta = idReporteVolqueta;
    this.numeroRecibo = numeroRecibo;
    this.horasTrabajadas = horasTrabajadas;
    this.numeroViajes = numeroViajes;
    this.observaciones = observaciones;
    this.fechaRegistro = fechaRegistro;
    this.volqueta = volqueta;
    this.subproyecto = subproyecto;
    this.turno = turno;
    this.ruta = ruta;
  }

  public int getIdReporteVolqueta() {
    return idReporteVolqueta;
  }

  public void setIdReporteVolqueta(int idReporteVolqueta) {
    this.idReporteVolqueta = idReporteVolqueta;
  }

  public int getNumeroRecibo() {
    return numeroRecibo;
  }

  public void setNumeroRecibo(int numeroRecibo) {
    this.numeroRecibo = numeroRecibo;
  }

  public double getHorasTrabajadas() {
    return horasTrabajadas;
  }

  public void setHorasTrabajadas(double horasTrabajadas) {
    this.horasTrabajadas = horasTrabajadas;
  }

  public int getNumeroViajes() {
    return numeroViajes;
  }

  public void setNumeroViajes(int numeroViajes) {
    this.numeroViajes = numeroViajes;
  }

  public String getObservaciones() {
    return observaciones;
  }

  public void setObservaciones(String observaciones) {
    this.observaciones = observaciones;
  }

  public Date getFechaRegistro() {
    return fechaRegistro;
  }

  public void setFechaRegistro(Date fechaRegistro) {
    this.fechaRegistro = fechaRegistro;
  }

  public Volqueta getVolqueta() {
    return volqueta;
  }

  public void setVolqueta(Volqueta volqueta) {
    this.volqueta = volqueta;
  }

  public Subproyecto getSubproyecto() {
    return subproyecto;
  }

  public void setSubproyecto(Subproyecto subproyecto) {
    this.subproyecto = subproyecto;
  }

  public Turno getTurno() {
    return turno;
  }

  public void setTurno(Turno turno) {
    this.turno = turno;
  }

  public Ruta getRuta() {
    return ruta;
  }

  public void setRuta(Ruta ruta) {
    this.ruta = ruta;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fechaRegistro == null) ? 0 : fechaRegistro.hashCode());
    long temp;
    temp = Double.doubleToLongBits(horasTrabajadas);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + idReporteVolqueta;
    result = prime * result + numeroRecibo;
    result = prime * result + numeroViajes;
    result = prime * result + ((observaciones == null) ? 0 : observaciones.hashCode());
    result = prime * result + ((ruta == null) ? 0 : ruta.hashCode());
    result = prime * result + ((subproyecto == null) ? 0 : subproyecto.hashCode());
    result = prime * result + ((turno == null) ? 0 : turno.hashCode());
    result = prime * result + ((volqueta == null) ? 0 : volqueta.hashCode());
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
    ReporteVolqueta other = (ReporteVolqueta) obj;
    if (fechaRegistro == null) {
      if (other.fechaRegistro != null)
        return false;
    } else if (!fechaRegistro.equals(other.fechaRegistro))
      return false;
    if (Double.doubleToLongBits(horasTrabajadas) != Double.doubleToLongBits(other.horasTrabajadas))
      return false;
    if (idReporteVolqueta != other.idReporteVolqueta)
      return false;
    if (numeroRecibo != other.numeroRecibo)
      return false;
    if (numeroViajes != other.numeroViajes)
      return false;
    if (observaciones == null) {
      if (other.observaciones != null)
        return false;
    } else if (!observaciones.equals(other.observaciones))
      return false;
    if (ruta == null) {
      if (other.ruta != null)
        return false;
    } else if (!ruta.equals(other.ruta))
      return false;
    if (subproyecto == null) {
      if (other.subproyecto != null)
        return false;
    } else if (!subproyecto.equals(other.subproyecto))
      return false;
    if (turno == null) {
      if (other.turno != null)
        return false;
    } else if (!turno.equals(other.turno))
      return false;
    if (volqueta == null) {
      if (other.volqueta != null)
        return false;
    } else if (!volqueta.equals(other.volqueta))
      return false;
    return true;
  }

}
