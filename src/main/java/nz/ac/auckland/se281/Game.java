package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int roundNumber;
  private String playerName;
  private Choice choice;
  private Difficulty difficulty;
  private int oddCount;
  private int evenCount;
  private boolean lastRoundWin;
  private boolean lastStrategyTop;
  private boolean gameStarted = false;
  private int playerWinNumber;
  private int aiWinNumber;

  public Choice getChoice() {
    return choice;
  }

  public int getOddCount() {
    return oddCount;
  }

  public int getEvenCount() {
    return evenCount;
  }

  public boolean getLastRoundWin() {
    return lastRoundWin;
  }

  public void setLastRoundWin(boolean lastRoundWin) {
    this.lastRoundWin = lastRoundWin;
  }

  public boolean getLastStrategyTop() {
    return lastStrategyTop;
  }

  public void setLastStrategyTop(boolean lastStrategyTop) {
    this.lastStrategyTop = lastStrategyTop;
  }

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);

    playerName = options[0];
    roundNumber = 0;

    this.choice = choice;
    this.difficulty = difficulty;

    // reset the odd and even count
    oddCount = 0;
    evenCount = 0;

    // reset last round win and last strategy top, all to false
    lastRoundWin = false;
    lastStrategyTop = false;

    // set the game as started
    gameStarted = true;

    // reset the number of wins for the player and the AI
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

    // monitor how frequently the player chose evens and odds
    if (Utils.isEven(fingers)) {
      evenCount++;
    } else if (Utils.isOdd(fingers)) {
      oddCount++;
    }

    // create the corresponding level class based on the difficulty
    Levels level = LevelFactory.createLevels(difficulty);
    // call the levelAlgorithm method of the corresponding level class
    level.levelAlgorithm(fingers, roundNumber, this);
  }

  // method to get a valid number of fingers from the player
  public int getFinger() {
    while (true) {
      // get the num of finger input from the player
      MessageCli.ASK_INPUT.printMessage();
      String stringFingers = Utils.scanner.nextLine();

      try {
        int integerFingers = Integer.parseInt(stringFingers);

        // check if the input is between 0 and 5(nclusive)
        if (integerFingers >= 0 && integerFingers <= 5) {
          return integerFingers;
        } else {
          MessageCli.INVALID_INPUT.printMessage();
        }

        // check if the input is not a single integer number
      } catch (NumberFormatException e) {
        MessageCli.INVALID_INPUT.printMessage();
      }
    }
  }

  public void findWinner(int sum) {

    if (Utils.isEven(sum)) { // if the sum is even
      if (Choice.EVEN.equals(choice)) { // player chose EVEN
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", playerName);
        // increment the number of wins for the player
        playerWinNumber++;
      } else { // otherwise AI wins
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", "HAL-9000");
        aiWinNumber++;
      }
    } else if (Utils.isOdd(sum)) { // if the sum is odd
      if (Choice.ODD.equals(choice)) { // player chose ODD
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", playerName);
        playerWinNumber++;
      } else { // otherwise AI wins
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", "HAL-9000");
        aiWinNumber++;
      }
    }
  }

  public void endGame() {
    // if the game has not started, print error message
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // printing the end game message
    if (aiWinNumber > playerWinNumber) { // AI wins
      MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
    } else if (playerWinNumber > aiWinNumber) { // Player wins
      MessageCli.PRINT_END_GAME.printMessage(playerName);
    } else if (playerWinNumber == aiWinNumber) { // Tie
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }

    // end the game by switching gameStarted back to false
    gameStarted = false;
  }

  public void showStats() {
    // if the game has not started, print error message
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // print the stats of the player
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        playerName, String.valueOf(playerWinNumber), String.valueOf(roundNumber - playerWinNumber));

    // print the stats of the AI
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "HAL-9000", String.valueOf(aiWinNumber), String.valueOf(roundNumber - aiWinNumber));
  }
}
