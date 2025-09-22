package application;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Controller {
	
	// INIT VARIABLES
	
    @FXML private GridPane gridPane;

    private int rows = 9;
    private int cols = 9;
    private int totalMines = 10;
    private int revealedCells = 0;
    private Cell[][] cells;
    
    // INIT FUNCTIONS 
    
    @FXML
    public void initialize() {
    	newGame(); 
    }

    @FXML
    private void handleNewGame() {
        newGame();
    }
   
    // MAIN FEATURES

    // CREATE A NEW GAME
    private void newGame() {
    	gridPane.getChildren().clear();
        revealedCells = 0;
        cells = new Cell[rows][cols];

        // CREATE A NEW GRID OF CELLS
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Cell cell = new Cell(i, j);
                cell.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                GridPane.setHgrow(cell, Priority.ALWAYS);
                GridPane.setVgrow(cell, Priority.ALWAYS);

                // HANDLER FOR INTERACTION WITH CELL
                cell.setOnMouseClicked(event -> revealCell(cell));
                gridPane.add(cell, j, i);
                cells[i][j] = cell;
            }
        }

        placeMines();
        calculateAdjacentMines();
    }

    // SETTING UP RANDOMLY THE MINES
    private void placeMines() {
        int placedMines = 0;
        while (placedMines < totalMines) {
            int r = (int) (Math.random() * rows);
            int c = (int) (Math.random() * cols);

            if (!cells[r][c].isMine()) {
                cells[r][c].setMine(true);
                placedMines++;
            }
        }
    }

    // CALCULATE EACH NUMBER TO APPEAR
    private void calculateAdjacentMines() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!cells[i][j].isMine()) {
                    int nMines = 0;
                    // CHECK 8 ADJACENT CELLS 
                    for (int x = i - 1; x <= i + 1; x++) {
                        for (int y = j - 1; y <= j + 1; y++) {
                            if (x >= 0 && x < rows && y >= 0 && y < cols && cells[x][y].isMine()) {
                                nMines++;
                            }
                        }
                    }
                    cells[i][j].setAdjacentMines(nMines);
                }
            }
        }
    }

    // WHEN CLICK ON A CELL: REVEAL CELL: BOMB OR NUMBER OR SPACE
    private void revealCell(Cell cell) {
        if (cell.isRevealed()) return;

        cell.setRevealed(true);
        revealedCells++;
        
        // IF USER CLICKER ON A BOMB
        if (cell.isMine()) {
            cell.setText("⚫");
            cell.setStyle("-fx-background-color: red;");
            gameOver(false); 
        // IF USER DIDNT CLICK ON A BOMB
        } else {
            cell.setStyle("-fx-background-color: white;");
            int count = cell.getAdjacentMines();
            if (count > 0) {
                cell.setText(String.valueOf(count));
            } else {
            	// CREATE EMPTY CELLS
                for (int i = cell.getRow() - 1; i <= cell.getRow() + 1; i++) {
                    for (int j = cell.getCol() - 1; j <= cell.getCol() + 1; j++) {
                        if (i >= 0 && i < rows && j >= 0 && j < cols) {
                            revealCell(cells[i][j]);
                        }
                    }
                }
            }
            checkWinCondition();
        }
    }
    
    private void checkWinCondition() {
        if (revealedCells == (rows * cols - totalMines)) {
            gameOver(true);
        }
    }

    private void gameOver(boolean won) {
        // REVEAL ALL MINES
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                cell.setDisable(true);
                if (cell.isMine()) {
                    cell.setText("⚫");
                    cell.setStyle(won ? "-fx-background-color: lightgreen;" : "-fx-background-color: red;");
                }
            }
        }
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText(won ? "You win! :)" : "You lose. :(");
        alert.showAndWait();
    }
    
    // OTHER FEATURES TO IMPLEMENT
    
    @FXML
    private void handleReset() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Reset Button");
        alert.setHeaderText(null);
        alert.setContentText("This feature is not yet implemented.");
        alert.showAndWait();
    }

    @FXML
    private void handleHelp() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Help Button");
        alert.setHeaderText(null);
        alert.setContentText("This feature is not yet implemented.");
        alert.showAndWait();
    }

    @FXML
    private void handleCustom() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Custom Settings");
        alert.setHeaderText(null);
        alert.setContentText("This feature is not yet implemented.");
        alert.showAndWait();
    }
}
