package models;

public class EspacioExterior extends Lugar
{
  private String ubicacion;
  //private String descripcion;

  public EspacioExterior(String ubicacion)
  {
    super();
    this.ubicacion = ubicacion;
  }

  public String getLugar()
  {
      return ubicacion;
  }
}
