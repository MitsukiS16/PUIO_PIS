package application;

import javafx.scene.control.Button;
import javafx.scene.layout.Region;

public class Cell extends Button {

	// PROPERTIES
    private final int row;
    private final int col;
    private boolean isMine;
    private boolean isRevealed;
    private int adjacentMines;

    // CELL CONSTRUCTOR
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.isMine = false;
        this.isRevealed = false;
        this.adjacentMines = 0;
        
        setMinSize(50, 50);
        setMaxSize(50, 50);
        //setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        //setStyle("-fx-background-color: #A0A0A0; -fx-border-color: #808080; -fx-border-width: 2px;");
        setStyle("-fx-background-color: #A0A0A0; -fx-border-color: #808080; -fx-border-width: 2px; -fx-alignment: center;");

    }
    
    
    public void rotateTextHorizontal() {
        this.applyCss();
        var textNode = this.lookup(".text");
        if (textNode != null) {
            textNode.setRotate(-45);
        }
    }


    
    
    // integer property and other types of property -> check it out

    // GETTER AND SETTERS
    
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isMine() {
        return isMine;
    }

    public boolean isRevealed() {
        return isRevealed;
    }
    
    public int getAdjacentMines() {
        return adjacentMines;
    }
    
    public void setMine(boolean mine) {
        isMine = mine;
    }

    public void setRevealed(boolean revealed) {
        isRevealed = revealed;
        if (revealed) {
            this.setDisable(true);
        }
    }

    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }
}
