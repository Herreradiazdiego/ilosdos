public class counterprofe {

    protected long count = 0;

    public counterprofe() {
        this.count = 0;
    }

    public counterprofe(long n) {
        this.count = n;

    }

    public void add(long value){
        this.count = this.count + value;
    }

    public long get() {
        return this.count;
    }

}