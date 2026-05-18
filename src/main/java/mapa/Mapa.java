package mapa;


import excepciones.EntradaInvalidaException;
import modelo.Jugador;
import modelo.zona.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mapa {

    // Lista que contiene todas las zonas del juego
    private List<Zona> zonas = new ArrayList<>();
    // scanner para leer las entradas del ususario
    private boolean continuarJuego = true;
    private Scanner sc;

    // constructor del mapa
    public Mapa(Scanner sc) {
        // llama al scanner
        this.sc = sc;
        // Se añaden laz zonas a la lista
        zonas.add(new TemploPoseidon(sc));
        zonas.add(new CiudadOlimpia(sc));
        zonas.add(new CiudadelaOlimpo(sc));
        zonas.add(new EstadioOlimpo(sc));
        zonas.add(new JardinHera(sc));
        zonas.add(new InframundoHades(sc));
        zonas.add(new TemploPandora(sc));
        zonas.add(new SalonOlimpo(sc));
    }

    public int imprimirOpcionesJuego(){
        System.out.println("\nOpciones para jugar");
        System.out.println("1. Nuevo Juego");
        System.out.println("2. Recuperar jugador con ID");
        System.out.println("3. Mostrar tabla clasificacion");
        System.out.println("4. Salir");
        System.out.print("Escoga opcion: ");
        int op = sc.nextInt();
        sc.nextLine();
        return op;
    }

    public Jugador crearJugador(){
        System.out.print("Bienvenido, por favor ingresa tu nombre : ");
        String nombreJugador = sc.nextLine().trim();

        Jugador jugador = new Jugador();
        jugador.setNombre(nombreJugador);
        jugador.setZona(getNombreZona(0));
        return jugador;
    }

    public int crearIdJugador(){
        System.out.print("Ingresa tu ID : ");
        int id = sc.nextInt();
        sc.nextLine();
        return id;
    }

    public void cargarZonas(Jugador jugador){
        int indice = getIndicesZona(jugador.getZona());
        for (int i = 0; i < indice; i++) {
            zonas.get(i).marcarComoCompletada();
            zonas.get(i + 1).desbloquear();
        }

    }

    // Muestra las zonas y si esta bloqueado , desbloqueado o completado
    public void mostrarZonas() {

        for (int i = 0; i < zonas.size(); i++) {

            Zona z = zonas.get(i);
            String estado;

            if (!z.estaDesbloqueada()) {
                estado = "[Bloqueado]";
            }else if (z.estaCompletada()) {
                estado = "[Completado]";
            }else {
                estado = "[Disponible]";
            }

            // Muestra la zona , su numero de zona y el estado
            System.out.println((i + 1) + ". " + z.getNombre() + " " + estado);
        }
    }

    // En este metodo permite al jugador elegir la zona y aca estan las excepciones
    public void seleccionarZona(Jugador jugador) {

        try {

            System.out.println("Ingrese 99 para salir");
            System.out.print("Elige zona: ");

            // aqui se verifica que el usuario introduza un numero
            if (!sc.hasNextInt()) {
                throw new EntradaInvalidaException("Debes introducir un número de zona.");
            }

            int opcion = sc.nextInt();
            sc.nextLine();

            if(opcion == 99){
                continuarJuego = false;
                return;
            }

            // aqui el numero este dentro del rango de asignación de zonas
            if (opcion < 1 || opcion > zonas.size()) {
                throw new EntradaInvalidaException("La zona no existe. Solo esta disponible en el rango indicado");
            }

            // Obtiene la zona seleccionada
            Zona zona = zonas.get(opcion - 1);

            // Verifica si la zona esta bloqueada
            if (!zona.estaDesbloqueada()) {
                System.out.println("Zona bloqueada.");
                return;
            }

            // Verifica si la zona esta completada
            if (zona.estaCompletada()) {
                System.out.println("Zona ya completada.");
                return;
            }

            // aqui entra a la zona
            boolean superada = zona.entrar(jugador);

            // aqui si supera la zona pasa a la siguiente
            if (superada) {
                desbloquearSiguiente(opcion - 1);
                if(opcion < zonas.size()){
                    jugador.setZona(zonas.get(opcion).getNombre());
                }
            }

        } catch (EntradaInvalidaException e) {
            // aqui se lanza el mensaje personalizado
            System.out.println("Error: " + e.getMessage());
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("Entrada incorrecta.");
            sc.nextLine();
        }
    }

    // en este metodo se desbloquea la siguiente zona
    private void desbloquearSiguiente(int actual) {
        if (actual + 1 < zonas.size()) {
            zonas.get(actual + 1).desbloquear();
        }
    }

    // en este metodo se comprueba si todas las zonas han sidos completadas
    public boolean juegoCompletado() {
        for (Zona z : zonas)
            if (!z.estaCompletada())
                return false;
        return true;
    }


    public String getNombreZona(int indice){
        if(indice < 0 || indice > zonas.size()){
            return null;
        }
        return zonas.get(indice).getNombre();
    }


    public int getIndicesZona(String nombre) {
        for (int i = 0; i < zonas.size(); i++) {
            if (zonas.get(i).getNombre().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public boolean continuarJuego() {
        return continuarJuego;
    }
}
