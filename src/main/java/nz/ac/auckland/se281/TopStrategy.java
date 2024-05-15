package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements StrategyType {
  @Override
  public Integer getFingersAI(Game game) {
    int fingersAI = 0;

    if (game.oddCount > game.evenCount) { // Player predominantly selected ODD numbers
      if (game.choice == Choice.ODD) {
        fingersAI = Utils.getRandomOddNumber();
      } else if (game.choice == Choice.EVEN) {
        fingersAI = Utils.getRandomEvenNumber();
      }
    } else if (game.evenCount > game.oddCount) { // Player predominantly selected EVEN numbers
      if (game.choice == Choice.ODD) {
        fingersAI = Utils.getRandomEvenNumber();
      } else if (game.choice == Choice.EVEN) {
        fingersAI = Utils.getRandomOddNumber();
      }
    } else { // Player selected an equal number of ODD and EVEN numbers
      fingersAI = Utils.getRandomNumberRange(0, 5);
    }

    return fingersAI;
  }
}
