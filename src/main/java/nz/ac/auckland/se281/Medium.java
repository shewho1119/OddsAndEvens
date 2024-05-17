package nz.ac.auckland.se281;

/**
 * This class implements the Levels interface and contains the algorithm for the MEDIUM level.
 *
 * @author Shihoo Park
 */
public class Medium implements Levels {

  /**
   * This method contains the algorithm for the medium level. For the first 3 rounds the MEDIUM
   * level will use the Random strategy, for the fourth round onwards the MEDIUM level will switch
   * to the Top strategy and will keep that strategy until the current game ends.
   *
   * @param fingers the number of fingers the player has chosen
   * @param roundNumber the current round number
   * @param game the current game object
   */
  @Override
  public void levelAlgorithm(int fingers, int roundNumber, Game game) {
    int fingersBot;

    // using Strategy design pattern to get the number of fingers from the AI
    Strategy strategy = new Strategy(new TopStrategy(), game);

    // after round 4, use TopStrategy
    if (roundNumber >= 4) {
      fingersBot = strategy.process();
    } else { // before round 4, use RandomStrategy
      strategy.setStrategy(
          new RandomStrategy()); // change strategy to RandomStrategy during runtime
      fingersBot = strategy.process();
    }

    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(fingersBot));

    // calculate the sum of player/AI fingers
    int sum = fingers + fingersBot;

    game.findWinner(sum);
  }
}
