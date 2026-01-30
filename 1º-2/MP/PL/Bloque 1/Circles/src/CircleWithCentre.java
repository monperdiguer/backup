public class CircleWithCentre {
	
	private Circle circle;
	private Point point;
	
	// three-argument constructor
	public CircleWithCentre (int x, int y, double radius, Point other)
	{
		// implicit call to Object constructor occurs here
		point = new Point (x, y);
		circle = new Circle (radius);
		other = new Point (point);
	}
	
	public double getRadius(){
	
		return circle.getRadius();
	}
	
	public void setRadius(double radius) {
		
		circle.setRadius(radius);
	}
	
	public double getCentreX() {
		
		return point.getCentreX();
	}
	
	public double getCentreY() {
		
		return point.getCentreY();
		
	}
	
	public void setCentre(Point other) {
		
		point.setOther(other);
	}
	
	public void setCentre(int x, int y) {
		
		point.setX(x);
		point.setY(y);	
	}
	
	//Methods
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
        return String.format("Circle with Center [radius=%d, centre=%d]", this.getRadius(), this.getCentre());
         
    }
	public boolean overlaps(CircleWithCenter circlewithcenter) {
		if(this.CircleWithCenter == circlewithcenter)
			return true;
		else return false;
	}

}
