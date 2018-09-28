package src.tipos;

public class Pieza
{

    //Color de la pieza
    private Color color;
    //Nombre de la pieza
    private String nombre;
    //Identifica si es una pieza o una casilla libre
    private boolean libre;
    //Nombres de las piezas del juego
    private String[] nombrePieza = {"Pawn","Knight","Rook","Bishop","Queen","King"};

    /**
     * Constructor vacío
     * Representa una casilla libre
     */
    public Pieza()
    {
        this.libre = true;
    }

    /**
     * Constructor de la clase Pieza
     * @param color el color de la pieza
     * @param nombre el nombre de la pieza
     */
    public Pieza(Color color,String nombre)
    {
	     for(String nombrePieza: nombrePieza)
       {
	        if(nombre.equals(nombrePieza))
          {
		          this.color = color;
		          this.nombre = nombre;
              this.libre = false;
		          return;
	        }
	     }
	     System.out.println("Error: No se puede definir la pieza = " + nombre);
	     System.out.println("Las piezas disponibles son: ");

       for(String nombrePieza: nombrePieza)
       {
	           System.out.println(nombrePieza);
	     }
     }

    /**
     * Obtiene el color de la pieza
     * @return el color de la pieza
     */
    public Color getColor()
    {
	     return this.color;
    }

    /**
     * Asigna un color a la pieza
     * @param color el nuevo color
     */
    public void setColor(Color color)
    {
	     this.color = color;
    }

    /**
     * Obtiene el nombre de la pieza
     * @return el nombre de la pieza
     */
    public String getNombre()
    {
	     return this.nombre;
    }

    /**
     * Asigna un nombre a la pieza
     * @param nombre el nuevo nombre
     */
    public void setNombre(String nombre)
    {
	     for(String nombrePieza: nombrePieza)
       {
	        if(nombre.equals(nombrePieza))
          {
		          this.nombre = nombre;
		          return;
	        }
	     }
	     System.out.println("Error: No se puede definir la pieza = " + nombre);
	     System.out.println("Las piezas disponibles son: ");

       for(String nombrePieza: nombrePieza)
       {
	        System.out.println(nombrePieza);
	     }
    }

    /**
     * Obtiene si una pieza es libre o no
     * @return true si es libre, false en otro caso
     */
    public boolean getLibre()
    {
        return this.libre;
    }

    /**
     * Asigna si una pieza es libre o no
     * @param libre true si es libre, false en otro caso
     */
    public void setLibre(boolean libre)
    {
        this.libre = libre;
    }

    /**
     * Obtiene una representación en cadena de la pieza
     * @return la pieza en cadena
     */
    @Override
    public String toString()
    {
	     if(this.getColor() == null)
       {
	        return "-";
	     }
       else
       {
	        Color colPieza = this.getColor();
	        String nomPieza = this.getNombre();
	        String color = colPieza.getColor();
	        String pieza = selecPieza(color,nomPieza);
	        return pieza;
	     }
     }

     /**
      * Dado el nombre de una pieza y su color
      * Regresa su representación en cadena según las convenciones del ajedrez
      * @return la abreviación de la pieza según su color
      */
     public static String selecPieza(String color,String pieza)
     {
         String nombre = "";

         if(color.equals("Black"))
         {
           switch (pieza)
           {

              case "Pawn":
                nombre = "P";
                break;

              case "Rook":
                nombre = "R";
                break;

              case "Bishop":
                nombre = "B";
                break;

              case "Queen":
                nombre = "Q";
                break;

              case "Knight":
                nombre = "N";
                break;

              case "King":
                nombre = "K";
                break;
           }
         }
         else
         {
           switch (pieza)
           {

              case "Pawn":
                nombre = "p";
                break;

              case "Rook":
                nombre = "r";
                break;

              case "Bishop":
                nombre = "b";
                break;

              case "Queen":
                nombre = "q";
                break;

              case "Knight":
                nombre = "n";
                break;

              case "King":
                nombre = "k";
                break;

           }
         }
         return nombre;
     }

}
