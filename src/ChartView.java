import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChartView extends Application {


    String login1 = "Ula";
    String login2 = "Zeal";
    DataModel data1 = new DataModel(login1);
    DataModel data2 = new DataModel(login2);
    public double Sum;
    public double Odd;

    @Override
    public void start(Stage stage) {
        data1.getSize();
        data1.getBet();
        data2.getSize();
        data2.getBet();
        if (data1.sum >= data2.sum && (data1.odd >= data2.odd || data1.odd <= data2.odd)){
            Sum = data1.sum + (data1.sum/5);
            Odd = data1.odd + (data1.odd/5);
        } else {
            Sum = data2.sum + (data2.sum/5);
            Odd = data2.odd + (data2.odd/5);
        }
        stage.setTitle("Solo 322");
        final NumberAxis xAxis = new NumberAxis(0, Odd, (Odd / 20));
        final NumberAxis yAxis = new NumberAxis(0, Sum, (Sum / 20));
        final ScatterChart<Number,Number> sc = new ScatterChart<>(xAxis,yAxis);
        xAxis.setLabel("Coefficient");
        yAxis.setLabel("Sum");
        sc.setTitle("Rate overview");

        XYChart.Series series1 = new XYChart.Series();

        series1.setName("Bet");

        for (int i = 0; i < data1.total_strake.size(); i++){
            series1.getData().add(new XYChart.Data(data1.odds.get(i), data1.total_strake.get(i)));
        }
        for (int i = 0; i < data2.total_strake.size(); i++){
            series1.getData().add(new XYChart.Data(data2.odds.get(i), data2.total_strake.get(i)));
        }

        sc.setPrefSize(800, 500);
        sc.getData().addAll(series1);
        Scene scene  = new Scene(new Group());
        final VBox vbox = new VBox();
        final HBox hbox = new HBox();

        final Button add = new Button("Add rate");
        final Button remove = new Button("Delete rate");

        hbox.setSpacing(10);
        hbox.getChildren().addAll(add, remove);

        vbox.getChildren().addAll(sc, hbox);
        hbox.setPadding(new Insets(10, 10, 10, 50));

        ((Group)scene.getRoot()).getChildren().add(vbox);
        stage.setScene(scene);
        stage.show();
    }
}