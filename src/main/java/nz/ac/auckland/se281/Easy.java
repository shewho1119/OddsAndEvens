package nz.ac.auckland.se281;


public class Easy implements Levels {

  @Override
  public void levelAlgorithm(int fingers, int roundNumber, Game game) {

    int fingersAI;

    // using Strategy design pattern to get the number of fingers from the AI
    Strategy strategy = new Strategy(new RandomStrategy(), game);
    fingersAI = strategy.process();

    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", String.valueOf(fingersAI));

    // Algorithm to determine the winner
    int sum = fingers + fingersAI;
    game.findWinner(sum);
  }
}
