import java.util.Scanner;

class Main {
  // Method used to either get and set a name or get and set a choice
  private static void gather(Player player, Scanner playerInput, int playerNum, String funcName) {
    if (funcName.equals("name")) {
      System.out.print("Player " + playerNum + " name: ");
      player.setName(playerInput.nextLine());
      return;
    }

    // while loop enforces users pick X or O
    while (!player.getChoice().equals("X") && !player.getChoice().equals("O")) {
      System.out.print("Player " + playerNum + " choose 'X' or 'O': ");
      player.setChoice(playerInput.nextLine());
    }
  }

  private static boolean isNumber(String input) {
    try {
      Double.parseDouble(input);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public static void main(String[] args) {
    // Create player's instances
    Player playerOne = new Player();
    Player playerTwo = new Player();
    Scanner playerOneInput = new Scanner(System.in);
    Scanner playerTwoInput = new Scanner(System.in);

    // Welcome Message
    System.out.println("Welcome to my Tic Tac Toe game! \nPlease enter Player One's Name then Player Two");

    // Gather names
    gather(playerOne, playerOneInput, 1, "name");
    gather(playerTwo, playerTwoInput, 2, "name");

    // Gather Choices
    gather(playerOne, playerOneInput, 1, "choice");
    if (playerOne.getChoice().equals("X")) {
      System.out.println("Player two will be O \n");
      playerTwo.setChoice("O");
    } else {
      System.out.println("Player Two will be X \n");
      playerTwo.setChoice("X");
    }

    // Create board instance
    Board gameBoard = new Board();
    int playerTurn = 0;
    String choice = "";
    Scanner[] playersInputs = { playerOneInput, playerTwoInput };
    Player[] players = { playerOne, playerTwo };

    // Gameplay loop
    while(gameBoard.getTotalCount() != 9) {
      // Show Board
      System.out.println(gameBoard.getBoard() + "\n");

      // Ask where player wants to move
      System.out.print(players[playerTurn].getName() + " where do you want to play your move? Ex:(1 = Square 1)");
      choice = playersInputs[playerTurn].nextLine();

      // loop to prevent players 
      while (!isNumber(choice)) {
        System.out.print("Please pick a number left available");
        choice = playersInputs[playerTurn].nextLine();
      }
      // Update board
      gameBoard.setBoard(playersInputs[playerTurn].nextLine(), players[playerTurn].getChoice());

      // Update X or O count based on player choices
      if (players[playerTurn].getChoice().equals("X")) {
        gameBoard.setXCount();
      } else {
        gameBoard.setOCount();
      }

      // Switch to other players turn
      playerTurn = playerTurn == 0 ? 1 : 0;
    }

    // Close Scanners
    playerOneInput.close();
    playerTwoInput.close();
  }
}