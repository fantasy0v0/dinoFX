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

  /**
   * 速度
   */
  private double jumpVelocity = -200;

  /**
   * 跳跃高度上限
   */
  private static final double minJumpHeight = 10;

  public Dino(GraphicsContext graphicsContext, Game game) {
    super(graphicsContext);
    this.game = game;
    animationMap.put(AnimationStatus.RUNNING, Animation.of(1000f / 12, ResourceDefinition.LDPI.TREX_RUN_0, ResourceDefinition.LDPI.TREX_RUN_1));
    animationMap.put(AnimationStatus.JUMPING, Animation.of(415, ResourceDefinition.LDPI.TREX_RUN_0, ResourceDefinition.LDPI.TREX_RUN_1));
    animationMap.put(AnimationStatus.DUCKING, Animation.of(1000f / 12, ResourceDefinition.LDPI.TREX_DUCK_0, ResourceDefinition.LDPI.TREX_DUCK_1));
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

      double maxHeight = game.getHeight() - currentFrame.getHeight() - 10;
      if (y < minJumpHeight) {
        y = minJumpHeight;
        jumpVelocity = Math.abs(jumpVelocity);
      } else if (y > maxHeight) {
        y = maxHeight;
        jumpVelocity = -jumpVelocity;
        animation.reset();
        animationStatus = AnimationStatus.RUNNING;
      }
    } else if (animationStatus.equals(AnimationStatus.DUCKING)) {

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
    if (animationStatus.equals(AnimationStatus.RUNNING)) {
      animationStatus = AnimationStatus.JUMPING;
      Resources.Sounds.BUTTON_PRESS.play();
    }
  }

  public void startDuck() {
    if (isPause) {
      return;
    }
    if (animationStatus.equals(AnimationStatus.RUNNING)) {
      animationStatus = AnimationStatus.DUCKING;
      // 设置新的y
      Animation animation = animationMap.get(animationStatus);
      Rectangle currentFrame = animation.getCurrentFrame();
      y = game.getHeight() - currentFrame.getHeight() - 10;
    }
  }

  public void endDuck() {
    if (isPause) {
      return;
    }
    if (animationStatus.equals(AnimationStatus.DUCKING)) {
      animationStatus = AnimationStatus.RUNNING;
      // 还原y
      double height = animationMap.get(animationStatus).getCurrentFrame().getHeight();
      y = game.getHeight() - height - 10;
    }
  }

  /**
   *
   */
  private enum AnimationStatus {

    WAITING,

    RUNNING,

    JUMPING,

    DUCKING

  }
}