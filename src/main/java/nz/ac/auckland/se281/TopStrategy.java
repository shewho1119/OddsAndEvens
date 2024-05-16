package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements StrategyType {
  @Override
  public Integer getfingersBot(Game game) {
    int fingersBot = 0;

    if (game.getOddCount() > game.getEvenCount()) { // Player predominantly selected ODD numbers
      if (game.getChoice() == Choice.ODD) {
        fingersBot = Utils.getRandomOddNumber();
      } else if (game.getChoice() == Choice.EVEN) {
        fingersBot = Utils.getRandomEvenNumber();
      }
    } else if (game.getEvenCount()
        > game.getOddCount()) { // Player predominantly selected EVEN numbers
      if (game.getChoice() == Choice.ODD) {
        fingersBot = Utils.getRandomEvenNumber();
      } else if (game.getChoice() == Choice.EVEN) {
        fingersBot = Utils.getRandomOddNumber();
      }
    } else { // Player selected an equal number of ODD and EVEN numbers
      fingersBot = Utils.getRandomNumberRange(0, 5);
    }

    return fingersBot;
  }
}
