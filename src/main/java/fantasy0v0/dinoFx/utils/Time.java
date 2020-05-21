package fantasy0v0.dinoFx.utils;

public class Time {

  /**
   * 1秒换算成纳秒
   */
  public static final long second = 1_000_000_000L;

  public static double fps = 0;

  /**
   * 每帧耗时, 单位:秒
   */
  public static double deltaTime = 0;

  private static long lastTime = 0;

  public static void update(long now) {
    if (0 != lastTime) {
      deltaTime = (now - lastTime) / (double) second;
    }
    lastTime = now;
    fps = deltaTime > 0 ? 1 / deltaTime : second;
  }
}
