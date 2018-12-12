import java.io.*;
import java.net.URL;
import java.util.*;

import javafx.application.Platform;
import javafx.fxml.*;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.TransferMode;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Controller implements Initializable{
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView button_enter;

    @FXML
    private TextField login_field;


    @FXML
    private ListView listview;

    @FXML
    private ImageView exit_button1;

    @FXML
    public void buttonExitClick() {
        Platform.exit();
    }


    @FXML
    private ImageView imageView;
    public void imageViewClick() {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("C:\\Users\\Morty PC\\Desktop"));
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("XL Files!", "*.xlsx"));
        File selectedFile = fc.showOpenDialog(null);

        if (selectedFile!=null){
            //listview.getItems().add(selectedFile.getName());
            Image i = new Image("/images/excel.png");
            imageView.setImage(i);

        }else{
            System.out.println("File not found");
        }
    }
    @FXML
    private void handleDragOver(DragEvent event) {
        if (event.getDragboard().hasFiles()) {
            event.acceptTransferModes(TransferMode.ANY);
        }
    }
    @FXML
    void handleDrop(DragEvent event) throws FileNotFoundException {
        List<File>files = event.getDragboard().getFiles();
        Image file = new Image(new FileInputStream(files.get(0)));
        imageView.setImage(file);
    }
    public void enterLogin()throws IOException{
        String login = login_field.getText();
        if (login_field.getText() == null || login_field.getText().trim().isEmpty()) {
            Alert fail= new Alert(Alert.AlertType.ERROR);
            fail.setTitle("Error!");
            fail.setHeaderText("Login field or file is empty. Please, enter! ");
            fail.showAndWait();
        }
        else {
        Stage stage = (Stage) button_enter.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml_files/main_page.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Другая форма");
        stage.setScene(new Scene(root1));
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());
        stage.setMaximized(true);
        stage.setFullScreen(true);
        /*stage.setOnCloseRequest(event -> {
            //Handle
            event.consume();
        });
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);*/
        stage.show();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}