package JavaLabs.FistSem.Lab1;
public class Int {
    private int value = 0;

    public Int(int val){
        value = val;
    }

    public void setValue(int x){
        this.value = x;
    }
    public int getValue(){
        return this.value;
    }
    public void increment(){
        this.value++;
    }
    public void decrement(){
        this.value--;
    }

    public void add(Int n){
        this.value += n.getValue();
    }
    public void subtract(Int n){
        this.value -= n.getValue();
    }

    public void power(Int pow){

        Int helper = new Int(this.value);
        int lim = this.value;
        for(int i = 1; i < pow.getValue(); i++){
            helper.setValue(this.getValue());
            for(int j = 1; j < lim; j++){
                this.add(helper);
            }
        }
    }

    public String toString() {
        String str = null;
        return (str.valueOf(this.value));
    }

}
