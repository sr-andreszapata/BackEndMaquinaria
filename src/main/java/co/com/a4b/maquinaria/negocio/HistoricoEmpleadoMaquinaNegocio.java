package co.com.a4b.maquinaria.negocio;

import java.util.List;

import co.com.a4b.maquinaria.bo.HistoricoEmpleadoMaquina;
import co.com.a4b.maquinaria.dao.HistoricoEmpledoMaquinaDAO;
import co.com.a4b.maquinaria.dao.jpa.HistoricoEmpleadoMaquinaDAOJPAImpl;

public class HistoricoEmpleadoMaquinaNegocio {

  HistoricoEmpledoMaquinaDAO historicoEmpledoMaquinaDAO = new HistoricoEmpleadoMaquinaDAOJPAImpl();


  public void crearAsignacionMaquinaEmpleado(HistoricoEmpleadoMaquina historicoEmpleadoMaquina) {
    historicoEmpledoMaquinaDAO.insertar(historicoEmpleadoMaquina);
  }

  public List<HistoricoEmpleadoMaquina> consultarHistoricosEmpleadosMaquinas() {
    return historicoEmpledoMaquinaDAO.buscarTodos();
  }

  public void actualizarHistoricoEmpledoMaquina(HistoricoEmpleadoMaquina historicoEmpleadoMaquina) {
    historicoEmpledoMaquinaDAO.actualizar(historicoEmpleadoMaquina);
  }

  public void eliminarRegistroHistoricoMaquinaEmpleado(
      HistoricoEmpleadoMaquina historicoEmpleadoMaquina) {
    historicoEmpledoMaquinaDAO.borrar(historicoEmpleadoMaquina);
  }

  public HistoricoEmpleadoMaquina buscarHistoricoEmpleadoMaquinaPorId(
      int idHistoricoEmpleadoMaquina) {
    return historicoEmpledoMaquinaDAO.buscarPorClaveInt(idHistoricoEmpleadoMaquina);
  }

  public boolean validarSiExisteHistoricoEmpleadoMaquina(
      HistoricoEmpleadoMaquina historicoEmpleadoMaquina) {
    if (this.buscarHistoricoEmpleadoMaquinaPorId(
        historicoEmpleadoMaquina.getIdHistoricoEmpleadoMaquina()) != null) {
      return true;
    } else {
      return false;
    }
  }

}
