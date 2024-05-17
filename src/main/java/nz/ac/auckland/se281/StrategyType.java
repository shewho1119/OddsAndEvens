package nz.ac.auckland.se281;

public interface StrategyType {
  /**
   * This method is used to get the number of fingers the bot will play using either Random or Top
   * Strategies. This method will be overridden by the classes that implement this interface.
   *
   * @param game The current game object
   * @return fingersBot The number of fingers the bot will play using either Random or Top strategy
   */
  Integer getfingersBot(Game game);
}
