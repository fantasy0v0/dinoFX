package fantasy0v0.dinoFx.sounds;

import javafx.scene.media.AudioClip;

/**
 * 音效资源
 * <p>
 * Fan 1/16/2020
 */
public final class SoundResource {

  /**
   * 按钮按下
   */
  public final static AudioClip BUTTON_PRESS = new AudioClip(
    SoundResource.class.getResource("/sounds/BUTTON_PRESS.mp3").toExternalForm());

  /**
   * 碰撞
   */
  public final static AudioClip HIT = new AudioClip(
    SoundResource.class.getResource("/sounds/HIT.mp3").toExternalForm());

  /**
   * 碰撞
   */
  public final static AudioClip SCORE = new AudioClip(
    SoundResource.class.getResource("/sounds/SCORE.mp3").toExternalForm());

  private SoundResource() {

  }
}
