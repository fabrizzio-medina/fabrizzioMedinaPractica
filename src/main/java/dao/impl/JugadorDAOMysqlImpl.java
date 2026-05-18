package dao.impl;

import dao.ConnectionFactory;
import dao.JugadorDAO;
import modelo.Jugador;

import java.sql.*;
import java.util.List;

public class JugadorDAOMysqlImpl implements JugadorDAO {
    private final String INSERT_SQL = "INSERT INTO jugador (nombre, rabia, zona) VALUES (?, ?, ?);";
    private final String UPDATE_SQL = "UPDATE jugador SET rabia = ?, zona = ? WHERE id = ?;";
    private final String SELECT_SQL = "SELECT id, nombre, rabia, zona, fecha_juego FROM jugador WHERE id = ?;";

    @Override
    public Jugador guardar(Jugador jugador) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)){

            pstmt.setString(1, jugador.getNombre());
            pstmt.setInt(2, jugador.getRabia());
            pstmt.setString(3, jugador.getZona());

            int resultado = pstmt.executeUpdate();
            if(resultado == 0){
                throw new SQLException("ERROR - no se inserto");
            }

            try(ResultSet rs = pstmt.getGeneratedKeys()){
                if(rs.next()){
                    int id = rs.getInt(1);
                    jugador.setId(id);
                    return jugador;
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al insertar: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Jugador buscar(Integer id) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_SQL)){

            pstmt.setInt(1, id);

            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    Jugador jugador = new Jugador();
                    jugador.setId(rs.getInt("id"));
                    jugador.setNombre(rs.getString("nombre"));
                    jugador.setRabia(rs.getInt("rabia"));
                    jugador.setZona(rs.getString("zona"));
                    return jugador;
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al insertar: " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean actualizar(Jugador jugador) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE_SQL)){

            pstmt.setInt(1, jugador.getRabia());
            pstmt.setString(2, jugador.getZona());
            pstmt.setInt(3, jugador.getId());

            int resultado = pstmt.executeUpdate();
            return resultado > 0;

        } catch (SQLException e) {
            System.err.println("Error al insertar: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Jugador> getLista() {
        return null;
    }
}
