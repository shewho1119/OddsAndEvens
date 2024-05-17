package nz.ac.auckland.se281;

public class EasyLevel implements Levels {

  /**
   * This method is the algorithm for the easy level. The EASY level uses the Random strategy, and
   * it will never change the strategy for the rest of the game.
   *
   * @param fingers the number of fingers the player has chosen
   * @param roundNumber the current round number
   * @param game the current game object
   */
  @Override
  public void levelAlgorithm(int fingers, int roundNumber, Game game) {

    int fingersBot;

    // using Strategy design pattern to get the number of fingers from the AI
    Strategy strategy = new Strategy(new RandomStrategy(), game);
    fingersBot = strategy.process();

    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(fingersBot));

    // Algorithm to determine the winner
    int sum = fingers + fingersBot;
    game.findWinner(sum);
  }
}
