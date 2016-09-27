package MinimumBoundingRectangle;

public class Circle extends Shape{
	
	private int r;
	
	public Circle(int x, int y, int r) {
		super(x, y);
		this.r = r;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}
	
	

}
