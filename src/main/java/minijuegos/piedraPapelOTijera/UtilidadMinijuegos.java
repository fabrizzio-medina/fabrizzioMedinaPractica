package minijuegos.piedraPapelOTijera;

import java.util.Random;

public class UtilidadMinijuegos {
    public static final char LETRA_EN_BLANCO = ' ';

    private static final String[] OPCIONES = {"Piedra", "Papel", "Tijera"};

    private UtilidadMinijuegos()
    {
    }
    public static String elegirRandomCPU() {
        Random random = new Random();
        return OPCIONES[random.nextInt(OPCIONES.length)].toLowerCase();
    }

    public static String[] getTitulos(){
        return OPCIONES;
    }

    public static String getTitulosAsString(){
        String resultado = "";
        for (int i = 0; i < OPCIONES.length; i++){
            if(i != 0){
                resultado += ", ";
            }
            resultado += OPCIONES[i];
        }
        return resultado;
    }
}
