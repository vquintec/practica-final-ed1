
package practicafinal;

/**
 * Esta es la clase principal que contiene los métodos para el funcionamiento del robot
 * @author Valentín Quintero
 * @version 1.0
 */
public class PracticaFinal {

    //1 muro u obstáculo, 2 destino, 3 robot, 4 ya pasé, 0 no hay nada
    private static int [][] matriz = {{1,1,1,1,1,1,1,1,1,1,1},
                                      {1,0,1,0,0,0,1,0,0,0,1},
                                      {1,0,1,0,1,0,1,0,1,0,1},
                                      {1,0,1,0,1,0,1,0,1,0,1},
                                      {1,0,1,0,1,0,1,0,1,0,1},
                                      {1,0,0,0,1,0,1,0,1,0,1},
                                      {1,0,1,0,1,0,1,0,1,0,1},
                                      {1,0,1,0,1,0,1,0,1,0,1},
                                      {1,0,1,0,1,0,0,0,0,0,1},
                                      {1,1,1,1,1,1,1,1,2,1,1}};
    
    private static int [][] matriz2 = {{1,1,1,1,1,1,1,1,1,1,1},
                                      {1,0,0,2,0,0,0,0,0,0,1},
                                      {1,0,0,0,0,0,0,0,0,0,1},
                                      {1,0,0,0,0,0,0,0,0,0,1},
                                      {1,0,0,0,0,0,0,0,0,0,1},
                                      {1,0,0,0,0,0,0,0,0,0,1},
                                      {1,0,0,0,0,0,0,0,0,0,1},
                                      {1,0,0,0,0,0,0,0,0,0,1},
                                      {1,0,0,0,0,0,0,0,0,0,1},
                                      {1,1,1,1,1,1,1,1,1,1,1}};
    
    /**
     * Este método imprime una matriz por consola y no devuelve nada
     * @param matriz Es la matriz que va a ser imprimida
     */
    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("");
    }
    
    /**
     * Este método recorre una matriz que representa un laberinto y encontrando la salida en caso de haberla
     * @param x Es la posición en X donde será posicionado el robot
     * @param y Es la posición en Y donde será posicionado el robot
     * @param matriz Es la matriz que representa el laberinto
     * @return Retorna verdadero si el robot encontró una salida, en caso contrario retorna falso
     */
   public static boolean resolverLaberinto(int x, int y, int[][] matriz){
     imprimirMatriz(matriz);
     if (x == -1 || y == -1 || x == matriz.length || y == matriz.length || matriz[x][y] == 4 || matriz[x][y] == 1) //si sensor de presión y/o ultrasonido
     {
        System.out.println("Retroceder una posición");
        return false;
     }
     if (matriz[x][y] == 2){ // Si el sensor de color es rojo
         System.out.println("Si la salida del laberinto fue encontrada se mostrará 'true', en caso contrario se mostrará 'false' \n");
         return true;
         
     }
     
     matriz[x][y] = 4;
     //System.out.println("rotar der");
     System.out.println("Avanzar una posición");
     boolean r = resolverLaberinto(x+1,y,matriz) || resolverLaberinto(x,y+1,matriz) || resolverLaberinto(x-1,y,matriz) || resolverLaberinto(x,y-1,matriz);
     //System.out.println("rotar izq");
     if (r) matriz[x][y] = 5;
     return r;
}
    
    
    /**
     * Este es el método main que contiene las invocaciones de los métodos
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println(resolverLaberinto(1,1,matriz));
        
        System.out.println();
        System.out.println("Los números 1 representan una pared u obstaculo");
        System.out.println("Los números 0 representan camino libre");
        System.out.println("Los números 4 representan el camino que ya fue recorrido");
        System.out.println("Los números 5 representan el camino que se tuvo que recorrer para resolver el laberinto");
        System.out.println("El número 2 representa la salida del laberinto \n");
        imprimirMatriz(matriz);
    }
    
}
