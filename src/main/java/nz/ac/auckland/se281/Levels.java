package nz.ac.auckland.se281;

/**
 * This interface is used to implement the Factory design pattern. It defines a method that must be
 * implemented by any class that specifies the level algorithm for different difficulty levels.
 */
public interface Levels {
  /**
   * This method is a method that will be implemented by the classes that implement this interface.
   * Each classes (EasyLevel, Medium, HardLevel) will have their own implementation of this method.
   *
   * @param fingers The number of fingers the AI will play
   * @param roundNumber The current round number
   * @param game The current game object
   */
  public void levelAlgorithm(int fingers, int roundNumber, Game game);
}
