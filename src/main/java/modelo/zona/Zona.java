package modelo.zona;

import modelo.Jugador;

import java.util.Scanner;

public abstract class Zona {
    protected String nombre;
    protected boolean desbloqueada;
    protected boolean completada;
    protected Scanner sc;

    // constructor de la zona
    public Zona(String nombre, boolean desbloqueadaInicial, Scanner sc) {

        this.nombre = nombre;
        this.desbloqueada = desbloqueadaInicial;
        this.completada = false;
        this.sc = sc;
    }

    // devuelve el nombre de la zona
    public String getNombre() {
        return nombre;
    }

    // indica si la zona esta desbloqueada
    public boolean estaDesbloqueada() {
        return desbloqueada;
    }

    // indica si la zona esta completada
    public boolean estaCompletada() {
        return completada;
    }

    // desbloquea la zona
    public void desbloquear() {
        desbloqueada = true;
    }

    // marca la zona como completado
    public void marcarComoCompletada() {
        completada = true;
    }

    /* Este es el metodo abstracto que cada zona implementa */
    public abstract boolean entrar(Jugador jugador);



}
