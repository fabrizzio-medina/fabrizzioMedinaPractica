package modelo.zona;

import minijuegos.acertijos.Acertijo;
import minijuegos.interfazDelMinijuego.Minijuego;
import modelo.Jugador;

import java.util.Scanner;

public class TemploPoseidon extends Zona {


    public TemploPoseidon(Scanner sc) {
        super("Templo de Poseidón", true, sc);
    }

    @Override
    public boolean entrar(Jugador jugador) {

        System.out.println("============================================");
        System.out.println("    ── Entrada a " + getNombre() + " ──");
        System.out.println("============================================");
        System.out.println("\r\n");

        System.out.println("Kratos ingresó al templo de Poseidón.\n"
                + "Luego de caminar, encontró un pasadizo que conducía al siguiente lugar\n"
                + "pero para pasar debía resolver una adivinanza puesta por el dios Poseidón.");
        System.out.println("\n");

        Minijuego juegoActual = new Acertijo();
        boolean esGanador = juegoActual.jugar();

        if(esGanador){
            marcarComoCompletada();
            return true;
        }
        jugador.restarRabia();
        return false;

    }
}
