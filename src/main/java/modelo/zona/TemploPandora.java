package modelo.zona;


import minijuegos.acertijos.Acertijo;
import minijuegos.interfazDelMinijuego.Minijuego;
import modelo.Jugador;

import java.util.Scanner;

public class TemploPandora extends Zona{


    public TemploPandora(Scanner sc) {
        super("Templo de Pandora", false, sc);
    }

    @Override
    public boolean entrar(Jugador jugador) {

        System.out.println("============================================");
        System.out.println("    ── Entrada a " + getNombre() + " ──");
        System.out.println("============================================");
        System.out.println("\r\n");

        System.out.println(
                "El Templo de Pandora —un coloso viviente vagando por el desierto como una bestia dormida— había sido creado no solo como prisión, sino como juicio.\r\n"
                        + "Cada habitante del templo, cada bestia encadenada, cada mecanismo mortal tenía un propósito:\r\n"
                        + "medir la voluntad del que buscara la caja.\r\n" + "\r\n"
                        + "Miles habían intentado llegar al corazón del templo antes que Kratos.\r\n"
                        + "Ninguno sobrevivió.\r\n" + "\r\n"
                        + "El aire dentro del templo era pesado, impregnado de un susurro antiguo.\r\n"
                        + "No era la voz de Hades, ni la de Zeus…\r\n"
                        + "Era la voz de los males primordiales, encerrados junto con el poder divino.\r\n" + "\r\n"
                        + "A medida que Kratos se acercaba a la cámara final, los muros parecían respirar.\r\n"
                        + "Cada antorcha ardía con una llama azulada, como si la caja misma supiera que un nuevo mortal intentaba desafiar su destino.\r\n"
                        + "\r\n"
                        + "En el centro de la cámara, la Caja de Pandora reposaba sobre un pedestal de hueso y oro.\r\n"
                        + "A su alrededor, tres anillos giratorios estaban grabados con símbolos arcanos.\r\n"
                        + "Eran el sello final impuesto por los dioses.\r\n" + "\r\n"
                        + "La Caja no podía abrirse con fuerza.\r\n" + "No podía romperse.\r\n"
                        + "No podía quemarse ni destruirse.\r\n" + "\r\n"
                        + "Solo podía abrirla aquel que resolviese la Adivinanza del Origen,\r\n"
                        + "el acertijo que Pathos Verdes III dejó antes de morir, sellado con su último aliento.\r\n"
                        + "\r\n" + "Y en cuanto Kratos dio un paso al frente…\r\n"
                        + "la voz de Pandora —su espíritu atrapado en el templo— susurró la prueba final.");
        System.out.println("\r\n");
        System.out.println("Tu misión es descifrar la palabra de esta adivinanza, para abrir la caja de pandora\r\n"
                + "pero a la vez esta palabra es la debilidad de los Dioses");
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
