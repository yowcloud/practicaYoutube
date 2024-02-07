package youtube;

import java.time.LocalDate;

public class Comentario {
    private String contenido;
    private LocalDate fecha;
    private int likes;
    private String usuario;

    public Comentario(String contenido, LocalDate fecha, int likes, String usuario) {
        this.contenido = contenido;
        this.fecha = fecha;
        this.likes = likes;
        this.usuario = usuario;
    }
	// Getter para obtener el contenido del comentario
	public String getContenido() {
        return contenido;
    }
    // Getter para obtener la fecha del comentario	
    public LocalDate getFecha() {
        return fecha;
    }
// Getter para obtener la cantidad de likes del comentario
    public int getLikes() {
        return likes;
    }
    // Getter para obtener el usuario que hizo el comentario
    public String getUsuario() {
        return usuario;
    }

    // Sobreescritura del método toString() 
    @Override
	public String toString() {
    	String contenidoSinSaltosDeLinea = contenido.replace("\n", " ");
    	return "- Comentario: \"" + contenidoSinSaltosDeLinea + "\" del usuario: " + usuario + " en fecha: " + fecha;
	}

}
