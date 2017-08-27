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
@Table(name = "TarifaSubproyectoTurnoMaquina")
public class TarifaSubproyectoTurnoMaquina implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idTarifaSubproyectoTurnoMaquina;
  private double tarifaHora;
  @ManyToOne
  @JoinColumn(name = "idTurno")
  private Turno turno;
  @ManyToOne
  @JoinColumn(name = "idSubproyecto")
  private Subproyecto subproyecto;
  @ManyToOne
  @JoinColumn(name = "idMaquina")
  private Maquina maquina;

  public TarifaSubproyectoTurnoMaquina() {
    super();
  }

  public TarifaSubproyectoTurnoMaquina(int idTarifaSubproyectoTurnoMaquina, double tarifaHora,
      Turno turno, Subproyecto subproyecto, Maquina maquina) {
    super();
    this.idTarifaSubproyectoTurnoMaquina = idTarifaSubproyectoTurnoMaquina;
    this.tarifaHora = tarifaHora;
    this.turno = turno;
    this.subproyecto = subproyecto;
    this.maquina = maquina;
  }

  public int getIdTarifaSubproyectoTurnoMaquina() {
    return idTarifaSubproyectoTurnoMaquina;
  }

  public void setIdTarifaSubproyectoTurnoMaquina(int idTarifaSubproyectoTurnoMaquina) {
    this.idTarifaSubproyectoTurnoMaquina = idTarifaSubproyectoTurnoMaquina;
  }

  public double getTarifaHora() {
    return tarifaHora;
  }

  public void setTarifaHora(double tarifaHora) {
    this.tarifaHora = tarifaHora;
  }

  public Turno getTurno() {
    return turno;
  }

  public void setTurno(Turno turno) {
    this.turno = turno;
  }

  public Subproyecto getSubproyecto() {
    return subproyecto;
  }

  public void setSubproyecto(Subproyecto subproyecto) {
    this.subproyecto = subproyecto;
  }

  public Maquina getMaquina() {
    return maquina;
  }

  public void setMaquina(Maquina maquina) {
    this.maquina = maquina;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + idTarifaSubproyectoTurnoMaquina;
    result = prime * result + ((maquina == null) ? 0 : maquina.hashCode());
    result = prime * result + ((subproyecto == null) ? 0 : subproyecto.hashCode());
    long temp;
    temp = Double.doubleToLongBits(tarifaHora);
    result = prime * result + (int) (temp ^ (temp >>> 32));
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
    TarifaSubproyectoTurnoMaquina other = (TarifaSubproyectoTurnoMaquina) obj;
    if (idTarifaSubproyectoTurnoMaquina != other.idTarifaSubproyectoTurnoMaquina)
      return false;
    if (maquina == null) {
      if (other.maquina != null)
        return false;
    } else if (!maquina.equals(other.maquina))
      return false;
    if (subproyecto == null) {
      if (other.subproyecto != null)
        return false;
    } else if (!subproyecto.equals(other.subproyecto))
      return false;
    if (Double.doubleToLongBits(tarifaHora) != Double.doubleToLongBits(other.tarifaHora))
      return false;
    if (turno == null) {
      if (other.turno != null)
        return false;
    } else if (!turno.equals(other.turno))
      return false;
    return true;
  }

}
