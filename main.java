import java.util.Scanner;

class Main {
  private static void gather(Player player, Scanner playerInput, int playerNum, String funcName) {
    if (funcName.equals("name")) {
      System.out.print("Player " + playerNum + " name: ");
      player.setName(playerInput.nextLine());
      return;
    }

    while (!player.getChoice().equals("X") && !player.getChoice().equals("O")) {
      System.out.print("Player " + playerNum + " choose 'X' or 'O': ");
      player.setChoice(playerInput.nextLine());
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
      System.out.println("Player two will be O");
      playerTwo.setChoice("O");
    } else {
      System.out.println("Player Two will be X");
      playerTwo.setChoice("X");
    }

    System.out.println("p1 name: " + playerOne.getName());
    System.out.println("p1 choice: " + playerOne.getChoice());
    System.out.println("p2 name: " + playerTwo.getName());
    System.out.println("p2 choice: " + playerTwo.getChoice());

    playerOneInput.close();
    playerTwoInput.close();
  }
}