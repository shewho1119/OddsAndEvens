package nz.ac.auckland.se281;

/**
 * This interface is used to implement the Strategy design pattern. It defines a method that must be
 * implemented by any class that implements this interface to use the correct design pattern for
 * getting the move for AI.
 */
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
