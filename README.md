# Tic Tac Toe - JavaFX

A simple Tic Tac Toe game built using JavaFX. This project allows two players to play the game interactively, displaying the winner or indicating a tie.

---

## Features
- Interactive 3x3 grid for gameplay.
- Displays the winner (X or O) or a tie.
- Reset button to restart the game.

---

## Prerequisites
1. **Java JDK 17 or higher** must be installed.
2. **JavaFX SDK** must be downloaded and configured.

---

## Setup in VS Code

### 1. Install Extensions
- Install the **Extension Pack for Java** from the VS Code marketplace.
- Install **JavaFX Support** if needed.

### 2. Install JavaFX SDK
- Download the [JavaFX SDK](https://openjfx.io/).
- Extract the SDK and locate the `lib` folder path.

### 3. Clone or Copy the Project
Save the provided `TicTacToe.java` file in your VS Code workspace.

---

## Running the Project in VS Code

### Configure Launch Settings:
1. Open the **Command Palette** in VS Code (Ctrl+Shift+P or Cmd+Shift+P on Mac).
2. Select **Java: Configure Java Runtime** and add the path to your JavaFX SDK.

### Add VM Arguments:
- Open the `.vscode/launch.json` file (create it if it doesn’t exist) and add the following configuration:

```json
{
  "version": "0.2.0",
  "configurations": [
    {
      "type": "java",
      "name": "Launch TicTacToe",
      "request": "launch",
      "mainClass": "TicTacToe",
      "vmArgs": "--module-path <path-to-javafx-lib> --add-modules javafx.controls,javafx.fxml"
    }![WhatsApp Image 2024-12-03 at 21 07 27](https://github.com/user-attachments/assets/5b799a6b-a9f5-4c2b-8655-ff16a81a30fa)
![WhatsApp Image 2024-12-03 at 21 07 27 (1)](https://github.com/user-attachments/assets/b83331d4-aa75-4449-8f89-5489afa36101)
![WhatsApp Image 2024-12-03 at 21 07 26](https://github.com/user-attachments/assets/42ef9dc2-8761-427c-ae01-25ec4c22798b)
![WhatsApp Image 2024-12-03 at 21 07 26 (1)](https://github.com/user-attachments/assets/494ba136-edd0-4815-9dca-e04949f49336)

}

