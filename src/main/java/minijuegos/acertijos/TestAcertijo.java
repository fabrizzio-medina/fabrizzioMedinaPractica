package minijuegos.acertijos;

import modelo.Jugador;
import modelo.zona.TemploPoseidon;
import modelo.zona.Zona;


import java.util.Scanner;

public class TestAcertijo {

    static void main(String[] args) {
        Zona poseidon = new TemploPoseidon(new Scanner(System.in));
        poseidon.entrar(new Jugador());
    }
}
