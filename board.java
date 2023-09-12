class Board {
  // Basic info of board
  private int xCount = 0;
  private int oCount = 0;
  private int totalCount = this.xCount + this.oCount;
  private String playerOne;
  private String playerTwo;
  private String winner;

  // Public constructor
  public Board(String playerOne, String playerTwo) {
    this.playerOne = playerOne;
    this.playerTwo = playerTwo;
  }

  // Getter Methods
  public int getXCount() {
    return xCount;
  }

  public int getOCount() {
    return oCount;
  }

  public int getTotalCount() {
    return totalCount;
  }

  public String getPlayerOne() {
    return playerOne;
  }

  public String getPlayerTwo() {
    return playerTwo;
  }

  public String getWinner() {
    return winner;
  }
}
