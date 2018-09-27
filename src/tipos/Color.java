package src.tipos;

public class Color
{

    //Color de la pieza
    private String color;
    //Arreglo con el color que pueden tener las piezas
    private String[] colores = {"White","Black"};

    /**
     * Constructor de la clase Color
     * @param color el color (White o Black)
     */
    public Color(String color)
    {
	     for(String colores: colores) {
	        if(color.equals(colores)) {
		          this.color = color;
		          return;
	        }
	     }

	     System.out.println("Error: No se puede definir el color = " + color);
	     System.out.println("Sólo se puede definir el color White o Black");
    }

    /**
     * Obtiene el color de la pieza
     * @return el color de la pieza
     */
    public String getColor()
    {
	     return this.color;
    }

    /**
     * Se le asigna un color a la pieza
     * @param color el nuevo color
     */
    public void setColor(String color)
    {
	     for(String colores: colores) {
	        if(color.equals(colores)) {
		          this.color = color;
		           return;
	        }
	     }

	     System.out.println("Error: No se puede definir el color = " + color);
	     System.out.println("Sólo se puede definir el color Blanco o Negro");
    }

    /**
     * Representacion en cadena del color
     * @return el color actual
     */
    @Override
    public String toString()
    {
        return "El color de la pieza es: " + this.getColor();
    }

    /**
     * Verifica que un color sea igual a otro
     * @param col el color a comparar
     * @return true si son iguales, false en otro caso
     */
    public boolean equals(Color col)
    {
        return this.color.equals(col.color);
    }

}
