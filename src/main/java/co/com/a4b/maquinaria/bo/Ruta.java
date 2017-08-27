package co.com.a4b.maquinaria.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ruta")
public class Ruta implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idRuta;
  private String descripcion;
  private double distancia;

  public Ruta() {
    super();
  }

  public Ruta(int idRuta, String nombre, double distancia) {
    super();
    this.idRuta = idRuta;
    this.descripcion = nombre;
    this.distancia = distancia;
  }

  public int getIdRuta() {
    return idRuta;
  }

  public void setIdRuta(int idRuta) {
    this.idRuta = idRuta;
  }

  public String getNombre() {
    return descripcion;
  }

  public void setNombre(String nombre) {
    this.descripcion = nombre;
  }

  public double getDistancia() {
    return distancia;
  }

  public void setDistancia(double distancia) {
    this.distancia = distancia;
  }

}
