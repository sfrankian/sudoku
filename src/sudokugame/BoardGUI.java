package sudokugame;

import javax.swing.GroupLayout.Alignment;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

public class BoardGUI extends Application {
	Board gameBoard = new Board("assets/sudokugrid.txt");
	
	//TODO add TextFormatter so that we can reject input that isn't digits 1-9
	//And to limit length of the textfield to one char
	// Could do this by making child class of TextField that limits entry
	public static Border createBorder() {
	    return new Border(
	            new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
	            new CornerRadii(0), BorderStroke.THIN));
	}
	
	public static Background changeBgColor() {
		return new Background(new BackgroundFill(Color.LIGHTGREY, null, null));
	}
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Sudoku game");
		
		GridPane grid = new GridPane();
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0 ; j < 9 ; j++) {
				int valAtXY = gameBoard.getValAtXY(i, j);
				
				TextField oneBox;
				Shape boxShape = new Rectangle();
				
				if( valAtXY != 0) {
					String currValAsString = String.valueOf(valAtXY);
					oneBox = new TextField(currValAsString);
					oneBox.setEditable(false);
					oneBox.setBackground(changeBgColor());
				}
				else {
					// Must be an empty box that will be user-filled
					oneBox = new TextField();
				}
				oneBox.setBorder(createBorder());
				//oneBox.setShape(boxShape);
				grid.add(oneBox, i, j);
			}
		}	
		
		Scene scene = new Scene(grid, 400,300); 
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
