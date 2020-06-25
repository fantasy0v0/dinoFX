package fantasy0v0.dinoFx.sprite;

import fantasy0v0.dinoFx.utils.Time;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Dino extends Sprite {

  private final Game game;

  private double x = 0;

  private boolean isPause = false;

  private Animation animation;

  public Dino(GraphicsContext graphicsContext, Game game) {
    super(graphicsContext);
    this.game = game;
    animation = Animation.of(1000f / 12 / 1000, ResourceDefinition.LDPI.TREX_RUN_0, ResourceDefinition.LDPI.TREX_RUN_1);
  }

  @Override
  public void update() {
    Rectangle currentFrame = animation.getCurrentFrame();
    double y = game.getHeight() - currentFrame.getHeight() - 10;
    drawImage(x, y, currentFrame);
    if (isPause) {
      return;
    }
    if (x > game.getWidth()) {
      x = -44;
    } else {
      x += Time.deltaTime * 120;
    }
    animation.update();
  }

  public void pause() {
    isPause = true;
  }

  public void resume() {
    isPause = false;
  }
}
