package dad.javafx.enviaremail;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

	private Controller c;

	public void start(Stage primaryStage) throws Exception {
		c = new Controller();
		Scene scene = new Scene(c.getView(), 600, 400);
		primaryStage.setTitle("Enviar email");
		primaryStage.setScene(scene);
		primaryStage.getIcons().add(new Image("img/email-send-icon-32x32.png"));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}