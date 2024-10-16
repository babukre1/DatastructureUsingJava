public class Pair<T, U> {
    T first;
    U second;
    Pair(T first, U second){
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public String toString() {
        return "Pair{first=" + first +
                ", second=" + second + "}";
    }


}
