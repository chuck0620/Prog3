package lab5;
import lab5.Producer;
import lab5.Fifo;
import lab5.Consumer;
public class Application {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Fifo f1 = new Fifo();
		Producer uj1 = new Producer(f1, "teszt1", 1000);
		Consumer c1 = new Consumer(f1, "proba1" , 100);
		uj1.start();
		c1.start();
	}

}
