public class Car {
	
	public abstract class CC{
		
	
		public void left() {
		
		
	}
	
	abstract public void right();
		
	public void middle() {
		
	}
		}


	public class Bike extends CC{

		public void right() {
			
		}
		
		
		
		@Override
		public void left() {
		
		}
	
	}

	Bike mini = new Bike();
	
	
}