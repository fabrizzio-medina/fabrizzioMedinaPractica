package main;

import dao.JugadorDAO;
import dao.impl.JugadorDAOMysqlImpl;
import juego.Juego;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        JugadorDAO jugadorDAO = new JugadorDAOMysqlImpl();


        // Se crea el objeto Juego y se le pasa el Scanner
        // para que todas las clases del juego puedan leer datos del usuario


        Juego juego = new Juego(sc, jugadorDAO);
        juego.iniciar();

        sc.close();
    }
}
