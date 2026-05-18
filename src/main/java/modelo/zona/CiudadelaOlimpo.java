package modelo.zona;

import modelo.Jugador;

import java.util.Scanner;

public class CiudadelaOlimpo extends Zona {

    public CiudadelaOlimpo(Scanner sc) {
        super("Ciudadela del Olimpo", false, sc);
    }

    @Override
    public boolean entrar(Jugador jugador) {

        System.out.println("============================================");
        System.out.println("    ── Entrada a " + getNombre() + " ──");
        System.out.println("============================================");
        System.out.println("\r\n");

        System.out.println(
                "Después de ayudar a Kratos a descifrar la palabra, entro por la puerta donde llego a la 'Ciudadela del Olimpo'.\n"
                        + "Caminando por los lugares, encontró a un espartano, un antiguo compañero suyo, que estaba gravemente herido y le pidió ayuda a Kratos.\n"
                        + "Pero como Kratos sigue aun con las tormentas en su cabeza, la decisión de ayudar es tuya.");
        System.out.println("\r\n");
        System.out.println("¿Ayudar al espartano? (si/no)");
        String r = sc.nextLine();

        if (!r.equalsIgnoreCase("si")) {
            jugador.restarRabia();
            return false;
        }

        System.out.println(
                "Kratos ayudó amablemente al espartano a ponerse de pie, y mientras lo sostenía, mantuvieron una breve conversación.\r\n"
                        + "El espartano dijo:\r\n" + "\r\n"
                        + "—Oh, señor Kratos, nuestro ejército de guerra fue destruido por Zeus. Yo logré escapar, pero estoy muy malherido.\r\n"
                        + "\r\n" + "Kratos respondió:\r\n" + "\r\n"
                        + "—Tranquilo, soldado. He venido a cumplir mi venganza contra Zeus. Todo aquel que se interponga en mi camino será eliminado.\r\n"
                        + "\r\n" + "El espartano asintió con dificultad y dijo:\r\n" + "\r\n"
                        + "—Confío en usted, mi señor. Pero para avanzar a la siguiente habitación, tiene que ingresar la clave “16032010”.\r\n"
                        + "\r\n" + "Kratos le respondió:\r\n" + "\r\n" + "—Muchas gracias, espartano.");

        System.out.println("Ingresa clave:");
        String clave = sc.nextLine();

        if (clave.equals("16032010")) {
            marcarComoCompletada();
            return true;
        } else {
            System.out.println("No ayudaste a tu sangre , no tienes humildad . PERDISTE");
            jugador.restarRabia();
            return false;
        }
    }

}
