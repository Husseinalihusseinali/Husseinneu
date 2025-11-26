package fabrik;

public class ConcreteCafeTXTCreator extends Creator {

	
	public Product factoryMethod() throws Exception {
		return new ConcreteCafeTXTProduct();
	}
}
