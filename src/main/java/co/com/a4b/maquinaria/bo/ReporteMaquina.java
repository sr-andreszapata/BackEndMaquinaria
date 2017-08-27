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
@Table(name = "ReporteMaquina")
public class ReporteMaquina implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idReporteMaquina;
  private int numeroRecibo;
  private double horometroInicial;
  private double horometroFinal;
  private String horaInicial;
  private String horaFinal;
  private String observaciones;
  private Date fechaRegistro;

  @ManyToOne
  @JoinColumn(name = "idActividad")
  private Actividad actividad;
  @ManyToOne
  @JoinColumn(name = "idTurno")
  private Turno turno;
  @ManyToOne
  @JoinColumn(name = "idMaquina")
  private Maquina maquina;
  @ManyToOne
  @JoinColumn(name = "idSubproyecto")
  private Subproyecto subproyecto;

  @PrePersist
  protected void onCreate() {
    fechaRegistro = new Date();
  }

  public ReporteMaquina() {
    super();
  }

  public ReporteMaquina(int idReporteMaquina, int numeroRecibo, double horometroInicial,
      double horometroFinal, String horaInicial, String horaFinal, String observaciones,
      Date fechaRegistro, Actividad actividad, Turno turno, Maquina maquina,
      Subproyecto subproyecto) {
    super();
    this.idReporteMaquina = idReporteMaquina;
    this.numeroRecibo = numeroRecibo;
    this.horometroInicial = horometroInicial;
    this.horometroFinal = horometroFinal;
    this.horaInicial = horaInicial;
    this.horaFinal = horaFinal;
    this.observaciones = observaciones;
    this.fechaRegistro = fechaRegistro;
    this.actividad = actividad;
    this.turno = turno;
    this.maquina = maquina;
    this.subproyecto = subproyecto;
  }

  public int getIdReporteMaquina() {
    return idReporteMaquina;
  }

  public void setIdReporteMaquina(int idReporteMaquina) {
    this.idReporteMaquina = idReporteMaquina;
  }

  public int getNumeroRecibo() {
    return numeroRecibo;
  }

  public void setNumeroRecibo(int numeroRecibo) {
    this.numeroRecibo = numeroRecibo;
  }

  public double getHorometroInicial() {
    return horometroInicial;
  }

  public void setHorometroInicial(double horometroInicial) {
    this.horometroInicial = horometroInicial;
  }

  public double getHorometroFinal() {
    return horometroFinal;
  }

  public void setHorometroFinal(double horometroFinal) {
    this.horometroFinal = horometroFinal;
  }

  public String getHoraInicial() {
    return horaInicial;
  }

  public void setHoraInicial(String horaInicial) {
    this.horaInicial = UtilidadFecha.formatearFecha(horaInicial);
  }

  public String getHoraFinal() {
    return horaFinal;
  }

  public void setHoraFinal(String horaFinal) {
    this.horaFinal = UtilidadFecha.formatearFecha(horaFinal);
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

  public Actividad getActividad() {
    return actividad;
  }

  public void setActividad(Actividad actividad) {
    this.actividad = actividad;
  }

  public Turno getTurno() {
    return turno;
  }

  public void setTurno(Turno turno) {
    this.turno = turno;
  }

  public Maquina getMaquina() {
    return maquina;
  }

  public void setMaquina(Maquina maquina) {
    this.maquina = maquina;
  }

  public Subproyecto getSubproyecto() {
    return subproyecto;
  }

  public void setSubproyecto(Subproyecto subproyecto) {
    this.subproyecto = subproyecto;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((actividad == null) ? 0 : actividad.hashCode());
    result = prime * result + ((fechaRegistro == null) ? 0 : fechaRegistro.hashCode());
    result = prime * result + ((horaFinal == null) ? 0 : horaFinal.hashCode());
    result = prime * result + ((horaInicial == null) ? 0 : horaInicial.hashCode());
    long temp;
    temp = Double.doubleToLongBits(horometroFinal);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(horometroInicial);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + idReporteMaquina;
    result = prime * result + ((maquina == null) ? 0 : maquina.hashCode());
    result = prime * result + numeroRecibo;
    result = prime * result + ((observaciones == null) ? 0 : observaciones.hashCode());
    result = prime * result + ((subproyecto == null) ? 0 : subproyecto.hashCode());
    result = prime * result + ((turno == null) ? 0 : turno.hashCode());
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
    ReporteMaquina other = (ReporteMaquina) obj;
    if (actividad == null) {
      if (other.actividad != null)
        return false;
    } else if (!actividad.equals(other.actividad))
      return false;
    if (fechaRegistro == null) {
      if (other.fechaRegistro != null)
        return false;
    } else if (!fechaRegistro.equals(other.fechaRegistro))
      return false;
    if (horaFinal == null) {
      if (other.horaFinal != null)
        return false;
    } else if (!horaFinal.equals(other.horaFinal))
      return false;
    if (horaInicial == null) {
      if (other.horaInicial != null)
        return false;
    } else if (!horaInicial.equals(other.horaInicial))
      return false;
    if (Double.doubleToLongBits(horometroFinal) != Double.doubleToLongBits(other.horometroFinal))
      return false;
    if (Double.doubleToLongBits(horometroInicial) != Double
        .doubleToLongBits(other.horometroInicial))
      return false;
    if (idReporteMaquina != other.idReporteMaquina)
      return false;
    if (maquina == null) {
      if (other.maquina != null)
        return false;
    } else if (!maquina.equals(other.maquina))
      return false;
    if (numeroRecibo != other.numeroRecibo)
      return false;
    if (observaciones == null) {
      if (other.observaciones != null)
        return false;
    } else if (!observaciones.equals(other.observaciones))
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
    return true;
  }


}
