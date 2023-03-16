package HerenciaPolimorfismo;// PruebaSistemaNomina.java
// Programa de prueba para la jerarqu�a de Empleado.

public class PruebaAlumno
{
   public static void main( String[] args ) 
   {
      // crea objetos de las subclases
      AlumnoEgresado alumnoEgresado =
         new AlumnoEgresado( "John", "Smith", "111-11-1111", true );

      AlumnoActivo alumnoActivo =
         new AlumnoActivo(
         "Sue", "Jones", "333-33-3333", 10000, 6 );


      System.out.println( "Empleados procesados por separado:\n" );
      
      System.out.printf( "%s\n%s: $%,.2f\n\n", 
         alumnoEgresado, "creditos", alumnoEgresado.creditos() );

      System.out.printf( "%s\n%s: $%,.2f\n\n",
         alumnoActivo, "ingresos", alumnoActivo.creditos() );

      // crea un arreglo Empleado de cuatro elementos
      Alumno[] alumnos = new Alumno[ 4 ];

      // inicializa el arreglo con objetos Empleado
      alumnos[ 0 ] = alumnoEgresado;
      alumnos[ 1 ] = alumnoActivo;

     System.out.println( "Alumnos procesados en forma polimorfica:\n" );
      

      for ( Alumno alumnoActual : alumnos)
      {
         System.out.println(alumnoActual);


         if ( alumnoActual instanceof AlumnoEgresado)
         {

            AlumnoActivo alumno =
               (AlumnoActivo) alumnoActual;

            System.out.printf( 
               "Los creditos del alumno activo son: $%,.2f\n",
               alumno.obtenerNumeroCuenta());
         }

         System.out.printf( 
            "alumno $%,.2f\n\n", alumnoActual.creditos() );
      }


      for (int j = 0; j < alumnos.length; j++ )
         System.out.printf( "El alumno %d es un %s\n", j,
            alumnos[ j ].getClass().getName());
   }
}
