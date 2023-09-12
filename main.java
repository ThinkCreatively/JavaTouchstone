import java.util.Scanner;

class Main {
  // Count used to access player inputs
  private static int setupCount = 0;

  public static void main(String[] args) {
    // Create player's instances
    Player playerOne = new Player();
    Player playerTwo = new Player();
    Scanner playerOneInput = new Scanner(System.in);
    Scanner playerTwoInput = new Scanner(System.in);

    // Arrays to hold players and their scanners
    Player[] players = { playerOne, playerTwo };
    Scanner[] playerInputs = { playerOneInput, playerTwoInput };

    // Aliases
    Player currentPlayer = players[setupCount];
    Scanner currentPlayerInput = playerInputs[setupCount];

    // Welcome Message
    System.out.println("Welcome to my Tic Tac Toe game! \nPlease enter Player One's Name then Player Two");

    while (!playerOne.getIsReady() && !playerTwo.getIsReady()) {

      // Prompt player for name, +1 to account for 0 indexing
      System.out.print("Player" + (setupCount == 0 ? " 1 " : " 2 ") + "name: ");

      // Read a text entered by Player 1 and set the name of player
      currentPlayer.setName(currentPlayerInput.nextLine());

      // Prompt player for their choice of X or O
      while (!currentPlayer.getChoice().equals("X") && !currentPlayer.getChoice().equals("O")) {
        System.out.print("Player" + (setupCount == 0 ? " 1 " : " 2 ") + "choice (Please choose 'X' or 'O'): ");
        currentPlayer.setChoice(currentPlayerInput.nextLine());
        currentPlayer.setIsReady(true);
      }

      // Flipping setup count between 0 and 1
      if (setupCount == 0) {
        setupCount = 1;
      } else {
        setupCount = 0;
      }

      System.out.println(playerOne.getIsReady());
      System.out.println(playerTwo.getIsReady());
    }

    // Close scanner to avoid leak

    playerInputs[0].close();
    playerInputs[1].close();

    System.out.println("player one is ready? " + playerOne.getIsReady());
    System.out.println("player two is ready? " + playerTwo.getIsReady());
  }
}