package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int roundNumber;
  private String playerName;
  private Choice choice;

  public Choice getChoice() {
    return choice;
  }

  private Difficulty difficulty;

  private int oddCount;
  private int evenCount;

  public int getOddCount() {
    return oddCount;
  }

  public int getEvenCount() {
    return evenCount;
  }

  private boolean lastRoundWin;

  public boolean getLastRoundWin() {
    return lastRoundWin;
  }

  public void setLastRoundWin(boolean lastRoundWin) {
    this.lastRoundWin = lastRoundWin;
  }

  private boolean lastStrategyTop;

  public boolean getLastStrategyTop() {
    return lastStrategyTop;
  }

  public void setLastStrategyTop(boolean lastStrategyTop) {
    this.lastStrategyTop = lastStrategyTop;
  }

  private boolean gameStarted = false;

  private int playerWinNumber;
  private int aiWinNumber;

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

  public void findWinner(int sum) {
    if (Utils.isEven(sum)) {
      if (Choice.EVEN.equals(choice)) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", playerName);
        playerWinNumber++;
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", "HAL-9000");
        aiWinNumber++;
      }
    } else if (Utils.isOdd(sum)) {
      if (Choice.ODD.equals(choice)) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", playerName);
        playerWinNumber++;
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", "HAL-9000");
        aiWinNumber++;
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
    } else if (playerWinNumber > aiWinNumber) {
      MessageCli.PRINT_END_GAME.printMessage(playerName);
    } else if (playerWinNumber == aiWinNumber) {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }

    gameStarted = false;
  }

  public void showStats() {
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    MessageCli.PRINT_PLAYER_WINS.printMessage(
        playerName, String.valueOf(playerWinNumber), String.valueOf(roundNumber - playerWinNumber));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "HAL-9000", String.valueOf(aiWinNumber), String.valueOf(roundNumber - aiWinNumber));
  }
}
