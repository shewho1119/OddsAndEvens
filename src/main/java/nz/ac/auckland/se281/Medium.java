package nz.ac.auckland.se281;

public class Medium implements Levels {

  @Override
  public void levelAlgorithm(int fingers, int roundNumber, Game game) {
    int fingersBot;

    // using Strategy design pattern to get the number of fingers from the AI
    Strategy strategy = new Strategy(new TopStrategy(), game);

    // after round 4, use TopStrategy
    if (roundNumber >= 4) {
      fingersBot = strategy.process();
    } else { // before round 4, use RandomStrategy
      strategy.setStrategy(
          new RandomStrategy()); // change strategy to RandomStrategy during runtime
      fingersBot = strategy.process();
    }

    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(fingersBot));

    // calculate the sum of player/AI fingers
    int sum = fingers + fingersBot;

    game.findWinner(sum);
  }
}
