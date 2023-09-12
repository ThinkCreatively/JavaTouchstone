class Player {
  // Basic info of player
  private String name;
  private String choice;
  private Boolean isReady;

  // Public constructor
  public Player() {
    this.name = "";
    this.choice = "";
    this.isReady = false;
  }

  // Getter Methods
  public String getName() {
    return name;
  }

  public String getChoice() {
    return choice;
  }

  public Boolean getIsReady() {
    return isReady;
  }

  // Setter Methods
  public void setName(String name) {
    this.name = name;
  }

  public void setChoice(String choice) {
    this.choice = choice;
  }

  public void setIsReady(Boolean isReady) {
      this.isReady = isReady;
  }
}