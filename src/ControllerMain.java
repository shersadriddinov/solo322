import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class ControllerMain{

    @FXML
    public String login;

    public ControllerMain(){};
    public ControllerMain(String login){
        this.login = login;
    }
    @FXML
    public AreaChart<?, ?> AreaChart;

    @FXML
    public ScatterChart<?, ?> ScatterChart;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private NumberAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    private NumberAxis ys;

    @FXML
    private NumberAxis xs;

    @FXML
    public void buttonExitClick(ActionEvent actionEvent) {
        Platform.exit();
    }

    @FXML
    public void setLogin(String login){
        this.login = login;
    }
    @FXML
    public void initialize(){
        System.out.println(this.login);
        DataModel data = new DataModel(this.login);
        data.getBet();
        //AREA CHART
        XYChart.Series setl = new XYChart.Series<>();
        for (int i = 0; i < data.odds.size(); i++) {
            setl.getData().add(new XYChart.Data(data.odds.get(i), data.total_strake.get(i)));
        }
        AreaChart.getData().add(setl);

        //SCATTER CHART
        XYChart.Series set2 = new XYChart.Series<>();
        for (int i = 0; i < data.odds.size(); i++) {
            set2.getData().add(new XYChart.Data(data.odds.get(i), data.total_strake.get(i)));
        }
        ScatterChart.getData().add(set2);
    }
}