package fantasy0v0.dinoFx.sprite;

import fantasy0v0.dinoFx.resources.Resources;
import fantasy0v0.dinoFx.utils.Time;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;
import java.util.Map;

public class Dino extends Sprite {

  private final Game game;

  private double y;

  private boolean isPause = false;

  private AnimationStatus animationStatus = AnimationStatus.RUNNING;

  private final Map<AnimationStatus, Animation> animationMap = new HashMap<>();

  private double jumpVelocity = -200;

  public Dino(GraphicsContext graphicsContext, Game game) {
    super(graphicsContext);
    this.game = game;
    animationMap.put(AnimationStatus.RUNNING, Animation.of(1000f / 12, ResourceDefinition.LDPI.TREX_RUN_0, ResourceDefinition.LDPI.TREX_RUN_1));
    animationMap.put(AnimationStatus.JUMPING, Animation.of(415, ResourceDefinition.LDPI.TREX_RUN_0, ResourceDefinition.LDPI.TREX_RUN_1));
    double height = animationMap.get(animationStatus).getCurrentFrame().getHeight();
    y = game.getHeight() - height - 10;
  }

  @Override
  public void update() {
    Animation animation = animationMap.get(animationStatus);
    Rectangle currentFrame = animation.getCurrentFrame();
    double x = 20;
    drawImage(x, y, currentFrame);
    if (isPause) {
      return;
    }

    animation.update();
    if (animationStatus.equals(AnimationStatus.JUMPING)) {
      y += this.jumpVelocity * Time.deltaTime;
      double minHeight = 10;
      double maxHeight = game.getHeight() - currentFrame.getHeight() - 10;
      if (y < minHeight) {
        y = minHeight;
        jumpVelocity = Math.abs(jumpVelocity);
      } else if (y > maxHeight) {
        y = maxHeight;
        jumpVelocity = -jumpVelocity;
        animation.reset();
        animationStatus = AnimationStatus.RUNNING;
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