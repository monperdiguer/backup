public class Circle
{
	// Attributes
	double radius;
	
	// Getters & Setters
	public double getRadius()
	{
		return radius;
	}
	public void setRadius(double value)
	{
		radius = value;
	}
	
	// Constructors
	public Circle()
	{
		this.setRadius(0);
	}
	public Circle(double value)
	{
		this.setRadius(value);
	}
	public Circle(Circle Other)
	{
		this.setRadius(Other.getRadius());
	}
	
	// Methods
	public double perimeter()
	{
		return 2 * Math.PI * this.getRadius();
	}
	public double area()
	{
		return Math.PI * Math.pow(this.getRadius(), 2);
	}
	
	@Override
    public String toString() 
	{
        return String.format("Circle [radius=%d]", this.getRadius());
    }
}