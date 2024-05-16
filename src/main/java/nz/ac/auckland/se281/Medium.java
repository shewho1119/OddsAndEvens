package nz.ac.auckland.se281;

public class Medium implements Levels {

  @Override
  public void levelAlgorithm(int fingers, int roundNumber, Game game) {
    int fingersAI;

    // using Strategy design pattern to get the number of fingers from the AI
    Strategy strategy = new Strategy(new TopStrategy(), game);

    if (roundNumber >= 4) {
      fingersAI = strategy.process();
    } else {
      strategy.setStrategy(
          new RandomStrategy()); // change strategy to RandomStrategy during runtime
      fingersAI = strategy.process();
    }

    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(fingersAI));

    int sum = fingers + fingersAI;

    game.findWinner(sum);
  }
}
