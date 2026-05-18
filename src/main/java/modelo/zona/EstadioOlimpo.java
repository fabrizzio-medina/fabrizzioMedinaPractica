package modelo.zona;


import minijuegos.interfazDelMinijuego.Minijuego;
import minijuegos.piedraPapelOTijera.PiedraPapelTijera;
import modelo.Jugador;

import java.util.Scanner;

public class EstadioOlimpo extends  Zona{


    public EstadioOlimpo(Scanner sc) {
        super("Estadio del Olimpo", false, sc);
    }

    @Override
    public boolean entrar(Jugador jugador) {

        System.out.println("============================================");
        System.out.println("    ── " + getNombre() + " ──");
        System.out.println("============================================");
        System.out.println("\r\n");
        System.out.println(
                "Kratos, después de ser ayudado por el espartano y recibir el código de ingreso al ‘Estadio Olimpo’\r\n"
                        + "donde se encontraba su medio hermano Hércules, hijo de Zeus, avanzó con determinación.\r\n"
                        + "Hércules le tenía envidia, y al encontrarse, entablaron una conversación.\r\n"
                        + "—Oh, hermano mío —dijo Hércules—. Creía que solo eran rumores que estabas eliminando a los dioses con tu poder mental\r\n"
                        + "pero déjame decirte que conmigo no podrás.\r\n" + "Kratos respondió:\r\n"
                        + "—Hércules, sigues siendo el mismo: un empleado de Zeus. Mientras que YO estoy llevando el final del Monte Olimpo.\r\n"
                        + "Hércules rió y exclamó:\r\n"
                        + "—¡Ja, ja! Sigue creyendo que conmigo podrás , te reto a un piedra , papel o tijera.\r\n"
                        + "si me ganas te dejo pasar al Jardín de mi madre ,y  si no, serás echado de mis tierras.\r\n"
                        + "—Ya lo verás —replicó Kratos.\n"
                        + "Hercules: tienes solo un intento y tienes que ganarme si o si , si empatamos te echare igual de mis tierras");
        System.out.println("\r\n");

        Minijuego juegoActual = new PiedraPapelTijera();
        boolean esGanador = juegoActual.jugar();

        if (esGanador) {
            marcarComoCompletada();
            return true;
        }

        jugador.restarRabia();
        return false;
    }
}
