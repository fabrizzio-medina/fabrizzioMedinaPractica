package dao.utilidad;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Archivo {
    private static final String RUTA_GUARDAR = "C:\\resources\\";

    public static void guardarScoreArchivoBufferStream(String nombreArchivo, Map<Integer, List<String>> score){
        String rutaFinal = RUTA_GUARDAR + nombreArchivo;
        System.out.println(rutaFinal);

        try (OutputStream fileOut = new FileOutputStream(rutaFinal);
             Writer writerStream = new OutputStreamWriter(fileOut, StandardCharsets.UTF_8);
             BufferedWriter writer = new BufferedWriter(writerStream)) {

            Iterator<Map.Entry<Integer, List<String>>> mapaIterator = score.entrySet().iterator();

            while (mapaIterator.hasNext()) {
                Map.Entry<Integer, List<String>> fila = mapaIterator.next();
                int llave = fila.getKey();
                for (String valor : fila.getValue()) {
                    String resultado = llave + "-" + valor;
                    //System.out.print(resultado);
                    writer.write(resultado);
                    writer.newLine();

                }
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            System.out.println("FILENOT" + e.getMessage());
        } catch (IOException io) {
            System.err.println("IO" + io.getMessage());
        }
    }

    public static Map<Integer, List<String>> leerDataTxtBufferStream(String nombreArchivo) {
        String rutaFinal = RUTA_GUARDAR + nombreArchivo;
        System.out.println(rutaFinal);

        try {
            File archivo = new File(rutaFinal);
            if(!archivo.exists()){
                System.out.println("INFO - Archivo no existe, se procede a crearlo");
                archivo.createNewFile();
            }
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }

        Map<Integer, List<String>> mapaResultado = new HashMap<>();

        try (InputStream fileIn = new FileInputStream(rutaFinal);
             Reader readerStream = new InputStreamReader(fileIn);
             BufferedReader reader = new BufferedReader(readerStream)) {
            String fila;

            while((fila = reader.readLine()) != null){
                //System.out.println("Linea: "+fila);
                String[] datos = fila.split("-");
                int llave = Integer.parseInt(datos[0].trim());
                String valor = datos[1];

                if(mapaResultado.containsKey(llave)){
                    List<String> nombresLista = mapaResultado.get(llave);
                    nombresLista.add(valor);
                } else{
                    List<String> nombresLista = new ArrayList<>();
                    nombresLista.add(valor);
                    mapaResultado.put(llave, nombresLista);
                }
            }

        }catch(NumberFormatException nfe) {
            System.out.println(nfe.getMessage());
        } catch (FileNotFoundException fne) {
            System.out.println(fne.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return mapaResultado;
    }









}
