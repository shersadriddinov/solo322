import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class ControllerMain extends Controller{

    @FXML
    private AreaChart<?, ?> AreaChart;

    @FXML
    private ScatterChart<?, ?> ScatterChart;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    private NumberAxis ys;

    @FXML
    private CategoryAxis xs;

    public double Sum;
    public double Odd;
    @FXML
    void initialize() {
        DataModel data = new DataModel("Faha");
        data.getSize();
        data.getBet();
        Sum = data.sum + (data.sum/5);
        Odd = data.odd + (data.odd/5);

        //AREA CHART
        XYChart.Series setl = new XYChart.Series<>();
        for (int i = 0; i <= data.odds.size(); i++){
            setl.getData().add(new XYChart.Data(data.odds.get(i), data.total_strake.get(i)));
        }
        AreaChart.getData().addAll(setl);

        //SCATTER CHART
        XYChart.Series set2 = new XYChart.Series<>();
        for (int i = 0; i <= data.odds.size(); i++){
            set2.getData().add(new XYChart.Data(data.odds.get(i), data.total_strake.get(i)));
        }
        ScatterChart.getData().addAll(set2);
    }
}