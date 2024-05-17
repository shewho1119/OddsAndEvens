package nz.ac.auckland.se281;

/**
 * This class implements the StrategyType interface and contains the algorithm for the RANDOM
 * strategy.
 *
 * @author Shihoo Park
 */
public class RandomStrategy implements StrategyType {
  /**
   * This method is used to implement one of the Strategy type of this game which is the RANDOM
   * strategy. In the RANDOM strategy, the AI selects the fingers to play randomly between 0 and 5.
   *
   * @param game The current game object
   * @return fingersBot The number of fingers the bot will play using Random strategy
   */
  @Override
  public Integer getfingersBot(Game game) {
    int fingersBot = Utils.getRandomNumberRange(0, 5);
    return fingersBot;
  }
}
