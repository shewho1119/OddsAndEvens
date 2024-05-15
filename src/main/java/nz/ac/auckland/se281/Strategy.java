package nz.ac.auckland.se281;

public class Strategy {

  StrategyType type;

  public Strategy(StrategyType type) {
    this.type = type;
  }

  public void setStrategy(StrategyType type) {
    this.type = type;
  }

  public Integer process() {
    return type.getFingersAI();
  }
}
