package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class Hard implements Levels {

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
