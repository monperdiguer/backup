public class Point
{
	// Attributes
	int x;
	int y;

	// Getters & Setters
	public int getX()
	{
		return x;
	}
	public void setX(int value)
	{
		x = value;
	}
	public int getY()
	{
		return y;
	}
	public void setY(int value)
	{
		y = value;
	}
	
	// Constructors
	public Point()
	{
		x = y = 0;
	}
	public Point(int valueX, int valueY)
	{
		this.setX(valueX);
		this.setY(valueY);
	}
	public Point(Point Other)
	{
		this.setX(Other.getX());
		this.setY(Other.getX());
	}
	public void setOther(Point other) {
		this.setOther(other);
	}
	public double getCentreX () {
		return (x + this.getX())/2.0;
	}
	public double getCentreY () {
		return (y + this.getY())/2.0;
	}
	// Others
	public static double distance(Point p1, Point p2) 
	{
	    return Math.sqrt(Math.pow(p2.getX()-p1.getX(), 2) + Math.pow(p2.getY()-p1.getY(), 2));
	}

	
	@Override
    public String toString() 
	{
        return String.format("Point [x=%d, y=%d]", this.getX(), this.getY());
    }
	
	
}