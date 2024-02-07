package youtube;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Youtube {

    private ArrayList<Canal> canales;
    private Scanner scanner;

    public Youtube() {
        canales = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Método para mostrar el menú principal de la aplicación
    public void mostrarMenu() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("|----------------YOUTUBE------------------|");
            System.out.println("1 - Nuevo canal");
            System.out.println("2 - Seleccionar canal");
            System.out.println("3 - Mostrar estadísticas");
            System.out.println("4 - Mostrar estadísticas completas");
            System.out.println("0 - Salir");
            System.out.println("|---------------------------------------|");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearCanal();
                    break;
                case 2:
                    seleccionarCanal();
                    break;
                case 3:
                    mostrarEstadisticas();
                    break;
                case 4:
                    mostrarEstadisticasCompletas();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    continuar = false; // Cambiamos la bandera a false para salir del bucle
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }
    // Método para crear un nuevo canal
    private void crearCanal() {
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Introduce el nombre del canal: ");
        String nombre = scanner.nextLine();
        Canal nuevoCanal = new Canal(nombre, LocalDate.now().toString());
        getCanales().add(nuevoCanal);
        System.out.println("Canal creado con éxito.");
    }
    // Método para seleccionar un canal existente
    private void seleccionarCanal() {
        if (getCanales().isEmpty()) {
            System.out.println("No hay canales disponibles. Creando uno nuevo.");
            crearCanal();
        } else {
            System.out.println("Selecciona el Canal:");
            for (int i = 0; i < getCanales().size(); i++) {
                Canal canal = getCanales().get(i);
                System.out.printf("%d - %s\n", i, canal);
            }
            System.out.print("Número del canal: ");
            int indice = scanner.nextInt();
            if (indice >= 0 && indice < getCanales().size()) {
                Canal canalSeleccionado = getCanales().get(indice);
                System.out.println("Canal " + canalSeleccionado.getNombre() + " seleccionado con éxito.");
                // Mostrar el menú del canal seleccionado
                canalSeleccionado.mostrarMenuCanal();
            } else {
                System.out.println("Selección no válida.");
            }
        }
    }
    
    // Método para mostrar estadísticas básicas de la plataforma
    private void mostrarEstadisticas() {
        System.out.println("Youtube tiene " + getCanales().size() + " canal(es)");
    }
    
    // Método para mostrar estadísticas completas de la plataforma
    private void mostrarEstadisticasCompletas() {
        System.out.println("Youtube tiene " + getCanales().size() + " canal(es)");
        List<Canal> canales = getCanales();
        for (int indiceCanal = 0; indiceCanal < canales.size(); indiceCanal++) {
            Canal canal = canales.get(indiceCanal);
            System.out.println("- " + canal);
            
            List<Video> videos = canal.getVideos();
            for (int indiceVideo = 0; indiceVideo < videos.size(); indiceVideo++) {
                Video video = videos.get(indiceVideo);
                System.out.println("  - " + video);
                
                List<Comentario> comentarios = video.getComentarios();
                for (int indiceComentario = 0; indiceComentario < comentarios.size(); indiceComentario++) {
                    Comentario comentario = comentarios.get(indiceComentario);
                    System.out.println("    - " + comentario);
                }
            }
        }


    }
// Método para obtener la lista de canales
    public ArrayList<Canal> getCanales() {
        return canales;
    }
    // FUNCION MAIN PARA EJECUTAR EL PROGRAMA
    public static void main(String[] args) {
        Youtube youtube = new Youtube();
        youtube.mostrarMenu();
    }
}