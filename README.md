# ❌⭕ TicTacToe ⭕❌

## 📝 Content

The following repository contains an implementation of the _Tic-Tac-Toe_ game in Java, utilizing the Swing and AWT libraries. The game is created within a single class called _KolkoKrzyzyk_, which implements the **ActionListener** interface.

### 🧩 Component Initialization:

- The game uses **JFrame** as the main window, as well as **JPanel** for the title and buttons.
- Informational text is displayed using **JLabel**.
- The game buttons are represented by a **JButton** array of size 9, corresponding to a 3x3 grid in _Tic-Tac-Toe_.

### 🔧 Constructor:

The _KolkoKrzyzyk_ constructor configures the main game window, setting properties like size, background color, and layout of elements.
Buttons are initialized, configured, and added to the button panel.
The **firstTurn()** method is called to randomly choose which player starts.

### ✋  Event Handling:

The **actionPerformed()** method defines the game logic after a button is pressed. It checks which player's turn it is, updates the state of the button, and switches turns.

### 🎲 Game Logic:

The **check()** method verifies the winning conditions for both players.
In the event of a player's victory, the relevant buttons are highlighted, and the game ends.


### 🎖️ Victory:

The **xWins()** and **oWins()** methods are invoked when one of the players wins. They change the color of the winning buttons and display a victory message.

## 🎮 How run the game

### 📁 Downloading the repository

1. Install Git on your computer (if you haven't already).
2. Open the terminal (Git Bash for Windows, standard terminal for macOS/Linux).
3. Type in the terminal: `https://github.com/WiolaWysopal/TicTacToe.git`.

### 🕹️ Running the game

1. Launch your IDE (e.g., IntelliJ IDEA, Visual Studio Code).
2. Open or import the downloaded game repository.
3. Ensure you have Java installed and configured in the IDE.
4. Find the main game file (e.g., `Main`) in the project.
5. Run project using _Run_ option (or similar).

### 🏆 Sample gameplay
