package JavaLabs.FistSem.Lab1;
public class Main {
    public static void main(String[] args) {

        Int val1 = new Int(1002);
        System.out.println("Current value 1: " + val1.toString());
        System.out.println("Increment demonstration: ");
        val1.increment();
        System.out.println(val1);
        System.out.println("Decrement demonstration: ");
        val1.decrement();
        System.out.println(val1);

        for(val1.increment(); val1.getValue() < 1000; val1.add(val1)){ }
        while(val1.getValue() > 1000) { val1.decrement(); }
        System.out.println("Task demonstration: ");
        System.out.println(val1);

        /*
        Int valnew = new Int(2);
        Int val2 = new Int(10);
        System.out.println(valnew + " to the power of " + val2 + ": ");
        valnew.power(val2);
        System.out.println(valnew);
        */
    }
}
