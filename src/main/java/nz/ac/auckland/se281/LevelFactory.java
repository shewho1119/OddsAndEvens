package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class LevelFactory {
  public static Levels createLevels(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new EasyLevel();

      case MEDIUM:
        return new Medium();

      case HARD:
        return new HardLevel();
    }
    return null;
  }
}
