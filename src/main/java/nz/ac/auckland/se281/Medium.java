package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class Medium implements Levels {

  @Override
  public void levelAlgorithm(
      int fingers, Choice choice, String playerName, int roundNumber, Game game) {
    int fingersAI = Utils.getRandomNumberRange(0, 5); // 0으로 고치기

    if (roundNumber >= 4) {

      if (game.oddCount > game.evenCount) { // Player predominantly selected ODD numbers
        if (choice == Choice.ODD) {
          fingersAI = Utils.getRandomOddNumber();
        } else if (choice == Choice.EVEN) {
          fingersAI = Utils.getRandomEvenNumber();
        }
      } else if (game.evenCount > game.oddCount) { // Player predominantly selected EVEN numbers
        if (choice == Choice.ODD) {
          fingersAI = Utils.getRandomEvenNumber();
        } else if (choice == Choice.EVEN) {
          fingersAI = Utils.getRandomOddNumber();
        }
      } else { // Player selected an equal number of ODD and EVEN numbers
        fingersAI = Utils.getRandomNumberRange(0, 5);
      }

    } else {
      // get random number of fingers from the AI (0 ~ 5)
      fingersAI = Utils.getRandomNumberRange(0, 5);
    }

    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(fingersAI));

    int sum = fingers + fingersAI;
    if (Utils.isEven(sum)) {
      if (Choice.EVEN.equals(choice)) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", playerName);
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", "HAL-9000");
      }
    } else if (Utils.isOdd(sum)) {
      if (Choice.ODD.equals(choice)) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", playerName);
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", "HAL-9000");
      }
    }
  }
}
