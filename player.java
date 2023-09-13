class Player {
  // Basic info of player
  private String name;
  private String choice;

  // Public constructor
  public Player() {
    this.name = "";
    this.choice = "";

  }

  // Getter Methods
  public String getName() {
    return name;
  }

  public String getChoice() {
    return choice;
  }

  // Setter Methods
  public void setName(String name) {
    this.name = name;
  }

  public void setChoice(String choice) {
    this.choice = choice;
  }
}