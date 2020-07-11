package fantasy0v0.dinoFx.sprite;

import fantasy0v0.dinoFx.utils.Time;
import javafx.scene.shape.Rectangle;

public class Animation {

  private int index = 0;

  private Rectangle[] frames;

  private double secPerFrame;

  private double time = 0;

  private Animation() {

  }

  public void update() {
    time += Time.deltaTime;
    index = (int) Math.floor(time / secPerFrame) + index;
    index %= frames.length;
    time = time % secPerFrame;
  }

  public Rectangle getCurrentFrame() {
    return frames[index];
  }

  public static Animation of(double msPerFrame, Rectangle... frames) {
    Animation animation = new Animation();
    animation.secPerFrame = msPerFrame / 1000;
    animation.frames = frames;
    return animation;
  }
}
