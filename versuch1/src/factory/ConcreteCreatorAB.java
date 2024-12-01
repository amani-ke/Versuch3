package factory;

import java.io.IOException;

public class ConcreteCreatorAB extends Creator {

	@Override
	public Product factoryMethode(String typ) throws IOException {
		// TODO Auto-generated method stub
		if(typ.equals("csv")) {
			return new ConcreteProductA();
		}else {
			return new ConcretProductB();
		}
		
	}

}
