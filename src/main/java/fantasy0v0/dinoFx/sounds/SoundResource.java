package fantasy0v0.dinoFx.sounds;

import javafx.scene.media.AudioClip;

/**
 * 音效资源
 *
 * Fan 1/16/2020
 */
public final class SoundDefinition {

  /**
   * 按钮按下
   */
  public final static AudioClip BUTTON_PRESS = new AudioClip(
    SoundDefinition.class.getResource("/sounds/BUTTON_PRESS.wav").toExternalForm());

  /**
   * 碰撞
   */
  public final static AudioClip HIT = new AudioClip(
    SoundDefinition.class.getResource("/sounds/HIT.wav").toExternalForm());

  /**
   * 碰撞
   */
  public final static AudioClip SCORE = new AudioClip(
    SoundDefinition.class.getResource("/sounds/SCORE.wav").toExternalForm());

  private SoundDefinition() {

  }
}
