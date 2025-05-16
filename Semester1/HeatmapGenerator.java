import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Map;

public class HeatmapGenerator extends Application {
    private static Map<String, Double> pollutionData;

    public static void setPollutionData(Map<String, Double> data) {
        pollutionData = data;
    }

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(400, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        drawHeatmap(gc);

        primaryStage.setTitle("Air Quality Heatmap");
        primaryStage.setScene(new Scene(new javafx.scene.layout.StackPane(canvas), 500, 500));
        primaryStage.show();
    }

    private void drawHeatmap(GraphicsContext gc) {
        gc.clearRect(0, 0, 400, 400);

        double pm25 = pollutionData.getOrDefault("pm2_5", 0.0);
        double pm10 = pollutionData.getOrDefault("pm10", 0.0);
        double no2 = pollutionData.getOrDefault("no2", 0.0);
        double so2 = pollutionData.getOrDefault("so2", 0.0);

        double maxPollution = Math.max(Math.max(pm25, pm10), Math.max(no2, so2));

        // Draw different colored rectangles based on pollution levels
        gc.setFill(getColorBasedOnValue(pm25, maxPollution));
        gc.fillRect(50, 50, 100, 100);
        gc.setFill(getColorBasedOnValue(pm10, maxPollution));
        gc.fillRect(200, 50, 100, 100);
        gc.setFill(getColorBasedOnValue(no2, maxPollution));
        gc.fillRect(50, 200, 100, 100);
        gc.setFill(getColorBasedOnValue(so2, maxPollution));
        gc.fillRect(200, 200, 100, 100);
    }

    private Color getColorBasedOnValue(double value, double max) {
        double ratio = value / max;
        return Color.color(ratio, 0.0, 1.0 - ratio);  // Blue to red gradient
    }

    public static void main(String[] args) {
        launch(args);
    }
}
