package gui.exam.WS2020;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.AmbientLight;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Probabilities extends Application {
	private Label nLabel, pLabel;
	private Pane drawingPane;
	private Text indexText, anzeigeText;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		drawingPane = new Pane();
		HBox nControl = new HBox(10);
		Label ln = new Label("n: ");
		ln.setFont(Font.font(null, FontWeight.BOLD, 20));
		nControl.getChildren().add(ln);
		Slider nSlider = new Slider(1, 50, 0);
		nControl.getChildren().add(nSlider);
		nLabel = new Label();
		nLabel.setFont(Font.font(null, FontWeight.BOLD, 20));
		nControl.getChildren().add(nLabel);
		
		HBox pControl = new HBox(10);
		Label lp = new Label("p: ");
		lp.setFont(Font.font(null, FontWeight.BOLD, 20));
		pControl.getChildren().add(lp);
		Slider pSlider = new Slider(0, 1, 0);
		pControl.getChildren().add(pSlider);
		pLabel = new Label();
		pLabel.setFont(Font.font(null, FontWeight.BOLD, 20));
		pControl.getChildren().add(pLabel);
		
		CheckBox poisson = new CheckBox("Poisson");
		poisson.setFont(Font.font(null, FontWeight.BOLD, 20));
		
		VBox controlls = new VBox(10);
		controlls.getChildren().addAll(nControl, pControl, poisson);
		controlls.setPadding(new Insets(10));
		root.setBottom(controlls);
		
		nSlider.valueProperty().addListener((obs, oldValue, newValue) -> {
			update((int) nSlider.getValue(), pSlider.getValue(), poisson.isSelected());
		});
		pSlider.valueProperty().addListener((obs, oldValue, newValue) -> {
			update((int) nSlider.getValue(), pSlider.getValue(), poisson.isSelected());
		});
		poisson.selectedProperty().addListener((obs, oldValue, newValue) -> {
			update((int) nSlider.getValue(), pSlider.getValue(), poisson.isSelected());
		});
		drawingPane.widthProperty().addListener((obs, oldValue, newValue) -> {
			update((int) nSlider.getValue(), pSlider.getValue(), poisson.isSelected());
		});	
		drawingPane.heightProperty().addListener((obs, oldValue, newValue) -> {
			update((int) nSlider.getValue(), pSlider.getValue(), poisson.isSelected());
		});	
		
		
		
		root.setCenter(drawingPane); // zeichenflaeche adden
		
		primaryStage.setTitle("REFERENZ");
		primaryStage.setScene(new Scene(root, 900, 600));
		primaryStage.show();
		
		// setzen der Default-Werte damit die Balken nach Start direkt sichtbar sind
		nSlider.setValue(10);
		pSlider.setValue(0.5);
		poisson.setSelected(false);
	}

	
	
	private void update(int n, double p, boolean poisson) {
		drawingPane.getChildren().clear(); // wichtig jedes mal DrawingPane löschen und neu zeichnen
		// TODO Auto-generated method stub
		p = ((int) (p*1000)) / 1000.00;
		nLabel.setText("n = " + n);
		pLabel.setText("p = " + p);
		double[] binomProbs = Computation.computeBinomProbs(n, p);
		double[] poissonProbs = Computation.computePoissonProbs(n, p);
		
		int numRect = binomProbs.length; // Anzahl der rectangles // geht vllt auch einfach mit n
		
		double effDrawHeight = drawingPane.getHeight() - 60; // maximale zeichen Hoehe minus oben 30px sowie unten 30px padding
		double effDrawWidth = drawingPane.getWidth() - 60;  // maximale zeichen Breite minus links 30px sowie rechts 30px padding
		
		double widthRectangle = (effDrawWidth - (4 * (numRect-1))) / numRect; // die verfügbare zeichenbreite minus anzahl rectangle * 4px padding = tatsächliche verfügbare flaeche durch anzahl der zu zeichnenden rectangles
		
		for(int i = 0; i < numRect; i++) {
			final int finalIndex = i;
			double xPos = 30 + ((4+ widthRectangle) * i);
			double yPos = drawingPane.getHeight() - 30;
			double h = effDrawHeight * binomProbs[i]; // die verfügbare zeichenhoehe mal den array wert an index i (werte zwischen 0 und 1) wobei 1 die Maximale Hoehe
			System.out.println(binomProbs[i]);
			Rectangle rectangleBinom = new Rectangle(xPos, yPos - h, widthRectangle, h); // hier ist zu beachten das der Ausrichtungspunkt des Rectangles sich Oben Links befindet daher um Minus die Höhe nach oben verschieben
			indexText = new Text(String.valueOf(i));
			indexText.setTextOrigin(VPos.TOP);
			// Hier wird auf die XPosition 30 padding fest von Links Rectangles Anzahl * den Space 4 und Rectangle Anzahl * die Breite der Rectangles 30+4|4|4| + |<-Text->| <-- 1/2 Breite des Rectangles
			indexText.setX(30 + i * 4 + i * widthRectangle +  widthRectangle / 2 - indexText.getBoundsInLocal().getWidth() / 2); // setzt den Text mittig unter das Rectangle text wird oben links Zentriert daher nochmal - die halbe Textbreite rechnen
			indexText.setY(yPos);
			drawingPane.getChildren().add(rectangleBinom);
			drawingPane.getChildren().add(indexText);
			
			anzeigeText = new Text();
			anzeigeText.setX(effDrawWidth / 2 - anzeigeText.getBoundsInLocal().getWidth() / 2);
			anzeigeText.setY(0);
			anzeigeText.setTextOrigin(VPos.TOP); // bei Text beginnt die Ausrichtung unten Links somit Text Origin auf Top setzen, sonst ist er bei y = 0 nicht sichtbar
			
			rectangleBinom.setOnMouseEntered(e -> {
				anzeigeText.setText("Binom("+finalIndex+")"+" = " + binomProbs[finalIndex]);
				this.drawingPane.getChildren().add(anzeigeText);
				System.out.println("Entered Binom");
			});
			rectangleBinom.setOnMouseExited(e -> {
				System.out.println("Exit Binom");
				drawingPane.getChildren().remove(anzeigeText);
			});
			Line mittelwert = new Line(30 + (p *effDrawWidth), yPos, 30 + (p *effDrawWidth), 30);
			mittelwert.setStroke(Color.RED);
			mittelwert.setStrokeWidth(4);
			
			drawingPane.getChildren().add(mittelwert);
			
			if (poisson) {
				h = poissonProbs[i] * effDrawHeight;
				double widthGreenRectangle = widthRectangle / 3;
				Rectangle rectanglePoisson = new Rectangle(xPos + (widthRectangle / 2) - widthGreenRectangle / 2, yPos - h, widthGreenRectangle, h);
				rectanglePoisson.setFill(Color.LIGHTGREEN);
				rectanglePoisson.setOnMouseEntered(e -> {
					System.out.println("Entered Poisson");
					anzeigeText.setText("Poisson("+finalIndex+")"+" = " + poissonProbs[finalIndex]);
					this.drawingPane.getChildren().add(anzeigeText);
				}); 
				rectanglePoisson.setOnMouseExited(e -> {
					System.out.println("Exit Poisson");
					drawingPane.getChildren().remove(anzeigeText);
				}); 
				drawingPane.getChildren().add(rectanglePoisson);
			}
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
