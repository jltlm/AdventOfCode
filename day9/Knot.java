package day9;

public class Knot {
    private int id;
    private int x;
    private int y;
    public int count;

    public Knot(int id) {
        this.id = id;
        this.x = 0;
        this.y = 0;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(int x, int y) {
        this.x += x;
        this.y += y;
        count++;
    }
    
    public void move(int hx, int hy, int b) {
        // System.out.println(head.toString());

        if (Math.abs(hx - this.x) <= 1 && Math.abs(hy - this.y) <= 1) {
            count ++;
            return;
        } else if (Math.abs(hx - this.x) > 1) {
            if (hy > this.y) {
                this.y += 1;
            } else if (hy < this.y) {
                this.y -= 1;
            }
            if (hx < this.x) {
                this.x -= 1;
            } else {
                this.x += 1;
            }
        } else {
            if (hx > this.x) {
                this.x += 1;
            } else if (hx < this.x) {
                this.x -= 1;
            }
            if (hy > this.y) {
                this.y += 1;
            } else {
                this.y -= 1;
            }
        }

        count++;
    }

    @Override
    public String toString() {
        return id + ": " + this.x + " " + this.y;
    }

}
