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

public class ControllerMain {

    @FXML
    private AreaChart<?, ?> AreaChart;

    @FXML
    private ScatterChart<?, ?> ScatterChart;

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



    public double Sum;
    public double Odd;

    @FXML
    void initialize() {
        //AREA CHART
        XYChart.Series setl=new XYChart.Series<>();
        setl.getData().add(new XYChart.Data(10, 5000));
        setl.getData().add(new XYChart.Data(20, 6000));
        setl.getData().add(new XYChart.Data(30, 1000));
        setl.getData().add(new XYChart.Data(40, 4000));
        setl.getData().add(new XYChart.Data(50, 2000));
        setl.getData().add(new XYChart.Data(60, 3000));
        AreaChart.getData().add(setl);

        //SCATTER CHART
        XYChart.Series set2=new XYChart.Series<>();
        set2.getData().add(new XYChart.Data(10, 5000));
        set2.getData().add(new XYChart.Data(20, 6000));
        set2.getData().add(new XYChart.Data(30, 1000));
        set2.getData().add(new XYChart.Data(40, 4000));
        set2.getData().add(new XYChart.Data(50, 2000));
        set2.getData().add(new XYChart.Data(60, 3000));
        ScatterChart.getData().add(set2);
/*

        Controller c = new Controller();
        System.out.println(c.getLogin());
        DataModel data = new DataModel(c.getLogin());
        data.getSize();
        data.getBet();
        Sum = data.sum + (data.sum/5);
        Odd = data.odd + (data.odd/5);

        //AREA CHART
        for (int i = 0; i <= data.odds.size(); i++){
            setl.getData().add(new XYChart.Data(data.odds.get(i), data.total_strake.get(i)));
        }
        AreaChart.getData().addAll(setl);

        //SCATTER CHART
        for (int i = 0; i <= data.odds.size(); i++){
            set2.getData().add(new XYChart.Data(data.odds.get(i), data.total_strake.get(i)));
        }
        ScatterChart.getData().addAll(set2);
*/  }
}