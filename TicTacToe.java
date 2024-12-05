import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    private boolean isXTurn = true; // Tracks the current player
    private Button[][] buttons = new Button[3][3]; // The game board

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        // Initialize buttons
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button button = new Button();
                button.setPrefSize(100, 100);
                button.setStyle("-fx-font-size: 24");
                final int r = row;
                final int c = col;
                button.setOnAction(e -> handleButtonClick(r, c));
                buttons[row][col] = button;
                grid.add(button, col, row);
            }
        }

        Button resetButton = new Button("Reset");
        resetButton.setOnAction(e -> resetGame());
        VBox vbox = new VBox(10, grid, resetButton);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 400, 400);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleButtonClick(int row, int col) {
        if (!buttons[row][col].getText().isEmpty()) {
            return; // Ignore if button is already clicked
        }

        buttons[row][col].setText(isXTurn ? "X" : "O");
        if (checkWin()) {
            showAlert((isXTurn ? "X" : "O") + " Wins!");
            return;
        }

        if (isBoardFull()) {
            showAlert("It's a Tie!");
            return;
        }

        isXTurn = !isXTurn; // Switch turn
    }

    private boolean checkWin() {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (checkLine(buttons[i][0], buttons[i][1], buttons[i][2]) || // Rows
                checkLine(buttons[0][i], buttons[1][i], buttons[2][i])) { // Columns
                return true;
            }
        }
        return checkLine(buttons[0][0], buttons[1][1], buttons[2][2]) || // Diagonal
               checkLine(buttons[0][2], buttons[1][1], buttons[2][0]);  // Anti-diagonal
    }

    private boolean checkLine(Button b1, Button b2, Button b3) {
        String s1 = b1.getText();
        return !s1.isEmpty() && s1.equals(b2.getText()) && s1.equals(b3.getText());
    }

    private boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (buttons[row][col].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void resetGame() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
            }
        }
        isXTurn = true;
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
        resetGame();
    }
}