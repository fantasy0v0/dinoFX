package fantasy0v0.dinoFx.utils;

public class Time {

  /**
   * 1秒换算成纳秒
   */
  public static final long second = 1_000_000_000L;

  public static double fps = 0;

  public static long deltaTime = 0;

  private static long lastTime = 0;

  public static void update(long now) {
    deltaTime = now - lastTime;
    lastTime = now;
    fps = second * 1f / (deltaTime > 0 ? deltaTime : second);
  }
}
