package modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Jugador implements Serializable {


    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nombre;

    // representa a la rabia maxima del jugador

    private int rabia = 14;

    private String zona;

    private LocalDate fechaJuego;

    public Jugador() {
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRabia() {
        return rabia;
    }

    public void setRabia(int rabia) {
        this.rabia = rabia;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public LocalDate getFechaJuego() {
        return fechaJuego;
    }

    public void setFechaJuego(LocalDate fechaJuego) {
        this.fechaJuego = fechaJuego;
    }

    // resta rabia si pierde
    public void restarRabia() {
        rabia--;
    }

    // Comprueba si sigue vivo
    public boolean estaVivo() {
        return rabia > 0;
    }

    public String paraEscribirEnTexto() {
        return rabia + "-" + nombre;
    }

    public String mostrarEnConsola() {
        return "ID: " + id + "\nPlayer: " + nombre + "\nRabia restante: " + rabia;
    }

    @Override
    public String toString() {
        return nombre + ", rabia: " + rabia;
    }

}
