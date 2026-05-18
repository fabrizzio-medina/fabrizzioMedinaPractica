package minijuegos.michi;



import minijuegos.interfazDelMinijuego.Minijuego;

import java.util.Scanner;

public class TresEnRaya implements Minijuego {

    private Scanner sc;

    public TresEnRaya(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public boolean jugar() {

        char[][] tablero = {
                { '1', '2', '3' },
                { '4', '5', '6' },
                { '7', '8', '9' }
        };

        char turno = 'X';

        for (int i = 0; i < 9; i++) {

            mostrar(tablero);
            System.out.print("Turno " + turno + ": ");
            int pos = sc.nextInt();
            sc.nextLine();

            int fila = (pos - 1) / 3;
            int col = (pos - 1) % 3;

            if (tablero[fila][col] == 'X' || tablero[fila][col] == 'O')
                continue;

            tablero[fila][col] = turno;

            if (ganador(tablero, turno)) {
                mostrar(tablero);
                return turno == 'X';
            }

            turno = (turno == 'X') ? 'O' : 'X';
        }

        return false;
    }

    private void mostrar(char[][] t) {
        for (char[] fila : t) {
            System.out.println(fila[0] + " | " + fila[1] + " | " + fila[2]);
        }
    }

    private boolean ganador(char[][] t, char p) {
        for (int i = 0; i < 3; i++) {
            if (t[i][0] == p && t[i][1] == p && t[i][2] == p)
                return true;
            if (t[0][i] == p && t[1][i] == p && t[2][i] == p)
                return true;
        }
        if (t[0][0] == p && t[1][1] == p && t[2][2] == p)
            return true;
        if (t[0][2] == p && t[1][1] == p && t[2][0] == p)
            return true;
        return false;
    }
}
