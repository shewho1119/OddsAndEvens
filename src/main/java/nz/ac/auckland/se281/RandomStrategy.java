package nz.ac.auckland.se281;

public class RandomStrategy implements StrategyType {
  @Override
  public Integer getFingersAI(Game game) {
    // get random number of fingers from the AI (0 ~ 5)
    int fingersAI = Utils.getRandomNumberRange(0, 5);
    return fingersAI;
  }
}
