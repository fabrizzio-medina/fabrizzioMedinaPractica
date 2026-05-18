package main;

import dao.JugadorDAO;
import dao.ScoreDAO;
import dao.impl.JugadorDAOMysqlImpl;
import dao.impl.ScoreDAOArchivoImpl;
import juego.Juego;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        // Se crea un objeto Scanner para leer
        // la entrada del usuario desde la consola
        Scanner sc = new Scanner(System.in);
        JugadorDAO jugadorDAO = new JugadorDAOMysqlImpl();
        ScoreDAO scoreDAO = new ScoreDAOArchivoImpl();

        // Se crea el objeto Juego y se le pasa el Scanner
        // para que todas las clases del juego puedan leer datos del usuario


        Juego juego = new Juego(sc, jugadorDAO, scoreDAO);
        juego.iniciar();

        sc.close();
    }
}
