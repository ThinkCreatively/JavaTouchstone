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

  // Method that grabs the values from a row in the board
  private static String checkRow(int start, int end, String[] rowValues) {
    StringBuilder row = new StringBuilder();

    for (int i = start; i < end; i++) {
        row.append(rowValues[i]);
    }

    return row.toString();
  }

  // Method that returns player that chose X
  private static Player determineWinner(Player playerOne, Player playerTwo) {
    if (playerOne.getChoice().equals("X")) {
      return playerOne;
    }

    return playerTwo;
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
    Scanner[] playersInputs = { playerOneInput, playerTwoInput };
    Player[] players = { playerOne, playerTwo };
    String placementChoice = "";
    int playerTurn = 0;

    // Gameplay loop
    while (gameBoard.getTotalCount() != 9) {
      // Show Board
      System.out.println(gameBoard.getBoard() + "\n");

      // Ask where player wants to move
      System.out.print(players[playerTurn].getName() + " where do you want to play your move? Ex:(1 = Space 1)");

      placementChoice = playersInputs[playerTurn].nextLine();

      // Loop to prevent players, checks that input is one of the numbers left
      while (placementChoice.matches("^[^0-8]+$") || gameBoard.getBoard().indexOf(placementChoice) == -1) {
        System.out.println("Please pick a number left available");
        placementChoice = playersInputs[playerTurn].nextLine();
      }
      // Update board & clear placement choice for next player
      gameBoard.setBoard(placementChoice, players[playerTurn].getChoice());
      placementChoice = "";

      // Update X or O count based on player choices
      if (players[playerTurn].getChoice().equals("X")) {
        gameBoard.setXCount();
      } else {
        gameBoard.setOCount();
      }

      // Check for win for X
      String[] boardValues = gameBoard.getBoardValues();
      if (gameBoard.getXCount() >= 3) {
        // Horizontal Top Row
        String topRow = checkRow(0, 3, boardValues);
        if (topRow.equals("XXX")) {
          gameBoard.setWinner(determineWinner(playerOne, playerTwo).getName());
          break;
        }

        // Horizontal Middle Row
        String middleRow = checkRow(3, 6, boardValues);
        if (middleRow.equals("XXX")) {
          gameBoard.setWinner(determineWinner(playerOne, playerTwo).getName());
          break;
        }

        // Horizontal Bottom Row
        String bottomRow = checkRow(6, 9, boardValues);
        if (bottomRow.equals("XXX")) {
          gameBoard.setWinner(determineWinner(playerOne, playerTwo).getName());
          break;
        }
      }

      // Switch to other players turn
      playerTurn = playerTurn == 0 ? 1 : 0;
    }

    // Checking for win or tie, then printing correct message
    if (gameBoard.getWinner().equals(playerOne.getName())) {
      System.out.println("Congrats " + playerOne.getName() + "!");
    } else if (gameBoard.getWinner().equals(playerTwo.getName())) {
      System.out.println("Congrats " + playerTwo.getName() + "!");
    } else {
      System.out.println("No winner, game over.");
    }

    // Close Scanners
    playerOneInput.close();
    playerTwoInput.close();
  }
}