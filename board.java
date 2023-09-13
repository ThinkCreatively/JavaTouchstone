class Board {
  // Basic info of board
  private int xCount = 0;
  private int oCount = 0;
  private String board = "";
  private String winner = "";

  // Public constructor
  public Board() {
    this.board = "1" + "┃" + "2" + "┃" + "3" + "\n" +
        "━" + "╋" + "━" + "╋" + "━" + "\n" +
        "4" + "┃" + "5" + "┃" + "6" + "\n" +
        "━" + "╋" + "━" + "╋" + "━" + "\n" +
        "7" + "┃" + "8" + "┃" + "9";
  }

  // Getter Methods
  public int getXCount() {
    return xCount;
  }

  public int getOCount() {
    return oCount;
  }

  public int getTotalCount() {
    return getXCount() + getOCount();
  }

  public String getBoard() {
    return board;
  }

  public String getWinner() {
    return winner;
  }

  // Setter Methods

  public void setXCount() {
    this.xCount++;
  }

  public void setOCount() {
    this.oCount++;
  }

  public void setBoard(String spaceNum, String gameChar) {
    this.board = this.board.replace(spaceNum, gameChar);
  }

  public void setWinner(String winner) {
    this.winner = winner;
  }
}
