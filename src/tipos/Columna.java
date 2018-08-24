package src.tipos;

public class Columna
{

    //Nombre de la Columna
    private String nomColumna;
    //Arreglo con las columnas disponibles
    private String[] nombres = {"a","b","c","d","e","f","g","h"};

    /*
     * Constructor de la clase Columna
     */
    public Columna(String nomColumna)
    {
	     for(String nombre: nombres) {
	        if(nombre.equals(nomColumna)) {
		          this.nomColumna = nomColumna;
		          return;
	         }
	      }

	      System.out.println("Error: no se puede definir una columna " + nomColumna);
	      System.out.println("El nombre de la columna debe de ser entre a y h");
    }

    /*
     * Obtiene el nombre de la columna
     * @return - el nombre de la columna
     */
    public String getNomColumna()
    {
	     return this.nomColumna;
    }

    /*
     * Define un nuevo nombre a la columna
     */
    public void setNomColumna(String nomColumna)
    {
	     for(String nombre: nombres) {
	        if(nombre.equals(nomColumna)) {
		          this.nomColumna = nomColumna;
		          return;
	        }
	     }

	     System.out.println("Error: no se puede definir una columna " + nomColumna);
	     System.out.println("El nombre de la columna debe de ser entre a y h");
    }

}
