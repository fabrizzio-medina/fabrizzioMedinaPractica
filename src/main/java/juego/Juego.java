package juego;

import dao.JugadorDAO;
import dao.ScoreDAO;
import mapa.Mapa;
import modelo.Jugador;
import score.Score;


import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Juego {
    private Jugador jugador = new Jugador();// Objeto jugador que representa al jugador durante toda la partida
    private Mapa mapa;// Objeto mapa que contiene todas las zonas del juego

    private Score tablaClasificacion = new Score();

    private JugadorDAO jugadorDAO;
    private ScoreDAO scoreDAO;

    /*
     * Constructor de la clase Juego
     * Recibe el Scanner para poder usarlo en las zonas
     */
    public Juego(Scanner sc, JugadorDAO jugadorDAO, ScoreDAO scoreDAO) {
        this.mapa = new Mapa(sc);
        this.jugadorDAO = jugadorDAO;
        this.scoreDAO = scoreDAO;
    }

    public void iniciar() {

        cargarTablaClasificacion();

        do {
            jugador = escogerModoJuego();
        } while (jugador == null);
        System.out.println();


        /*
         * Bucle principal , se continua mientras el jugador tenga vida y el juego no
         * este completado
         */
        do {
            /*
             * Muestra la rabia restante , muestra las zonas del mapa y permite al jugador
             * seleccionar la zona
             */
            System.out.println("────────────────────────────────────────────");
            System.out.println("  GOD OF WAR III LA DESTRUCCIÓN DEL OLIMPO  ");
            System.out.println("────────────────────────────────────────────");
            System.out.println(jugador.mostrarEnConsola());
            System.out.println();

            if (jugador.estaVivo()) {
                mapa.mostrarZonas();
                mapa.seleccionarZona(jugador);
                System.out.println();
            }
        } while (jugador.estaVivo() && !mapa.juegoCompletado() && mapa.continuarJuego());

        /* Si el jugador se queda sin rabia pierde y si completa todas las zonas gana */
        if (!jugador.estaVivo()) {
            System.out.println("Has perdido toda tu rabia...");
        } else {
            if (mapa.juegoCompletado()) {
                System.out.println("¡Has derrotado a Zeus!");
            } else {
                System.out.println("Adios ...");
            }
        }

        jugadorDAO.actualizar(jugador);
        tablaClasificacion.guardar(jugador);
        scoreDAO.guardarArchivo(tablaClasificacion.getMapaScore());
    }

    public Jugador escogerModoJuego() {
        int op = mapa.imprimirOpcionesJuego();

        switch (op) {
            case 1: // ES JUGADOR NUEVO
                jugador = mapa.crearJugador();
                jugador = jugadorDAO.guardar(jugador);
                break;
            case 2: // RECUPERAR POR ID
                int id = mapa.crearIdJugador();
                jugador = jugadorDAO.buscar(id);
                if (jugador != null) {
                    mapa.cargarZonas(jugador);
                } else {
                    System.out.println("ERROR - el jugador con ID : " + id + ", NO EXISTE");
                }
                break;
            case 3: // Mostrar tabla clasificaciones
                tablaClasificacion.mostrar();
                jugador = null;

                break;
            case 4: //Salir
                System.out.println("Gracias por jugar Nuestro juego - Dev. Fabrizzio");
                System.exit(0);
                break;
            default:
                System.out.println("ERROR - opcion incorrecta");
                jugador = null;
        }
        return jugador;
    }

    public void cargarTablaClasificacion() {
        Map<Integer, List<String>> mapaRecuperado = scoreDAO.leerDataArchivo();
        tablaClasificacion = new Score(mapaRecuperado);
    }

}
