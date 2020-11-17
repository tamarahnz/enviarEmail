package dad.javafx.enviaremail;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.util.converter.NumberStringConverter;

public class Controller implements Initializable {
	
	//view
    @FXML
    private BorderPane view;

    @FXML
    private Button enviarBt;

    @FXML
    private Button vaciarBt;

    @FXML
    private Button cerrarBt;

    @FXML
    private TextField servidorTf;

    @FXML
    private TextField puertoTf;

    @FXML
    private CheckBox conexionCb;

    @FXML
    private TextField remitenteTf;

    @FXML
    private PasswordField contraseñaPf;

    @FXML
    private TextField destinatarioTf;

    @FXML
    private TextField asuntoTf;

    @FXML
    private TextArea mensajeTa;
	
	//model
    private Model model = new Model();
    
	public Controller() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Ver.fxml"));
		loader.setController(this);
		loader.load();
	}

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Bindings.bindBidirectional(model.servidorProperty(), servidorTf.textProperty());		
		Bindings.bindBidirectional(model.remitenteProperty(), remitenteTf.textProperty());
		Bindings.bindBidirectional(model.contraseñaProperty(), contraseñaPf.textProperty());
		Bindings.bindBidirectional(model.destinatarioProperty(), destinatarioTf.textProperty());
		Bindings.bindBidirectional(model.asuntoProperty(), asuntoTf.textProperty());
		Bindings.bindBidirectional(model.mensajeProperty(), mensajeTa.textProperty());
		Bindings.bindBidirectional(puertoTf.textProperty(), model.puertoProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(model.conexionProperty(), conexionCb.selectedProperty());
	}
	
	@FXML
    void onActionCerrar(ActionEvent event) {
    	Platform.exit();
    }

    @FXML
    void onActionEnviar(ActionEvent event) {
    	Email email = new SimpleEmail();
		
		try {
			email.setHostName(model.getServidor());
			email.setSmtpPort(model.getPuerto());
			email.setAuthenticator(new DefaultAuthenticator(model.getRemitente(), model.getContraseña()));
			email.setSSLOnConnect(model.isConexion());		
			email.setFrom(model.getRemitente());
			email.setSubject(model.getAsunto());
			email.setMsg(model.getMensaje());
			email.addTo(model.getDestinatario());			
			email.send();
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Mensaje enviado");
			alert.setHeaderText("Mensaje enviado con éxito a '" + model.getDestinatario() + "'");			

			alert.showAndWait();
		} catch (EmailException e) {			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("No se pudo enviar el email.");
			alert.setContentText(e.getLocalizedMessage());

			alert.showAndWait();
			
			e.printStackTrace();
		}
    }

    @FXML
    void onActionVaciar(ActionEvent event) {
    	model.setServidor("");
    	model.setRemitente("");
    	model.setContraseña("");
    	model.setDestinatario("");
    	model.setAsunto("");
    	model.setMensaje("");
    	model.setPuerto(0);
    	model.setConexion(false);
    }
	
	public BorderPane getView() {
		return view;
	}

	public void setView(BorderPane view) {
		this.view = view;
	}

}