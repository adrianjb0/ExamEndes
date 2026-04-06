package Apuesta;

/**
 * Clase que representa una apuesta en un partido de fútbol.
 * Permite realizar apuestas, comprobar resultados y cobrar apuestas ganadas.
 */
public class Apuesta {

    private int dinero_disp;
    private int goles_local;
    private int goles_visitante;
    private int apostado;

    /**
     * Constructor por defecto de la clase Apuesta.
     * Inicializa los atributos con valores predeterminados.
     */
    public Apuesta() {
    }

    /**
     * Constructor por parámetros para crear una apuesta con un saldo y un resultado de goles esperados.
     *
     * @param dinero_disp el saldo disponible para apostar.
     * @param goles_local los goles esperados para el equipo local.
     * @param goles_visitante los goles esperados para el equipo visitante.
     */
    public Apuesta(int dinero_disp, int goles_local, int goles_visitante) {
        this.dinero_disp = dinero_disp;
        this.goles_local = goles_local;
        this.goles_visitante = goles_visitante;
        this.apostado = 0;
    }

    /**
     * Método para obtener el valor del atributo dinero_disp (dinero disponible para apostar).
     *
     * @return El saldo que puedes apostar.
     */
    public int getDinero_disp() {
        return dinero_disp;
    }

    /**
     * Método para modificar el valor del atributo dinero_disp.
     *
     * @param dinero_disp el nuevo valor del saldo que dispone.
     */
    public void setDinero_disp(int dinero_disp) {
        this.dinero_disp = dinero_disp;
    }

    /**
     * Método para realizar una apuesta.
     * Permite apostar una cantidad determinada, pero no puede ser menor que 1 ni superior al saldo disponible.
     *
     * @param dinero la cantidad que se va a apostar.
     * @throws Exception si se indica una apuesta mas grande de lo disponible o menos del minimo.
     */
    public void apostar(int dinero) throws Exception {
        if (dinero <= 0) {
            throw new Exception("No se puede apostar menos de 1€");
        }

        if (dinero > dinero_disp) {
            throw new Exception("No se puede apostar más de lo que tienes");
        }

        // Se resta el dinero apostado del saldo disponible
        dinero_disp = dinero_disp - dinero;
        apostado = dinero;  // Guardamos la cantidad apostada
    }

    /**
     * Método que comprueba si el resultado del partido es correcto.
     * Verifica si los goles del equipo local y visitante coinciden con los goles apostados.
     *
     * @param local Los goles obtenidos por el equipo local.
     * @param visitante Los goles obtenidos por el equipo visitante.
     * @return true si el resultado es correcto, false si no lo es.
     * @throws Exception si el resultado de goles de un equipo es negativo se lanza.
     */
    public boolean comprobar_resultado(int local, int visitante) throws Exception {
        boolean acertado = false;
        
        if (local < 0 || visitante < 0) {
            throw new Exception("Un equipo no puede meter menos de 0 goles, por malo que sea");
        }

        if (goles_local == local && goles_visitante == visitante) {
            acertado = true;
        }
        return acertado;
    }

    /**
     * Método para cobrar la apuesta si el resultado es correcto.
     * Si el resultado ha sido acertado, multiplica el saldo disponible por 10.
     *
     * @param cantidad_goles_local goles obtenidos por el equipo local.
     * @param cantidad_goles_visit goles obtenidos por el equipo visitante.
     * @throws Exception Si el resultado no ha sido acertado o la apuesta no es válida, se lanza.
     */
    void cobrar_apuesta(int cantidad_goles_local, int cantidad_goles_visit) throws Exception {
        // Si el resultado es incorrecto, no se puede cobrar la apuesta
        if (!comprobar_resultado(cantidad_goles_local, cantidad_goles_visit)) {
            throw new Exception("No se puede cobrar una apuesta no acertada");
        }

        // Si el resultado es acertado, se multiplica el dinero disponible por 10
        dinero_disp = dinero_disp * 10;
    }
}
