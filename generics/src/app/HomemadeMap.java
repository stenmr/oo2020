package app;

class HomemadeMap<T1, T2> {

    private T1 key;
    private T2 value;

    public HomemadeMap(T1 key, T2 value) {
        super();
        this.key = key;
        this.value = value;
    }

    T1 getKey() {
        return this.key;
    }

    T2 getValue() {
        return this.value;
    }
}