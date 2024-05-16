package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class LevelFactory {
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
