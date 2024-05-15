package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class Easy implements Levels {

  @Override
  public void levelAlgorithm(int fingers, int roundNumber, Game game) {

    // get random number of fingers from the AI (0 ~ 5)
    int fingersAI = Utils.getRandomNumberRange(0, 5);
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(fingersAI));

    int sum = fingers + fingersAI;
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
