package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  int roundNumber;
  String playerName;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    playerName = options[0];
    roundNumber = 0;
  }

  public void play() {
    // increment the round number everytime PLAY is invoked
    roundNumber++;
    MessageCli.START_ROUND.printMessage(String.valueOf(roundNumber));

    // get the number of fingers from the player
    int fingers = getFinger();
    MessageCli.PRINT_INFO_HAND.printMessage(playerName, String.valueOf(fingers));

    // Level: EASY
    // get random number of fingers from the AI (0 ~ 5)
    int fingersAI = Utils.getRandomNumberRange(0, 5);
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(fingersAI));
  }

  // method to get a valid number of fingers from the player
  public int getFinger() {
    while (true) {
      MessageCli.ASK_INPUT.printMessage();
      String stringFingers = Utils.scanner.nextLine();
      try {
        int integerFingers = Integer.parseInt(stringFingers);

        if (integerFingers >= 0 && integerFingers <= 5) {
          return integerFingers;
        } else {
          MessageCli.INVALID_INPUT.printMessage();
        }

      } catch (NumberFormatException e) {
        MessageCli.INVALID_INPUT.printMessage();
      }
    }
  }

  public void endGame() {}

  public void showStats() {}
}
