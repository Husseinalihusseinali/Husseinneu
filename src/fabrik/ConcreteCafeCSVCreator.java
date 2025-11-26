package fabrik;

public class ConcreteCafeCSVCreator extends Creator {

	
	public Product factoryMethod() throws Exception {
		return new ConcreteCafeCSVProduct();
	}
}
