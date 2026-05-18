package modelo.zona;


import minijuegos.interfazDelMinijuego.Minijuego;
import minijuegos.michi.TresEnRaya;
import modelo.Jugador;

import java.util.Scanner;

public class SalonOlimpo extends Zona{


    public SalonOlimpo(Scanner sc) {
        super("Salón del Olimpo", false, sc);
    }

    @Override
    public boolean entrar(Jugador jugador) {

        System.out.println("============================================");
        System.out.println("    ── Entrada a " + getNombre() + " ──");
        System.out.println("============================================");
        System.out.println("\r\n");
        System.out.println("El Último Ascenso: Mi Batalla Final contra Zeus\r\n" + "\r\n"
                + "El viento golpea mi rostro mientras escalo la cima del Monte Olimpo.\r\n"
                + "La tormenta ruge encima de mí como si el cielo mismo quisiera detenerme, pero nada puede hacerlo ya.\r\n"
                + "He cumplido todas las misiones, he destrozado cada obstáculo, he derribado a dioses y monstruos. No queda nadie entre Zeus y yo.\r\n"
                + "\r\n"
                + "El palacio celestial aparece frente a mí, derrumbado en partes por la guerra que yo mismo liberé. Las nubes giran en espiral, cargadas de la ira de mi padre.\r\n"
                + "Esa ira ya no me intimida.\r\n" + "\r\n" + "El Encuentro\r\n" + "\r\n"
                + "Cuando cruzo las puertas destruidas, lo veo allí, de pie entre ruinas doradas. La luz que emana de Zeus ilumina el cielo, pero sus ojos… sus ojos revelan temor.\r\n"
                + "El temor de un dios que sabe que su hora ha llegado.\r\n" + "\r\n"
                + "—Hijo mío, —retumba su voz—. Tu desafío termina aquí. Soy el rey de los dioses. Soy eterno.\r\n"
                + "\r\n"
                + "Agarro con fuerza mis Espadas del Exilio. Las cadenas tintinean como si recordaran todas las veces que fui su herramienta y su víctima.\r\n"
                + "\r\n" + "—No soy tu hijo —le respondo—. Soy tu castigo.");
        System.out.println("\r\n");
        System.out.println(
                "Después de incontables batallas, enfrentando a dioses y superando obstáculos que pocos mortales podrían soportar, Kratos llega ante el imponente Zeus.\r\n"
                        + "El Olimpo tiembla mientras ambos se preparan para un duelo que desafía toda lógica… ¡una partida de 3 en raya que decidirá el destino del mundo!\r\n"
                        + "Cada movimiento cuenta, cada decisión puede ser mortal. Tu misión es guiar a Kratos hacia la victoria y escribir con él una nueva leyenda en la historia de los dioses.");

        Minijuego juegoFinal = new TresEnRaya(sc);
        boolean gana = juegoFinal.jugar();

        if (gana) {
            System.out.println("Felicicades ayudaste a kratos a ganar...... .");
            System.out.println("\r\n");
            System.out.println(
                    "El tablero roto seguía humeando cuando los dioses retrocedieron, temerosos del hombre que había doblegado al destino.\r\n"
                            + "Kratos permaneció de pie, inmóvil, rodeado de silencio…\r\n"
                            + "pero algo en él no estaba en paz.\r\n" + "\r\n" + "Había ganado.\r\n"
                            + "Había humillado a Zeus.\r\n" + "Había hecho temblar al Olimpo entero.\r\n" + "\r\n"
                            + "Y sin embargo…\r\n" + "\r\n"
                            + "En cuanto la última chispa del Tablero del 3 en raya se apagó, el espartano sintió un frío extraño recorrer su pecho.\r\n"
                            + "No era miedo.\r\n" + "No era ira.\r\n" + "\r\n" + "Era vacío.\r\n" + "\r\n"
                            + "Una sensación profunda, oscura, como si la victoria hubiera arrancado algo más de su alma.\r\n"
                            + "\r\n" + "Miró sus manos, aún marcadas por la furia y el fuego.\r\n"
                            + "Habían destruido dioses, bestias, reinos.\r\n" + "Habían vencido incluso al destino.\r\n"
                            + "\r\n" + "Pero no podían llenar el hueco que crecía en su interior.\r\n" + "\r\n"
                            + "Un pensamiento lo atravesó, amargo como acero oxidado:\r\n" + "\r\n"
                            + "Si incluso vencer a un dios no me satisface… ¿qué me queda?\r\n" + "\r\n"
                            + "Los dioses lo observaban desde lejos, temblando.\r\n" + "No por la fuerza de Kratos,\r\n"
                            + "sino por la sombra que lo envolvía:\r\n" + "\r\n"
                            + "la sombra de alguien que ya no sabía qué buscar,\r\n" + "qué destruir,\r\n"
                            + "qué salvar.\r\n" + "\r\n"
                            + "Kratos dio un paso hacia la salida del salón del Olimpo.\r\n"
                            + "Su voz se escuchó apenas como un gruñido apagado, dirigido a nadie… o tal vez a él mismo:\r\n"
                            + "\r\n" + "—La victoria… no cura nada.\r\n" + "\r\n"
                            + "Y por primera vez, el Fantasma de Esparta comprendió que su mayor enemigo no era Zeus,\r\n"
                            + "ni el destino,\r\n" + "ni los dioses.\r\n" + "\r\n"
                            + "Era el abismo que llevaba dentro.\r\n" + "\r\n" + "Un abismo tan profundo…\r\n"
                            + "que ni todas sus victorias podían llenarlo.");
            marcarComoCompletada();
            return true;
        } else {

            System.out.println("Kratos colocó su última ficha, esperando la victoria.\r\n"
                    + "Pero Zeus completó la línea perfecta.\r\n"
                    + "El mundo tembló y el Olimpo desapareció ante él.\r\n" + "\r\n"
                    + "De repente, estaba solo, atrapado en un vacío: voces de los que había perdido, imágenes de su furia y traiciones lo acosaban.\r\n"
                    + "Truenos y relámpagos atravesaban su mente, cada recuerdo más doloroso que el anterior.\r\n"
                    + "\r\n" + "Intentó levantarse, blandir sus armas, gritar…\r\n"
                    + "pero eran sombras y ecos, recordándole que incluso él podía caer.\r\n" + "\r\n"
                    + "Zeus apareció entre la tormenta y murmuró:\r\n"
                    + "—Has sido fuerte, Kratos… pero ahora conocerás la derrota.\r\n" + "\r\n"
                    + "El Fantasma de Esparta quedó atrapado en su propia mente, condenado a revivir su fracaso una y otra vez\r\n"
                    + "mientras la tormenta del Olimpo recordaba que no todos los combates se ganan, ni todos los espíritus se liberan.");
            jugador.restarRabia();
            return false;

        }

    }
}
