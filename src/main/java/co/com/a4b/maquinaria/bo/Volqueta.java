package co.com.a4b.maquinaria.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Volqueta")
public class Volqueta implements Serializable {


  private static final long serialVersionUID = 1L;

  @Id
  private String placa;
  private double cubo;
  private double metraje;

  public Volqueta(String placa, double cubo, double metraje) {
    super();
    this.placa = placa;
    this.cubo = cubo;
    this.metraje = metraje;
  }

  public Volqueta() {
    super();
  }


  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

  public double getCubo() {
    return cubo;
  }

  public void setCubo(double cubo) {
    this.cubo = cubo;
  }

  public double getMetraje() {
    return metraje;
  }

  public void setMetraje(double metraje) {
    this.metraje = metraje;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(cubo);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(metraje);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + ((placa == null) ? 0 : placa.hashCode());
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
    Volqueta other = (Volqueta) obj;
    if (Double.doubleToLongBits(cubo) != Double.doubleToLongBits(other.cubo))
      return false;
    if (Double.doubleToLongBits(metraje) != Double.doubleToLongBits(other.metraje))
      return false;
    if (placa == null) {
      if (other.placa != null)
        return false;
    } else if (!placa.equals(other.placa))
      return false;
    return true;
  }
}
