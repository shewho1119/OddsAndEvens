package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class Hard implements Levels {

  @Override
  public void levelAlgorithm(int fingers, int roundNumber, Game game) {
    int fingersAI;

    // using Strategy design pattern to get the number of fingers from the AI
    Strategy strategy = new Strategy(new RandomStrategy(), game);

    // System.out.println("lastStrategy is Top: " + game.lastStrategyTop);

    if (roundNumber >= 4) {
      if (!game.lastRoundWin) { // if lost in the last round
        game.lastStrategyTop = !game.lastStrategyTop; // switch strategy
      }

      if (game.lastStrategyTop) {
        strategy.setStrategy(new RandomStrategy());
      } else if (!game.lastStrategyTop) {
        strategy.setStrategy(new RandomStrategy());
      }

      fingersAI = strategy.process();
    } else {
      fingersAI = strategy.process();
      // System.out.println("First 3 randoms");
    }

    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(fingersAI));

    int sum = fingers + fingersAI;

    boolean aiWon =
        (Utils.isEven(sum) && !(Choice.EVEN.equals(game.choice)))
            || (Utils.isOdd(sum) && !(Choice.ODD.equals(game.choice)));

    game.lastRoundWin = aiWon;

    if (Utils.isEven(sum)) {
      if (Choice.EVEN.equals(game.choice)) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", game.playerName);
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", "HAL-9000");
      }
    } else if (Utils.isOdd(sum)) {
      if (Choice.ODD.equals(game.choice)) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", game.playerName);
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", "HAL-9000");
      }
    }
  }
}
