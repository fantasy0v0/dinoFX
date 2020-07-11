package fantasy0v0.dinoFx.sprite;

import fantasy0v0.dinoFx.resources.Resources;
import fantasy0v0.dinoFx.utils.Time;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;
import java.util.Map;

public class Dino extends Sprite {

  private final Game game;

  private double x = 20;

  private double y;

  private boolean isPause = false;

  private int direction = 0;

  private AnimationStatus animationStatus = AnimationStatus.RUNNING;

  private final Map<AnimationStatus, Animation> animationMap = new HashMap<>();

  public Dino(GraphicsContext graphicsContext, Game game) {
    super(graphicsContext);
    this.game = game;
    y = game.getHeight() - 47 - 10;
    animationMap.put(AnimationStatus.RUNNING, Animation.of(1000f / 12, ResourceDefinition.LDPI.TREX_RUN_0, ResourceDefinition.LDPI.TREX_RUN_1));
    animationMap.put(AnimationStatus.JUMPING, Animation.of(1000, ResourceDefinition.LDPI.TREX_RUN_0));
  }

  @Override
  public void update() {
    Animation animation = animationMap.get(animationStatus);
    Rectangle currentFrame = animation.getCurrentFrame();
    drawImage(x, y, currentFrame);
    if (isPause) {
      return;
    }

    animation.update();
    if (animationStatus.equals(AnimationStatus.JUMPING)) {
      double jumpVelocity = Time.deltaTime * 120;
      if (direction == 0) {
        y -= jumpVelocity;
        if (y < currentFrame.getHeight()) {
          direction = 1;
        }
      } else {
        double maxHeight = game.getHeight() - currentFrame.getHeight() - 10;
        if (maxHeight > y) {
          y += jumpVelocity;
        } else {
          y = maxHeight;
          direction = 0;
          animationStatus = AnimationStatus.RUNNING;
        }
      }
    }
  }

  public void pause() {
    isPause = true;
  }

  public void resume() {
    isPause = false;
  }

  public void jump() {
    if (isPause) {
      return;
    }
    if (!animationStatus.equals(AnimationStatus.JUMPING)) {
      animationStatus = AnimationStatus.JUMPING;
      Resources.Sounds.BUTTON_PRESS.play();
    }
  }

  /**
   *
   */
  private enum AnimationStatus {

    WAITING,

    RUNNING,

    JUMPING

  }
}