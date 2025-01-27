
public class HelloWorld extends UserlandProcess {

    @Override
    void main() {
        while (true) {
            System.out.println("Hello world");
            cooperate();
        }
    }

}
