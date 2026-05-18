package dao;

import java.util.List;
import java.util.Map;

public interface ScoreDAO {

    void guardarArchivo(Map<Integer, List<String>> mapaScore);

    Map<Integer, List<String>> leerDataArchivo();
}
