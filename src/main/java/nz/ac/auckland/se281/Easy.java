package nz.ac.auckland.se281;

public class Easy implements Levels {

  @Override
  public void levelAlgorithm(int fingers, int roundNumber, Game game) {

    int fingersBot;

    // using Strategy design pattern to get the number of fingers from the AI
    Strategy strategy = new Strategy(new RandomStrategy(), game);
    fingersBot = strategy.process();

    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(fingersBot));

    // Algorithm to determine the winner
    int sum = fingers + fingersBot;
    game.findWinner(sum);
  }
}
