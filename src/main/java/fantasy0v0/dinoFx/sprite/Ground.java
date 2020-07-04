package fantasy0v0.dinoFx.sprite;

import fantasy0v0.dinoFx.utils.Time;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Ground extends Sprite {

  private final Game game;

  private double x = 0;

  private double sx;

  private boolean isPause = false;

  public Ground(GraphicsContext graphicsContext, Game game) {
    super(graphicsContext);
    this.game = game;
    sx = ResourceDefinition.LDPI.HORIZON.getWidth();
  }

  @Override
  public void update() {
    Rectangle resource = ResourceDefinition.LDPI.HORIZON;
    double y = game.getHeight() - resource.getHeight() - 10;
    drawImage(x, y, resource);
    if (!isPause) {
      double distance = Time.deltaTime * 120;
      x -= distance;
      if (x < -resource.getWidth()) {
        x = resource.getWidth();
        sx = 0;
      } else if (x < 0) {
        sx = x + resource.getWidth();
      } else if (x > 0) {
        sx = x - resource.getWidth();
      } else {
        sx = resource.getWidth();
      }
    }
    drawImage(sx, y, resource);
    System.out.println("x:" + x + ", sx:" + sx);
  }

  public void pause() {
    isPause = true;
  }

  public void resume() {
    isPause = false;
  }

  public void reset() {
    x = 0;
  }

}
