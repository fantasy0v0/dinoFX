package fantasy0v0.dinoFx.sounds;

import javafx.scene.media.AudioClip;

/**
 * 音效
 *
 * Fan 1/16/2020
 */
public final class SoundDefinition {

  /**
   * 按钮按下
   */
  public final static AudioClip BUTTON_PRESS = new AudioClip(
    SoundDefinition.class.getResource("/sounds/BUTTON_PRESS.mp3").toExternalForm());

  /**
   * 碰撞
   */
  public final static AudioClip HIT = new AudioClip(
    SoundDefinition.class.getResource("/sounds/HIT.mp3").toExternalForm());

  /**
   * 碰撞
   */
  public final static AudioClip SCORE = new AudioClip(
    SoundDefinition.class.getResource("/sounds/SCORE.mp3").toExternalForm());

  private SoundDefinition() {

  }
}
