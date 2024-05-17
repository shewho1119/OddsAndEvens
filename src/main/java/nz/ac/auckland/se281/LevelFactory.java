package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

/**
 * This class is used to create a level based on the difficulty that the player has chosen.
 *
 * @author Shihoo Park
 */
public class LevelFactory {

  /**
   * This method returns a corresponding level based on the difficulty that the player specified. It
   * is part of the factory design pattern.
   *
   * @param difficulty The difficulty level the human player has chosen.
   * @return Levels The class that corresponds to the difficulty level.
   */
  public static Levels createLevels(Difficulty difficulty) {
    // create the level based on the difficulty the user has chosen
    switch (difficulty) {
      case EASY:
        return new EasyLevel();

      case MEDIUM:
        return new Medium();

      case HARD:
        return new HardLevel();
    }
    // if the difficulty is not valid, return null
    return null;
  }
}
