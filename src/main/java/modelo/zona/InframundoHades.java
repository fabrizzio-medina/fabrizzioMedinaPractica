package modelo.zona;


import minijuegos.acertijos.Acertijo;
import minijuegos.interfazDelMinijuego.Minijuego;
import modelo.Jugador;

import java.util.Scanner;

public class InframundoHades extends  Zona {

    public InframundoHades(Scanner sc) {
        super("Inframundo", false, sc);
    }

    @Override
    public boolean entrar(Jugador jugador) {
        System.out.println("============================================");
        System.out.println("    ── Entrada a " + getNombre() + " ──");
        System.out.println("============================================");
        System.out.println("\r\n");
        System.out.println(
                "Kratos ya se olía que cada vez se acercaba a Zeus, listo para cobrar venganza en el Monte Olimpo, donde fue traicionado por los dioses.\r\n"
                        + "Cada paso que daba era un alivio más para quitarse esos tormentos de la cabeza, de aquella noche en la que fue manipulado.\r\n"
                        + "\r\n"
                        + "Kratos sabía que su destino estaba marcado con sabor a victoria. Siguió caminando hasta que llegó al inframundo de Hades,\r\n"
                        + "donde el infierno ardía, con almas en pena, criaturas monstruosas, y así continuó hasta llegar al templo de Hades.\r\n"
                        + "\r\n" + "Allí, Hades le dejó un mensaje:\r\n" + "\r\n"
                        + "—Espartano, oí que eres un ser difícil de deshacer, pero estás en mi mundo, en mi infierno.\r\n"
                        + "Solo te dejé una adivinanza en la cual tienes que adivinar un nombre.");
        System.out.println("\r\n");
        System.out.println("Soy un perro de tres cabezas que custodia la entrada al inframundo.\n"
                + "Nadie puede entrar sin mi consentimiento ¿Quien soy?");

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
