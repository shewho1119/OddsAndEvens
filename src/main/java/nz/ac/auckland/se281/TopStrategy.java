package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements StrategyType {
  /**
   * This method is used to implement one of the Strategy type of this game which is the TOP
   * strategy. In the TOP strategy, the AI predicts the player's next move based on the data of
   * previous EVEN or ODD numbers that the human played.
   *
   * @param game The current game object
   * @return fingersBot The number of fingers the bot will play using Top strategy
   */
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
