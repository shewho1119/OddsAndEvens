package nz.ac.auckland.se281;

public interface Levels {
  /**
   * This method is a method that will be implemented by the classes that implement this interface.
   * Each classes (EasyLevel, MediumLevel, HardLevel) will have their own implementation of this
   * method.
   *
   * @param fingers The number of fingers the AI will play
   * @param roundNumber The current round number
   * @param game The current game object
   */
  public void levelAlgorithm(int fingers, int roundNumber, Game game);
}
