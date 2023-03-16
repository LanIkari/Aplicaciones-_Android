package HerenciaPolimorfismo;//Empleado.java
// La superclase abstracta Empleado.

public abstract class Alumno
{
   private String primerNombre;
   private String apellidoPaterno;
   private String numeroCuenta;

   // constructor con tres argumentos
   public Alumno(String nombre, String apellido, String nss )
   {
      primerNombre = nombre;
      apellidoPaterno = apellido;
      numeroCuenta = nss;
   } // fin del constructor de Alumno con tres argumentos

   // establece el primer nombre
   public void establecerPrimerNombre( String nombre )
   {
      primerNombre = nombre;  // deber�a validar
   } // fin del m�todo establecerPrimerNombre

   // devuelve el primer nombre
   public String obtenerPrimerNombre()
   {
      return primerNombre;
   } // fin del m�todo obtenerPrimerNombre

   // establece el apellido paterno
   public void establecerApellidoPaterno( String apellido )
   {
      apellidoPaterno = apellido;  // deber�a validar
   } // fin del m�todo establecerApellidoPaterno

   // devuelve el apellido paterno
   public String obtenerApellidoPaterno()
   {
      return apellidoPaterno;
   } // fin del m�todo obtenerApellidoPaterno

   // establece el n�mero de cuenta
   public void establecerNumeroCuenta(String nss )
   {
      numeroCuenta = nss; // deber�a validar
   } // fin del m�todo establecerNumeroSeguroSocial

   // devuelve el n�mero de cuenta
   public String obtenerNumeroCuenta()
   {
      return numeroCuenta;
   } // fin del m�todo obtenerNumeroSeguroSocial

   // devuelve representaci�n String de un objeto Alumno
   @Override
   public String toString()
   {
      return String.format( "%s %s\nnumero de seguro social: %s", 
         obtenerPrimerNombre(), obtenerApellidoPaterno(), obtenerNumeroCuenta() );
   } // fin del m�todo toString

   // m�todo abstracto sobrescrito por las subclases concretas
   public abstract double creditos(); // aqu� no hay implementaci�n
} // fin de la clase abstracta Alumno

