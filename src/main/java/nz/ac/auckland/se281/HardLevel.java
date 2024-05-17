package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/**
 * This class implements the Levels interface and contains the algorithm for the HARD level.
 *
 * @author Shihoo Park
 */
public class HardLevel implements Levels {

  /**
   * This method is the algorithm for the hard level. For the first 3 rounds HARD will use the
   * Random strategy, for the fourth round onwards the HARD level AI will switch strategy if the
   * strategy lost in the previous round, otherwise will keep using that strategy.
   *
   * @param fingers the number of fingers the player has chosen
   * @param roundNumber the current round number
   * @param game the current game object
   */
  @Override
  public void levelAlgorithm(int fingers, int roundNumber, Game game) {
    int fingersBot;
    boolean previousTop;

    // using Strategy design pattern to get the number of fingers from the AI
    Strategy strategy = new Strategy(new RandomStrategy(), game);

    if (roundNumber >= 4) {
      if (!game.getLastRoundWin()) { // if lost in the last round
        previousTop = game.getLastStrategyTop();
        game.setLastStrategyTop(!previousTop); // switch strategy
      }

      if (game.getLastStrategyTop()) {
        strategy.setStrategy(new TopStrategy());
      } else if (!game.getLastStrategyTop()) {
        strategy.setStrategy(new RandomStrategy());
      }

      fingersBot = strategy.process();
    } else {
      fingersBot = strategy.process();
    }

    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(fingersBot));

    int sum = fingers + fingersBot;

    boolean aiWon =
        (Utils.isEven(sum) && !(Choice.EVEN.equals(game.getChoice())))
            || (Utils.isOdd(sum) && !(Choice.ODD.equals(game.getChoice())));

    game.setLastRoundWin(aiWon);

    game.findWinner(sum);
  }
}
