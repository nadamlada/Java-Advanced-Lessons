package JA13GenericsLab.L03GenericScale;

public class Scale<T extends Comparable<T>> {
    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        //сравнява и интове, и дъбъли и стрингове
        if (left.compareTo(right) == 0) {
            return null;
        }

        if (left.compareTo(right) > 0) {
            return left;
        }

        return right;
    }
}
