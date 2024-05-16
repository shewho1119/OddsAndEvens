package nz.ac.auckland.se281;

public class Medium implements Levels {

  @Override
  public void levelAlgorithm(int fingers, int roundNumber, Game game) {
    int fingersBot;

    // using Strategy design pattern to get the number of fingers from the AI
    Strategy strategy = new Strategy(new TopStrategy(), game);

    if (roundNumber >= 4) {
      fingersBot = strategy.process();
    } else {
      strategy.setStrategy(
          new RandomStrategy()); // change strategy to RandomStrategy during runtime
      fingersBot = strategy.process();
    }

    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(fingersBot));

    int sum = fingers + fingersBot;

    game.findWinner(sum);
  }
}
