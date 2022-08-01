public class State1 implements State {
    public void printString() {
        System.out.println("beta");
    }
    
    public State transition() {
        return new State2();
    }
}
