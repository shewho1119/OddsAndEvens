package nz.ac.auckland.se281;

public class Strategy {

  private StrategyType type;
  private Game game;

  public Strategy(StrategyType type, Game game) {
    this.type = type;
    this.game = game;
  }

  public void setStrategy(StrategyType type) {
    this.type = type;
  }

  public Integer process() {
    return type.getfingersBot(game);
  }
}
