package dad.javafx.enviaremail;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {

	private StringProperty servidor = new SimpleStringProperty();
	private StringProperty remitente = new SimpleStringProperty();
	private StringProperty contrase�a = new SimpleStringProperty();
	private StringProperty destinatario = new SimpleStringProperty();
	private StringProperty asunto = new SimpleStringProperty();
	private StringProperty mensaje = new SimpleStringProperty();
	private IntegerProperty puerto = new SimpleIntegerProperty();
	private BooleanProperty conexion = new SimpleBooleanProperty();
	
	public final StringProperty servidorProperty() {
		return this.servidor;
	}
	
	public final String getServidor() {
		return this.servidorProperty().get();
	}
	
	public final void setServidor(final String servidor) {
		this.servidorProperty().set(servidor);
	}
	
	public final StringProperty remitenteProperty() {
		return this.remitente;
	}
	
	public final String getRemitente() {
		return this.remitenteProperty().get();
	}
	
	public final void setRemitente(final String remitente) {
		this.remitenteProperty().set(remitente);
	}
	
	public final StringProperty contrase�aProperty() {
		return this.contrase�a;
	}
	
	public final String getContrase�a() {
		return this.contrase�aProperty().get();
	}
	
	public final void setContrase�a(final String contrase�a) {
		this.contrase�aProperty().set(contrase�a);
	}
	
	public final StringProperty destinatarioProperty() {
		return this.destinatario;
	}
	
	public final String getDestinatario() {
		return this.destinatarioProperty().get();
	}
	
	public final void setDestinatario(final String destinatario) {
		this.destinatarioProperty().set(destinatario);
	}
	
	public final StringProperty asuntoProperty() {
		return this.asunto;
	}
	
	public final String getAsunto() {
		return this.asuntoProperty().get();
	}
	
	public final void setAsunto(final String asunto) {
		this.asuntoProperty().set(asunto);
	}
	
	public final StringProperty mensajeProperty() {
		return this.mensaje;
	}
	
	public final String getMensaje() {
		return this.mensajeProperty().get();
	}
	
	public final void setMensaje(final String mensaje) {
		this.mensajeProperty().set(mensaje);
	}
	
	public final IntegerProperty puertoProperty() {
		return this.puerto;
	}
	
	public final int getPuerto() {
		return this.puertoProperty().get();
	}
	
	public final void setPuerto(final int puerto) {
		this.puertoProperty().set(puerto);
	}
	
	public final BooleanProperty conexionProperty() {
		return this.conexion;
	}
	
	public final boolean isConexion() {
		return this.conexionProperty().get();
	}
	
	public final void setConexion(final boolean conexion) {
		this.conexionProperty().set(conexion);
	}

}
