import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    // Create player one's instance
    Player playerOne = new Player();
    Scanner playerOneInput = new Scanner(System.in);

    // Welcome Message
    System.out.println("Welcome to my Tic Tac Toe game! \nPlease enter Player One's Name then Player Two");

    // Prompt Player for name
    System.out.print("Player One's name: ");

    // Read a text entered by Player 1 and set the name of player
    playerOne.setName(playerOneInput.nextLine());

    // Prompt Player for their choice of X or O
    System.out.print("Player One's choice: ");

    while (!"X".equals(playerOne.getChoice()) && !"O".equals(playerOne.getChoice())) {
      System.out.print("Please choose 'X' or 'O': ");
      String input = playerOneInput.nextLine();
      playerOne.setChoice(input);
    }

    // Close scanner to avoid leak
    playerOneInput.close();

    System.out.println(playerOne.getName());
  }
}