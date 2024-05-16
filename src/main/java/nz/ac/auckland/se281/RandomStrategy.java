package nz.ac.auckland.se281;

public class RandomStrategy implements StrategyType {
  @Override
  public Integer getfingersBot(Game game) {
    // get random number of fingers from the AI (0 ~ 5)
    int fingersBot = Utils.getRandomNumberRange(0, 5);
    return fingersBot;
  }
}
