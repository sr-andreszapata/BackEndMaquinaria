package co.com.a4b.maquinaria.negocio;

import java.util.List;

import co.com.a4b.maquinaria.bo.Proyecto;
import co.com.a4b.maquinaria.bo.Subproyecto;
import co.com.a4b.maquinaria.dao.ProyectoDAO;
import co.com.a4b.maquinaria.dao.jpa.ProyectoDAOJPAImpl;

public class ProyectoNegocio {

  ProyectoDAO proyectoDAO = new ProyectoDAOJPAImpl();

  public void crearProyecto(Proyecto proyecto) {
    proyectoDAO.insertar(proyecto);
  }

  public void eliminarproyecto(Proyecto proyecto) {
    proyectoDAO.borrar(proyecto);
  }

  public void actualizarProyecto(Proyecto proyecto) {
    proyectoDAO.actualizar(proyecto);
  }

  public List<Proyecto> consultarProyectos() {
    return proyectoDAO.buscarTodos();
  }

  public Proyecto consultarProyecto(int idProyecto) {
    return proyectoDAO.buscarPorClaveInt(idProyecto);
  }

  public boolean validarSiExisteElProyecto(Proyecto proyecto) {
    if (this.consultarProyecto(proyecto.getIdProyecto()) != null) {
      return true;
    } else {
      return false;
    }
  }

  public boolean validarSiSePuedeEliminarElProyecto(Proyecto proyecto) {
    SubproyectoNegocio subproyectoNegocio = new SubproyectoNegocio();
    List<Subproyecto> subproyectos = subproyectoNegocio.consultarSubproyectos();


    for (Subproyecto subproyecto : subproyectos) {
      if (subproyecto.getProyecto().getIdProyecto() == proyecto.getIdProyecto()) {
        return false;
      }
    }
    return true;
  }
}
