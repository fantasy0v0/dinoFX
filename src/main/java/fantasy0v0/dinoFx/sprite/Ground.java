package fantasy0v0.dinoFx.sprite;

import fantasy0v0.dinoFx.resources.Resources;
import fantasy0v0.dinoFx.utils.Time;
import javafx.scene.canvas.GraphicsContext;

public class Ground {

  private final GraphicsContext graphicsContext;

  private final Game game;

  private double x = 0;

  private double sx = 600;

  private boolean isPause = false;

  public Ground(GraphicsContext graphicsContext, Game game) {
    this.graphicsContext = graphicsContext;
    this.game = game;
  }

  public void update() {
    if (!isPause) {
      double distance = Time.deltaTime * 120;
      x -= distance;
      sx -= distance;
      if (x <= -game.getWidth()) {
        x = game.getWidth();
      }
      if (sx <= -game.getWidth()) {
        sx = game.getWidth();
      }
    }
    graphicsContext.drawImage(
      Resources.offlineResources1X,
      SpriteDefinition.LDPI.HORIZON.getX(), SpriteDefinition.LDPI.HORIZON.getY(),
      SpriteDefinition.LDPI.HORIZON.getWidth(), SpriteDefinition.LDPI.HORIZON.getHeight(),
      x, 100,
      SpriteDefinition.LDPI.HORIZON.getWidth(), SpriteDefinition.LDPI.HORIZON.getHeight()
    );
    graphicsContext.drawImage(
      Resources.offlineResources1X,
      SpriteDefinition.LDPI.HORIZON.getX() + game.getWidth(), SpriteDefinition.LDPI.HORIZON.getY(),
      SpriteDefinition.LDPI.HORIZON.getWidth(), SpriteDefinition.LDPI.HORIZON.getHeight(),
      sx, 100,
      SpriteDefinition.LDPI.HORIZON.getWidth(), SpriteDefinition.LDPI.HORIZON.getHeight()
    );
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
