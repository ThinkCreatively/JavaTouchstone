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
    while (!player.getChoice().toUpperCase().equals("X") && !player.getChoice().toUpperCase().equals("O")) {
      System.out.print("Player " + playerNum + " choose 'X' or 'O': ");
      player.setChoice(playerInput.nextLine());
    }
  }

  // Method that grabs the values of a row
  private static String checkRow(int start, int end, String[] rowValues) {
    StringBuilder row = new StringBuilder();

    for (int i = start; i < end; i++) {
      row.append(rowValues[i]);
    }

    return row.toString();
  }

  // Method that grabs the values of a column
  private static String checkColumn(int colNum, String[] colValues) {
    StringBuilder row = new StringBuilder();

    if (colNum == 1) {
      row.append(colValues[0]);
      row.append(colValues[3]);
      row.append(colValues[6]);
    } else if (colNum == 2) {
      row.append(colValues[1]);
      row.append(colValues[4]);
      row.append(colValues[7]);
    } else {
      row.append(colValues[2]);
      row.append(colValues[5]);
      row.append(colValues[8]);
    }

    return row.toString();
  }

  // Method that gravs the values of the diagonals
  private static String checkDiagonal(int topIndex, String[] diagVals) {
    StringBuilder row = new StringBuilder();

    if (topIndex == 0) {
      row.append(diagVals[0]);
      row.append(diagVals[4]);
      row.append(diagVals[8]);
    } else {
      row.append(diagVals[2]);
      row.append(diagVals[4]);
      row.append(diagVals[6]);
    }

    return row.toString();
  }

  // Method that returns player that chose X
  private static Player determineWinner(Player playerOne, Player playerTwo, String charToLookFor) {
    if (playerOne.getChoice().equals(charToLookFor)) {
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
    if (playerOne.getChoice().toUpperCase().equals("X")) {
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
      placementChoice = playersInputs[playerTurn].nextLine().toUpperCase();

      // Checks that input is one of the numbers left and isn't an empty string
      while (placementChoice.matches("^[^0-8\\s]+$") || gameBoard.getBoard().indexOf(placementChoice) == -1
          || placementChoice.isEmpty()) {
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

      // Check for wins
      String[] boardValues = gameBoard.getBoardValues();
      if (gameBoard.getXCount() >= 3 || gameBoard.getOCount() >= 3) {
        // Horizontal top row
        String topRow = checkRow(0, 3, boardValues);
        if (topRow.equals("XXX")) {
          gameBoard.setWinner(determineWinner(playerOne, playerTwo, "X").getName());
          break;
        }

        if (topRow.equals("OOO")) {
          gameBoard.setWinner(determineWinner(playerOne, playerTwo, "O").getName());
          break;
        }

        // Horizontal middle row
        String middleRow = checkRow(3, 6, boardValues);
        if (middleRow.equals("XXX")) {
          gameBoard.setWinner(determineWinner(playerOne, playerTwo, "X").getName());
          break;
        }

        if (middleRow.equals("OOO")) {
          gameBoard.setWinner(determineWinner(playerOne, playerTwo, "O").getName());
          break;
        }

        // Horizontal bottom row
        String bottomRow = checkRow(6, 9, boardValues);
        if (bottomRow.equals("XXX")) {
          gameBoard.setWinner(determineWinner(playerOne, playerTwo, "X").getName());
          break;
        }

        if (bottomRow.equals("OOO")) {
          gameBoard.setWinner(determineWinner(playerOne, playerTwo, "O").getName());
          break;
        }

        // Vertical left column
        String leftColumn = checkColumn(1, boardValues);
        if (leftColumn.equals("XXX")) {
          gameBoard.setWinner(determineWinner(playerOne, playerTwo, "X").getName());
          break;
        }

        if (leftColumn.equals("OOO")) {
          gameBoard.setWinner(determineWinner(playerOne, playerTwo, "O").getName());
          break;
        }

        // Vertical middle column
        String midColumn = checkColumn(2, boardValues);
        if (midColumn.equals("XXX")) {
          gameBoard.setWinner(determineWinner(playerOne, playerTwo, "X").getName());
          break;
        }

        if (midColumn.equals("OOO")) {
          gameBoard.setWinner(determineWinner(playerOne, playerTwo, "O").getName());
          break;
        }

        // Vertical right column
        String rightColumn = checkColumn(3, boardValues);
        if (rightColumn.equals("XXX")) {
          gameBoard.setWinner(determineWinner(playerOne, playerTwo, "X").getName());
          break;
        }

        if (rightColumn.equals("OOO")) {
          gameBoard.setWinner(determineWinner(playerOne, playerTwo, "O").getName());
          break;
        }

        // Diagonal left -> right
        String leftDiagonal = checkDiagonal(0, boardValues);
        if (leftDiagonal.equals("XXX")) {
          gameBoard.setWinner(determineWinner(playerOne, playerTwo, "X").getName());
          break;
        }

        if (leftDiagonal.equals("OOO")) {
          gameBoard.setWinner(determineWinner(playerOne, playerTwo, "O").getName());
          break;
        }

        // Diagonal right -> left
        String rightDiagonal = checkDiagonal(2, boardValues);
        if (rightDiagonal.equals("XXX")) {
          gameBoard.setWinner(determineWinner(playerOne, playerTwo, "X").getName());
          break;
        }

        if (rightDiagonal.equals("OOO")) {
          gameBoard.setWinner(determineWinner(playerOne, playerTwo, "O").getName());
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

    // Show winning board
    System.out.println("Winning Board: \n" + gameBoard.getBoard());

    // Close Scanners
    playerOneInput.close();
    playerTwoInput.close();
  }
}