package minijuegos.piedraPapelOTijera;



import minijuegos.interfazDelMinijuego.Minijuego;

import java.util.Scanner;

public class PiedraPapelTijera implements Minijuego {

    private boolean evaluarJugada(String jugador, String cpu){
        return  (jugador.equals("piedra") && cpu.equals("tijera")) ||
                (jugador.equals("tijera") && cpu.equals("papel")) ||
                (jugador.equals("papel") && cpu.equals("piedra"));
    }


    @Override
    public boolean jugar() {
        Scanner entrada = new Scanner(System.in);

        System.out.printf("Elige %s : " , UtilidadMinijuegos.getTitulosAsString());
        String usuario = entrada.nextLine().toLowerCase();

        String hercules = UtilidadMinijuegos.elegirRandomCPU();
        System.out.println("Hércules eligió: " + hercules);

        if (usuario.equalsIgnoreCase(hercules)) {
            System.out.println("Hemos empatado espartano , por lo tanto no podras pasar");
            return false;
        }

        if (evaluarJugada(usuario, hercules)) {
            System.out.println("Has ganado");
            return true;
        }
        return false;
    }
}
