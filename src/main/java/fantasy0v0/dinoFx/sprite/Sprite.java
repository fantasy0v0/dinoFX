package fantasy0v0.dinoFx.sprite;

import fantasy0v0.dinoFx.resources.Resources;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public abstract class Sprite {

  protected final GraphicsContext graphicsContext;

  public Sprite(GraphicsContext graphicsContext) {
    this.graphicsContext = graphicsContext;
  }

  /**
   * @param x        x
   * @param y        y
   * @param resource 资源
   * @param dw       最终宽度
   * @param dh       最终高度
   */
  public void drawImage(double x, double y, Rectangle resource, double dw, double dh) {
    graphicsContext.drawImage(Resources.offlineResources1X,
      resource.getX(), resource.getY(),
      resource.getWidth(), resource.getHeight(),
      x, y,
      dw, dh);
  }

  /**
   * @param x        x
   * @param y        y
   * @param resource 资源
   */
  public void drawImage(double x, double y, Rectangle resource) {
    drawImage(x, y, resource, resource.getWidth(), resource.getHeight());
  }

  public abstract void update();

}