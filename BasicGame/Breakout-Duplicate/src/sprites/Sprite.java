package sprites;

import java.awt.Image;
import java.awt.Rectangle;

public abstract class Sprite {
	protected int x;
	protected int y;
	private int imageWidth;
	private int imageHeight;
	
	Image image;

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getImageWidth() {
		return imageWidth;
	}
	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}
	public int getImageHeight() {
		return imageHeight;
	}
	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}
	public Image getImage() {
		return image;
	}
	
	// for collision purposes
	public Rectangle getRect() {
		return new Rectangle(
				x, y,
				image.getWidth(null), image.getHeight(null)
				);
	}
	void getImageDimensions() {
		imageWidth = image.getWidth(null);
		imageHeight = image.getHeight(null);
	}
	
	protected abstract void loadImage();
	
	public Sprite() {
		loadImage();
		getImageDimensions();
	}
}
