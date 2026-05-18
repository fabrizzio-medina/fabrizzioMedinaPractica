package minijuegos.acertijos;



import minijuegos.interfazDelMinijuego.Minijuego;

import java.util.*;

public class Acertijo implements Minijuego {

    private Map<String , String> acertijos = new HashMap<>();

    public Acertijo() {
        inicializarAcertijos();
    }

    private void inicializarAcertijos(){
        acertijos.put("Soy el Dios del trueno y del rayo, y mando en el Monte Olimpo.\n¿Quien soy?", "Zeus");
        acertijos.put("Descifra: L4 luz br1ll4nt3 d3l 4m4n3c3r", "la luz brillante del amanecer");
        acertijos.put("No nací con fuego ni acero infernal,\n" +
                "mas juré obediencia por un pacto fatal.\n" +
                "Encadenado al odio, esclavo del dolor,\n" +
                "fui arma de guerra al servicio del terror.\n¿Qué es?", "Las Espadas del Caos");
        acertijos.put("Soy un perro de tres cabezas que custodia la entrada al inframundo.\n" +
                " Nadie puede entrar sin mi consentimiento ¿Quien soy?" , "cerbero");
        acertijos.put("Soy invisible, pero todos me sienten.\r\n" + "Puedo paralizar al valiente y despertar al cobarde.\r\n"
                + "A veces me enfrentas, a veces me huyes,\r\n"
                + "y aunque nadie me puede tocar, mi poder es real.\r\n" + "¿Qué soy?" , "el miedo");
    }

    private String getAcertijoAleatorio() {
        List<String> preguntas = new ArrayList<>(acertijos.keySet());

        Random random = new Random();
        String preguntaAleatoria = preguntas.get(random.nextInt(preguntas.size()));
        return preguntaAleatoria;
    }

    private boolean esRespuestaCorrecta(String pregunta, String respuesta){
        return acertijos.get(pregunta).equalsIgnoreCase(respuesta);
    }


    @Override
    public boolean jugar() {
        Scanner entrada = new Scanner(System.in);

        String pregunta = getAcertijoAleatorio();
        System.out.println(pregunta);
        System.out.print("Tu respuesta : ");
        String respuesta = entrada.nextLine();

        if (esRespuestaCorrecta(pregunta, respuesta)) {
            System.out.println("Correcto!");
            return true;
        }

        System.out.println("Incorrecto.");
        return false;
    }
    }

