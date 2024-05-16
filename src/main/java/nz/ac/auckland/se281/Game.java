package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  int roundNumber;
  String playerName;
  Choice choice;
  Difficulty difficulty;

  int oddCount;
  int evenCount;

  boolean lastRoundWin;
  boolean lastStrategyTop;

  private boolean gameStarted;

  int playerWinNumber;
  int aiWinNumber;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);

    playerName = options[0];
    roundNumber = 0;

    this.choice = choice;
    this.difficulty = difficulty;

    oddCount = 0;
    evenCount = 0;

    lastRoundWin = false;
    lastStrategyTop = false;

    gameStarted = true;

    playerWinNumber = 0;
    aiWinNumber = 0;
  }

  public void play() {
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // increment the round number everytime PLAY is invoked
    roundNumber++;
    MessageCli.START_ROUND.printMessage(String.valueOf(roundNumber));

    // get the number of fingers from the player
    int fingers = getFinger();
    MessageCli.PRINT_INFO_HAND.printMessage(playerName, String.valueOf(fingers));

    if (Utils.isEven(fingers)) {
      evenCount++;
    } else if (Utils.isOdd(fingers)) {
      oddCount++;
    }

    Levels level = LevelFactory.createLevels(difficulty);
    level.levelAlgorithm(fingers, roundNumber, this);
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

  public void endGame() {
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    if (aiWinNumber > playerWinNumber) {
      MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
    }
  }

  public void showStats() {
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
  }
}
