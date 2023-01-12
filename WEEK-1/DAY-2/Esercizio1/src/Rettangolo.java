
public class Rettangolo {

//	Properties
	double h;
	double w;

//	Constructor
	public Rettangolo(double h, double w) {
		this.h = h;
		this.w = w;
	}

//	Methods
	
//	Perimeter
	public double perimeter() {
		return (this.h*2)+(this.w*2);
	}

//	Area
	public double area() {
		return this.h*this.w;
	}
	
//	PrintRectangle
	public String printR() {
		return "The area of your rectangle is " + this.area() + " and the perimeter is " + this.perimeter();
	}
	
//	Print2Rectangle
	public static String print2R(Rettangolo f, Rettangolo s) {
		return "The area of the first rectangle is " + f.area() + " and the perimeter is " + f.perimeter() +
				" The area of the second rectangle is " + s.area()  + " and the perimeter is " + s.perimeter() +
				" The sum of the areas is " + (f.area() + s.area()) + " and the sum of the perimeters is " + (f.perimeter() + s.perimeter());
	}
	
}
