package youtube;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Video {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";

	private String titulo;
    private LocalDate fechaPublicacion;
    private int likes;
    private ArrayList<Comentario> comentarios;
    private Scanner scanner;

    public Video(String titulo, LocalDate fechaPublicacion, int likes) {
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.likes = likes;
        this.comentarios = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Getter para obtener el título del video
    public String getTitulo() {
        return titulo;
    }
    // Getter para obtener la fecha de publicación del video
    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }
    // Getter para obtener la cantidad de likes del video
    public int getLikes() {
        return likes;
    }
    // Getter para obtener la lista de comentarios del video
    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }
    // Método para agregar un comentario al video
    public void agregarComentario(Comentario comentario) {
        comentarios.add(comentario);
    }

    // Método para mostrar el menú de opciones del video
	public void mostrarMenu() {
		boolean continuar = true;
	
		while (continuar) {
			System.out.println("|----------------" + titulo + "------------------|");
			System.out.println("1) Nuevo Comentario");
			System.out.println("2) Like");
			System.out.println("3) Mostrar Comentarios");
			System.out.println("4) Mostrar estadísticas completas");
			System.out.println("0) Salir");
			System.out.println("|---------------------------------------|");
			System.out.print("Selecciona una opción: ");
			int opcion = scanner.nextInt();
	
			switch (opcion) {
				case 1:
					agregarComentario();
					break;
				case 2:
					incrementarLikes();
					break;
				case 3:
					mostrarComentarios();
					break;
				case 4:
					mostrarEstadisticasCompletas();
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
	
    // Método para mostrar estadísticas completas del video
    private void mostrarEstadisticasCompletas() {
		System.out.println("Video: \"" + titulo + "\" en fecha: " + fechaPublicacion + " con " + likes + " likes y " + comentarios.size() + " comentarios");
	}

	// Método para agregar un nuevo comentario y nombre de usuario
	private void agregarComentario() {
		scanner.nextLine(); // Limpiar buffer
		System.out.println("Introduce comentario y nombre de usuario:");
		System.out.print("Comentario: ");
		String contenido = scanner.nextLine();
		System.out.print("Nombre de usuario: ");
		String nombreUsuario = scanner.nextLine();
		String comentarioCompleto = contenido + "\n" + nombreUsuario;
		Comentario nuevoComentario = new Comentario(comentarioCompleto, LocalDate.now(),0, nombreUsuario); // la seccion likes lo inializamos a 0
		comentarios.add(nuevoComentario);
		System.out.println("Comentario agregado con éxito. ✅");
	}


    // Método para incrementar el contador de likes del video y que sea rojo
    private void incrementarLikes() {
        likes++;
		System.out.println(ANSI_RED + "ME GUSTA" + ANSI_RESET);

    }

    // Método para mostrar los comentarios del video
	private void mostrarComentarios() {
		if (comentarios.isEmpty()) {
			System.out.println("No hay comentarios en este vídeo.");
		} else {
			System.out.println("Comentarios del vídeo \"" + titulo + "\":");
			for (int i = 0; i < comentarios.size(); i++) {
				Comentario comentario = comentarios.get(i);
				String[] parts = comentario.getContenido().split("\n");
				String contenidoComentario = parts[0];
				String nombreUsuario = parts[1];
				System.out.println("Comentario: \"" + contenidoComentario + "\" del usuario: " + nombreUsuario + " en fecha: " + comentario.getFecha());
			}
			
		}
	}


    // Sobreescritura del método toString()
    @Override
    public String toString() {
        return "Vídeo: \"" + titulo + "\" en fecha: " + fechaPublicacion + " con " + likes + " Likes y " + comentarios.size() + " comentarios.";
    }
}