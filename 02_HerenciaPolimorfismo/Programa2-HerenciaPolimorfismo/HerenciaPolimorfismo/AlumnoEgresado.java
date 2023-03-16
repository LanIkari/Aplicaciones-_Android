package HerenciaPolimorfismo;//  EmpleadoAsalariado.java
// La clase concreta EmpleadoAsalariado extiende a la clase abstracta Empleado.

public class AlumnoEgresado extends Alumno
{
   private boolean ss;
   private boolean Idioma;

   // constructor de cuatro argumentos
   public AlumnoEgresado(String nombre, String apellido, String nss,
                         boolean ss, boolean idioma )
   {
      super( nombre, apellido, nss );
      establecerServicioSocial( ss );
   }

   // establece el salario
   public void establecerServicioSocial(boolean ss )
   {

   }
   public void establecerIdioma(boolean idioma )
   {

   }
   @Override
   public String toString()
   {
      return String.format( "AlumnoEgresado:",
         super.toString(), "Idioma", establecerIdioma(),
         super.toString(), "ss", establecerServicioSocial());

   }
}
