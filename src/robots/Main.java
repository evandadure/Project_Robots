package robots;

public class Main {

	public static void main(String[] args) {
		Source11 source = new Source11();
		source.addEvent1Listener(new FlotteListener());
		source.addEvent1Listener(new FlotteListener());
		source.addEvent1Listener(new FlotteListener());
		source.generateEvent1("droite");
	}

}
