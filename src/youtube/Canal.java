package youtube;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Canal {
	private String nombre;
    private String fechaCreacion;
    private ArrayList<Video> videos;
    private Scanner scanner;

    public Canal(String nombre, String fechaCreacion) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.videos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Getter para obtener el nombre del canal
    public String getNombre() {
        return nombre;
    }
    // Getter para obtener la fecha de creación del canal
    public String getFechaCreacion() {
        return fechaCreacion;
    }
    // Getter para obtener la lista de videos del canal
    public ArrayList<Video> getVideos() {
        return videos;
    }

    // Método para mostrar el menú del canal
	public void mostrarMenuCanal() {
		boolean continuar = true;
	
		while (continuar) {
			System.out.println("| - - - " + nombre + " - - - |");
			System.out.println("1 - Nuevo video");
			System.out.println("2 - Seleccionar video");
			System.out.println("3 - Mostrar estadísticas");
			System.out.println("4 - Mostrar info videos");
			System.out.println("0 - Salir");
			System.out.println("|- - - - - - - - - - -|");
			System.out.print("Selecciona una opción: ");
			
			int opcion = scanner.nextInt();
	
			switch (opcion) {
				case 1:
					nuevoVideo();
					break;
				case 2:
					seleccionarVideo();
					break;
				case 3:
					mostrarEstadisticas();
					break;
				case 4:
					mostrarInfoVideos();
					break;
				case 0:
					System.out.println("Saliendo...");
					continuar = false; 
					break;
				default:
					System.out.println("Opción no válida. Por favor, intente de nuevo.");
			}
		}
	}
	
    // Método para agregar un nuevo video al canal
    private void nuevoVideo() {
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Introduce el título del nuevo video: ");
        String titulo = scanner.nextLine();
        Video nuevoVideo = new Video(titulo, LocalDate.now(), 0);
        videos.add(nuevoVideo);
        System.out.println("Video agregado con éxito.");
    }

    // Método para seleccionar un video existente del canal
	private void seleccionarVideo() {
		if (videos.isEmpty()) {
			System.out.println("No hay videos en este canal.");
		} else {
			System.out.println("Selecciona el Video:");
			for (int i = 0; i < videos.size(); i++) {
				Video video = videos.get(i);
				System.out.println(i + " - " + "Video: \"" + video.getTitulo() + "\" en fecha: " + video.getFechaPublicacion() + " con " + video.getLikes() + " likes y " + video.getComentarios().size() + " comentario(s)");
			}
			System.out.print("Número del video: ");
			int indice = scanner.nextInt();
			if (indice >= 0 && indice < videos.size()) {
				Video videoSeleccionado = videos.get(indice);
				System.out.println("Video seleccionado:");
				System.out.println("  - " + videoSeleccionado);
				videoSeleccionado.mostrarMenu();
			} else {
				System.out.println("Selección no válida.");
			}
		}
	}


    // Método para mostrar las estadísticas del canal
    private void mostrarEstadisticas() {
        System.out.println("El canal \"" + nombre + "\" tiene " + videos.size() + " video(s).");
    }

    // Método para mostrar información detallada de los videos del canal
	private void mostrarInfoVideos() {
		if (videos.isEmpty()) {
			System.out.println("No hay videos en este canal.");
		} else {
			System.out.println("Videos en el canal \"" + nombre + "\":");
			for (int i = 0; i < videos.size(); i++) {
				Video video = videos.get(i);
				System.out.println(video);
			}
		}
	}
	// Sobreescritura del método toString() 
	@Override
	public String toString() {
		return "Nombre del canal: " + nombre + " creado en fecha: " + fechaCreacion + " con " + videos.size() + " videos";
	}

}
