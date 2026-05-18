package score;

import modelo.Jugador;

import java.util.*;

public class Score {

    private Map<Integer, List<String>> mapaScore = new TreeMap<>(Comparator.comparingInt(Integer::intValue).reversed());

    public Score(){

    }

    public Score(Map<Integer, List<String>> data){
        if(data != null){
            for(Map.Entry<Integer, List<String>> fila : data.entrySet()){
                int llave = fila.getKey();

                for(String nombre : fila.getValue()){
                    List<String> listaJugadores;

                    if(mapaScore.containsKey(llave)){
                        listaJugadores = mapaScore.get(llave);
                        listaJugadores.add(nombre);
                    }else{
                        listaJugadores = new ArrayList<>();
                        listaJugadores.add(nombre);
                        mapaScore.put(llave, listaJugadores);
                    }
                }
            }
        }
    }

    public void guardar(Jugador jugador) {
        List<String> listaJugadores = mapaScore.get(jugador.getRabia());
        if (listaJugadores != null) {
            listaJugadores.add(jugador.getNombre());
        } else {
            listaJugadores = new ArrayList<>();
            listaJugadores.add(jugador.getNombre());
            mapaScore.put(jugador.getRabia(), listaJugadores);
        }
    }

    public void mostrar(){
        System.out.println("================ TABLA DE CLASIFICACION ================");
        mapaScore.entrySet().stream()
                .flatMap(fila -> fila.getValue().stream()
                        .map(nombre -> fila.getKey() + ": " + nombre))
                .limit(5)
                .forEach(System.out::println);
        System.out.println("\n");
    }

    public Map<Integer, List<String>> getMapaScore() {
        return mapaScore;
    }
}
