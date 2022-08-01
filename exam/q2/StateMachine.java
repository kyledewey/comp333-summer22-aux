public class StateMachine {
    public static void main(String[] args) {
        State curState = new State0();
        for (int count = 0; count < 5; count++) {
            curState.printString();
            curState = curState.transition();
        }
    }
}
