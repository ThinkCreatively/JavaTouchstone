class Player {
  // Basic info of player
  private String name;
  private String choice;

  // Public constructor
  public Player(String name, String choice) {
    this.name = name;
    this.choice = choice;
  }

  // Getter Methods
  
  public String getName() {
    return name;
  }

  public String getChoice() {
    return choice;
  }
}