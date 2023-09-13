class Board {
  // Basic info of board
  private int xCount = 0;
  private int oCount = 0;
  private String board = "";
  private String[] boardValues = { "0", "1", "2", "3", "4", "5", "6", "7", "8" };
  private String winner = "";

  // Public constructor
  public Board() {
    this.board = boardValues[0] + "┃" + boardValues[1] + "┃" + boardValues[2] + "\n" +
        "━" + "╋" + "━" + "╋" + "━" + "\n" +
        boardValues[3] + "┃" + boardValues[4] + "┃" + boardValues[5] + "\n" +
        "━" + "╋" + "━" + "╋" + "━" + "\n" +
        boardValues[6] + "┃" + boardValues[7] + "┃" + boardValues[8];
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

  public String[] getBoardValues() {
    return boardValues;
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
    int parseNum = Integer.parseInt(spaceNum);
    boardValues[parseNum] = gameChar;
  }

  public void setWinner(String winner) {
    this.winner = winner;
  }
}
