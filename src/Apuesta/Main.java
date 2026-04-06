package Apuesta;

public class Main {

    public static void main(String[] args) {
        Apuesta laApuesta;
        int mi_dinero;

        laApuesta = new Apuesta(1000, 4, 2);

      
        mi_dinero = operativa_Apuesta(laApuesta, 25);  

        System.out.println("El dinero que tengo tras las apuestas es " + mi_dinero);
    }

 public static int operativa_Apuesta(Apuesta laApuesta, int dinero) {

        try {
            System.out.println("Apostando...");
            laApuesta.apostar(dinero);
        } catch (Exception e) {
            System.out.println("Fallo al realizar la Apuesta");
        }

        try {
            System.out.println("Intento cobrar apuesta segun el resultado del partido");
            laApuesta.cobrar_apuesta(2, 3);
        } catch (Exception e) {
            System.out.println("Fallo al cobrar la apuesta");
        }

        return laApuesta.getDinero_disp();
    }
}