# Minesweeper Game

**Name**: Clarisse CARVALHO

**Subject**: PSI


## Project Overview
Minesweeper is a classic logic-based game where players reveal cells on a grid while avoiding hidden mines. The goal is to uncover all safe cells and correctly flag all mines. This project implements an interactive version using JavaFX, with additional features like power-ups, custom settings, and gameplay aids.

## Features

- [ ] **Window & Layout**
  - [✓] Create main window
  - [✓] Add menu bar / control panel
  - [✓] Define layout using JavaFX panes 

- [ ] **UI Elements**
  - [ ] Buttons (New Game, Reset, Help, Custom Settings)
  - [ ] Labels (Mines counter, Timer, Score)
  - [ ] Input fields / options for custom settings

- [ ] **Grid System**
  - [ ] Implement cell class (state: covered, revealed, flagged, mined)
  - [✓] Handle left-click (reveal cell)
  - [ ] Handle right-click (flag cell)
  - [✓] Update adjacent mine counts
  - [ ] Add power-up cell logic

- [ ] **Game Mechanics**
  - [✓] Randomly place mines
  - [✓] Calculate numbers around mines
  - [✓] Implement recursive reveal for empty cells
  - [✓] Detect Game Over
  - [✓] Detect Winning condition

- [ ] **Custom Settings**
  - [ ] Adjustable grid size (9x9, 16x16, 16x32)
  - [ ] Adjustable mine density (Easy, Medium, Hard)
  - [ ] Limited flags mode
  - [ ] Limited time mode

- [ ] **Additional Features**
  - [ ] Help button (reveal one bomb)
  - [ ] Power-up cells that reveal adjacent safe cells
  - [✓] Game Over and Winning messages

## Installation

**Prerequisites**
- Java Development Kit (JDK)
- JavaFX SDK
- Eclipse IDE
- (Optional) Scene Builder

**Project Setup**
1. Open Eclipse and go to `File > Import...`.
2. Select `Git > Projects from Git` and click `Next`.
3. Choose `Clone URI` and click `Next`.
4. Enter the repository URI:  
   `https://github.com/MitsukiS16/PUIO_PIS.git`  
   then click `Next` and `Finish`.

**Configuring JavaFX**
- Add the JavaFX `lib` folder to your project’s build path  
  (`Project > Properties > Java Build Path > Add External JARs`).
- Create a Run Configuration for the project (`Run > Run Configurations...`).  
  Set `Main.java` as the main class.
- In the VM arguments field, add:  
  `--add-modules=javafx.controls,javafx.fxml`

**Running the Project**
- After importing and configuring JavaFX, run the project directly from Eclipse.
- The main window of the Minesweeper game will launch automatically.

## Usage
- Left-click on a cell to reveal it
- Right-click to flag a suspected mine
- Use control buttons to start a new game, reset, or access custom settings

## Architecture & Implementation
- **Front-end:** JavaFX GUI built with `Scene`, `Stage`, and layout panes
- **Game Logic:** Handles mine placement, cell states, flagging, scoring, and timer
- **Key Classes:**
  - `Main.java` – Entry point; initializes JavaFX application and loads the main scene
  - `Grid.java` – Manages the grid and generates the board
  - `Cell.java` – Represents individual cells (covered, revealed, flagged, mined)
  - `GameController.java` – Controls game flow, events, and user interactions
  - (Optional) `.fxml` files – Define UI layout (if using FXML + Scene Builder)

## Screenshots
![Screenshot](screenshot1.png)

## Known Limitations
- Limited grid sizes
- Only single-player mode
- No save/load game functionality
- Simple power-up types
