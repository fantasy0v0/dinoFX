package fantasy0v0.dinoFx.resources;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

import java.io.IOException;
import java.io.InputStream;

public final class Resources {

  private Resources() {
  }

  public static final Image offlineResources1X;

  public static final Image offlineResources2X;

  static {
    try (InputStream offlineResources1XResource = Resources.class.getModule().getResourceAsStream("offline-resources-1x.png");
         InputStream offlineResources2XResource = Resources.class.getModule().getResourceAsStream("offline-resources-2x.png")) {
      offlineResources1X = new Image(offlineResources1XResource);
      offlineResources2X = new Image(offlineResources2XResource);
    } catch (IOException e) {
      throw new RuntimeException("资源加载失败", e);
    }
  }

  public static void load() {
    Sounds.load();
  }

  public static final class Sounds {

    private Sounds() {

    }

    /**
     * 按钮按下
     */
    public final static AudioClip BUTTON_PRESS = new AudioClip(
      Sounds.class.getResource("/sounds/BUTTON_PRESS.wav").toExternalForm());

    /**
     * 碰撞
     */
    public final static AudioClip HIT = new AudioClip(
      Sounds.class.getResource("/sounds/HIT.wav").toExternalForm());

    /**
     * 碰撞
     */
    public final static AudioClip SCORE = new AudioClip(
      Sounds.class.getResource("/sounds/SCORE.wav").toExternalForm());

    public static void load() {

    }

  }

}
