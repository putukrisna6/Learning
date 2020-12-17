package sprites;

import javax.swing.ImageIcon;

public class Brick extends Sprite{
	
	private boolean isDestroyed;
	
	@Override
	protected void loadImage() {
		ImageIcon ii = new ImageIcon("Resources/brick.png");
		image = ii.getImage();
	}
	
	public Brick(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		
		isDestroyed = false;
	}
	
	public boolean getIsDestroyed() {
		return isDestroyed;
	}
	public void setIsDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}
}
