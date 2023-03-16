package HerenciaPolimorfismo;//EmpleadoPorComision.java
// La clase EmpleadoPorComision extiende a Empleado.

public class AlumnoActivo extends Alumno
{
   private int materiasAprobadas;
   private int materiasRestantes;

   // constructor con cinco argumentos
   public AlumnoActivo(String nombre, String apellido, String nss,
                       int materiasAprobadas, int materiasRestantes)
   {
      super( nombre, apellido, nss );
      establecerMateriasRestantes( materiasAprobadas );
      establecerMateriasAprobadas( materiasRestantes );
   }


   public void establecerMateriasAprobadas(int materiasAprobadas )
   {

   }

   public void establecerMateriasRestantes(int materiasRestantes )
   {

   }
   // calcula los ingresos; sobrescribe el m�todo abstracto ingresos en Empleado
   @Override
   public double creditos()
   {
      return (materiasAprobadas*40)/100;
   }

   @Override
   public String toString()
   {
      return String.format( "%s: %s\n%s: $%,.2f; %s: %.2f", 
         "Empleado Activo", super.toString(),
         "Materias Aprobadas", materiasAprobadas,
         "Materias Restantes", materiasRestantes);
   }
}

