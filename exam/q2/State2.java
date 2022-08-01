public class State2 implements State {
    public void printString() {
        System.out.println("gamma");
    }
    
    public State transition() {
        return new State0();
    }
}
