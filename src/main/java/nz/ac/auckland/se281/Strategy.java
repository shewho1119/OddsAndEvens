package nz.ac.auckland.se281;

public class Strategy {

  private StrategyType type;
  private Game game;

  /**
   * This constructor is used to create a new Strategy object with the given StrategyType and Game
   *
   * @param type The type of strategy
   * @param game The current game object
   */
  public Strategy(StrategyType type, Game game) {
    this.type = type;
    this.game = game;
  }

  /**
   * This is a setter method for outside classes to set a different type of strategy that the AI
   * will use. This will allow the strategy to change during the runtime as part of the Strategy
   * design pattern.
   *
   * @param type
   */
  public void setStrategy(StrategyType type) {
    this.type = type;
  }

  /**
   * In this method, desired strategy to be used will be passed as an object and the AI's number of
   * fingers will be outputted.
   *
   * @return fingersBot The number of fingers the AI will play
   */
  public Integer process() {
    return type.getfingersBot(game);
  }
}
