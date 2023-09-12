import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner playerOneInput = new Scanner(System.in);

    // Welcome Message
    System.out.println("Welcome to my Tic Tac Toe game! \nPlease enter Player One's Name then Player Two");

    // Prompt Player for name
    System.out.print("Player One's name: ");

    // Read a text entered by Player 1
    String playerOneName = playerOneInput.nextLine();

    // Prompt Player for name
    System.out.print("and Player One's choice: ");

    // Read a text entered by Player 1
    String playerOneChoice = playerOneInput.nextLine();

    // Create player one's instance
    Player playerOne = new Player(playerOneName, playerOneChoice);

    // Close scanner to avoid leak
    playerOneInput.close();

    System.out.println(playerOne.getName());
  }
}