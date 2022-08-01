public class State0 implements State {
    public void printString() {
        System.out.println("alpha");
    }
    
    public State transition() {
        return new State1();
    }
}
