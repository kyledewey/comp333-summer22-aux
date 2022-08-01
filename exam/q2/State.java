public interface State {
    public void printString();
    public State transition();
}

// public class State {
//     private final int stateNum;

//     public State(final int stateNum) {
//         this.stateNum = stateNum;
//     }

//     public void printString() {
//         if (stateNum == 0) {
//             System.out.println("alpha");
//         } else if (stateNum == 1) {
//             System.out.println("beta");
//         } else if (stateNum == 2) {
//             System.out.println("gamma");
//         } else {
//             System.out.println("Invalid state");
//         }
//     }
    
//     public State transition() {
//         if (stateNum == 0) {
//             return new State(1);
//         } else if (stateNum == 1) {
//             return new State(2);
//         } else if (stateNum == 2) {
//             return new State(0);
//         } else {
//             System.out.println("Invalid state");
//             return null;
//         }
//     }
// }
