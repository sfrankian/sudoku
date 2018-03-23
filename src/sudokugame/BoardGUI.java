package sudokugame;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
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
	
	public static Border createBorder() {
	    return new Border(
	            new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
	            new CornerRadii(3), BorderStroke.THICK));
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
				}
				else {
					// Must be an empty box that will be user-filled
					oneBox = new TextField();
				}
				oneBox.setShape(boxShape);
				oneBox.setBorder(createBorder());
				grid.add(oneBox, i, j);
			}
		}	
		
		Scene scene = new Scene(grid, 400, 500); 
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
