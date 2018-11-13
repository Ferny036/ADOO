package models;

public class Administrador extends Usuario{

  public Administrador(String nombre, String password, String email){
    super(nombre, password, email);
  }

  public String getNombre()
  {
    return nombre;
  }

  public String getPassword()
  {
    return password;
  }

  public String getEmail()
  {
    return email;
  }

  public void iniciarSesion()
  {

  }

  public void notificarEventos()
  {

  }

  public void modificarPassword()
  {

  }

  public void recuperarPassword()
  {

  }

}
