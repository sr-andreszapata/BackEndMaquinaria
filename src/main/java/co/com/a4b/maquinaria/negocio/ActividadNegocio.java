package co.com.a4b.maquinaria.negocio;

import java.util.List;

import co.com.a4b.maquinaria.bo.Actividad;
import co.com.a4b.maquinaria.bo.ReporteMaquina;
import co.com.a4b.maquinaria.dao.ActividadDAO;
import co.com.a4b.maquinaria.dao.jpa.ActividadDAOJPAImpl;

public class ActividadNegocio {

  ActividadDAO actividadDAO = new ActividadDAOJPAImpl();

  public void crearActividad(Actividad actividad) {
    actividadDAO.insertar(actividad);
  }

  public List<Actividad> consultarActividades() {
    return actividadDAO.buscarTodos();
  }

  public void actualizarActividad(Actividad actividad) {
    actividadDAO.actualizar(actividad);
  }

  public void eliminarActividad(Actividad actividad) {
    actividadDAO.borrar(actividad);
  }

  public Actividad buscarActividadPorId(int idActividad) {
    return actividadDAO.buscarPorClaveInt(idActividad);
  }

  public boolean validarSiExisteLaActividad(Actividad actividad) {

    if (this.buscarActividadPorId(actividad.getIdActividad()) != null) {
      return true;
    } else {
      return false;
    }
  }

  public boolean validarSiSePuedeEliminarLaActividad(Actividad actividad) {
    ReporteMaquinaNegocio reporteMaquinaNegocio = new ReporteMaquinaNegocio();
    List<ReporteMaquina> reportesMaquinas = reporteMaquinaNegocio.consultarReportesMaquinas();

    for (ReporteMaquina reporteMaquina : reportesMaquinas) {
      if (reporteMaquina.getActividad().getIdActividad() == actividad.getIdActividad()) {
        return false;
      }
    }
    return true;
  }

  public boolean validarSiExisteUnaActividadConDescripcionIgual(Actividad actividad) {
    List<Actividad> actividades = this.consultarActividades();

    for (Actividad act : actividades) {
      if (act.getDescripcion().equals(actividad.getDescripcion())) {
        return true;
      }
    }
    return false;
  }
}
