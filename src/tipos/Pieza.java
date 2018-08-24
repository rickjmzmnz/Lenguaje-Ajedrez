package src.tipos;

public class Pieza{

    //Color de la pieza
    private Color color;
    //Nombre de la pieza
    private String nombre;
    //Nombres de las piezas del juego
    private String[] nombrePieza = {"Pawn","Knight","Rook","Bishop","Queen","King"};

    /*
     * Constructor vacío
     * Representa una casilla libre
     */
    public Pieza(){
    }

    /*
     * Constructor de la clase Pieza
     */
    public Pieza(Color color,String nombre){
	     for(String nombrePieza: nombrePieza){
	        if(nombre.equals(nombrePieza)){
		          this.color = color;
		          this.nombre = nombre;
		      return;
	        }
	     }
	     System.out.println("Error: No se puede definir la pieza = " + nombre);
	     System.out.println("Las piezas disponibles son: ");
	     for(String nombrePieza: nombrePieza){
	           System.out.println(nombrePieza);
	     }
     }

    /*
     * Obtiene el color de la pieza
     * @return - el color de la pieza
     */
    public Color getColorPieza(){
	     return this.color;
    }

    /*
     * Asigna un color a la pieza
     */
    public void setColorPieza(Color color){
	     this.color = color;
    }

    /*
     * Obtiene el nombre de la pieza
     * @return - el nombre de la pieza
     */
    public String getNombrePieza(){
	     return this.nombre;
    }

    /*
     * Asigna un nombre a la pieza
     */
    public void setNombrePieza(String nombre){
	     for(String nombrePieza: nombrePieza){
	        if(nombre.equals(nombrePieza)){
		          this.nombre = nombre;
		          return;
	        }
	     }
	     System.out.println("Error: No se puede definir la pieza = " + nombre);
	     System.out.println("Las piezas disponibles son: ");
	     for(String nombrePieza: nombrePieza){
	        System.out.println(nombrePieza);
	     }
    }

    /*
     * Obtiene una representación en cadena de la pieza
     * @return -  la pieza en cadena
     */
    @Override
    public String toString(){
	     if(this.getColorPieza() == null){
	        return "-";
	     }else{
	        Color colPieza = this.getColorPieza();
	        String nomPieza = this.getNombrePieza();
	        String color = colPieza.getColor();
	        String pieza = selecPieza(color,nomPieza);
	        return pieza;
	     }
     }

     /*
      * Dado el nombre de una pieza y su color
      * Regresa su representación en cadena según las convenciones del ajedrez
      * @return - la abreviación de la pieza según su color
      */
     public static String selecPieza(String color,String pieza){
       String nombre = "";
       if(color.equals("Black")){
         switch (pieza) {
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
       } else {
         switch (pieza) {
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
