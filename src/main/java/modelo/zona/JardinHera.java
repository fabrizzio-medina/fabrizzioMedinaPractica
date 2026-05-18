package modelo.zona;

import minijuegos.acertijos.Acertijo;
import minijuegos.interfazDelMinijuego.Minijuego;
import modelo.Jugador;

import java.util.Scanner;

public class JardinHera extends Zona{


    public JardinHera(Scanner sc) {
        super("Jardines de Hera", false, sc);
    }

    @Override
    public boolean entrar(Jugador jugador) {
        System.out.println("============================================");
        System.out.println("    ── Entrada a " + getNombre() + " ──");
        System.out.println("============================================");
        System.out.println("\r\n");

        System.out.println(
                "Luego de pasar el acertijo de Hércules, Kratos siguió caminando por el estadio hasta que encontró un callejón que conducía directamente a los Jardines de Hera.\r\n"
                        + "Kratos ingresó por el callejón y descubrió un lugar lleno de áreas verdes y un majestuoso templo. Caminó hasta el templo, donde se encontró con Hera y comenzaron un diálogo.\r\n"
                        + "\r\n" + "Hera dijo:\r\n"
                        + "—Vaya, vaya… hasta que el “Fantasma de Esparta” vino a desafiarme con su inteligencia.\r\n"
                        + "\r\n" + "Kratos respondió:\r\n"
                        + "—Hera, esto no es asunto tuyo. Yo solo vengo a cumplir mi venganza contra Zeus. Solo elimino a los que se oponen en mi camino.\r\n"
                        + "\r\n" + "Hera replicó:\r\n"
                        + "—Pues para pasar a mi templo y acceder al camino hacia el inframundo, donde se encuentra Hades,\r\n"
                        + "debes resolver un acertijo que pruebe si, además de destructor de dioses, eres realmente inteligente.");
        System.out.println("\r\n");
        System.out.println(
                "Hera :Como puedes apreciar, espartano, tengo mi jardín muy bien cuidado. Te haré un acertijo en el que tendrás que usar muy bien tu diminuto cerebro.\r\n"
                        + "Usaré las frutas de mi jardín para esto.\n"
                        + "Ojo con este dato , si se te cae alguna fruta ya no se cuentan.\r\n"
                        + "Si te entrego 484 manzanas y 316 bananas pero con el peso se te cae 20 bananas y 114 manzanas… ¿cuántas frutas tienes?");
        System.out.println("Si lo resuelves bien con ese resultado podras ingresar al inframundo de Hades");
        System.out.println("\r\n");

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
