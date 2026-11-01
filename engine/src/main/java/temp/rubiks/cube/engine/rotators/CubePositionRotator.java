package temp.rubiks.cube.engine.rotators;

// TODO write unit test for this class
public class CubePositionRotator {

    public static Pair left(int x, int y) {
        if (x==0) {
            return new Pair(-y, 0);
        }
        if (y==0) {
            return new Pair(0, x);
        }
        if (x==-1 && y==-1) {
            return new Pair(1, -1);
        } else if (x==1 && y==-1) {
            return new Pair(1, 1);
        } else if (x==1 && y==1) {
            return new Pair(-1, 1);
        } else {
            return new Pair(-1, -1);
        }
    }

    public static Pair right(int x, int y) {
        if (x==0) {
            return new Pair(y, 0);
        }
        if (y==0) {
            return new Pair(0, -x);
        }
        if (x==-1 && y==-1) {
            return new Pair(-1, 1);
        } else if (x==-1 && y==1) {
            return new Pair(1, 1);
        } else if (x==1 && y==1) {
            return new Pair(1, -1);
        } else {
            return new Pair(-1, -1);
        }
    }

    public record Pair(int x, int y) {}

}
