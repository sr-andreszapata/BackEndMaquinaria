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
@Table(name = "InsumoReporteMaquina")
public class InsumoReporteMaquina implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idInsumoReporteMaquina;
  private double cantidad;
  @ManyToOne
  @JoinColumn(name = "idReporteMaquina")
  private ReporteMaquina reporteMaquina;
  @ManyToOne
  @JoinColumn(name = "idInsumo")
  private Insumo insumo;

  public InsumoReporteMaquina() {
    super();
  }

  public InsumoReporteMaquina(int idInsumoReporteMaquina, double cantidad,
      ReporteMaquina reporteMaquina, Insumo insumo) {
    super();
    this.idInsumoReporteMaquina = idInsumoReporteMaquina;
    this.cantidad = cantidad;
    this.reporteMaquina = reporteMaquina;
    this.insumo = insumo;
  }

  public int getIdInsumoReporteMaquina() {
    return idInsumoReporteMaquina;
  }

  public void setIdInsumoReporteMaquina(int idInsumoReporteMaquina) {
    this.idInsumoReporteMaquina = idInsumoReporteMaquina;
  }

  public double getCantidad() {
    return cantidad;
  }

  public void setCantidad(double cantidad) {
    this.cantidad = cantidad;
  }

  public ReporteMaquina getReporteMaquina() {
    return reporteMaquina;
  }

  public void setReporteMaquina(ReporteMaquina reporteMaquina) {
    this.reporteMaquina = reporteMaquina;
  }

  public Insumo getInsumo() {
    return insumo;
  }

  public void setInsumo(Insumo insumo) {
    this.insumo = insumo;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(cantidad);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + idInsumoReporteMaquina;
    result = prime * result + ((insumo == null) ? 0 : insumo.hashCode());
    result = prime * result + ((reporteMaquina == null) ? 0 : reporteMaquina.hashCode());
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
    InsumoReporteMaquina other = (InsumoReporteMaquina) obj;
    if (Double.doubleToLongBits(cantidad) != Double.doubleToLongBits(other.cantidad))
      return false;
    if (idInsumoReporteMaquina != other.idInsumoReporteMaquina)
      return false;
    if (insumo == null) {
      if (other.insumo != null)
        return false;
    } else if (!insumo.equals(other.insumo))
      return false;
    if (reporteMaquina == null) {
      if (other.reporteMaquina != null)
        return false;
    } else if (!reporteMaquina.equals(other.reporteMaquina))
      return false;
    return true;
  }

}
