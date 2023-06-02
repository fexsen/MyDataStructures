package JavaLabs.FistSem.Lab2;

public class Circle {

    private final int x;
    private final int y;
    private int rad;

    public Circle(int x, int y, int r){
        this.x = x;
        this.y = y;
        this.rad = r;
    }

    public boolean isInside(int x2, int y2){
        return !(Math.sqrt(Math.pow((x - x2), 2) + Math.pow((y - y2), 2)) > rad);
    }

    public void zoom(int factor){
        rad *= factor;
    }

}
