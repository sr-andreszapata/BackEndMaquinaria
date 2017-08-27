package co.com.a4b.maquinaria.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

// TODO: Se debe cambiar cuaando se logre realizaar un adecuado manejo de la fecha desde el front
public class UtilidadFecha {

  public static String formatearFecha(String fecha) {

    String dateString = "";

    try {
      SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
      Date fechaEntrada;
      fechaEntrada = formato.parse(fecha);
      formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      formato.setTimeZone(TimeZone.getTimeZone("GMT-1000"));
      dateString = formato.format(fechaEntrada);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return dateString;
  }

  public static Date formatearFechaDate(Date fecha) {
    SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    Date fechaFormateada = null;
    try {
      fechaFormateada = formateador.parse(fecha.toString());
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return fechaFormateada;
  }
}
