package statistics.matcher;

public class QueryBuilder {

    Matcher matcher;

    public QueryBuilder() {
        this.matcher = new All();
    }

    public Matcher build() {
        Matcher m = this.matcher;
        this.matcher = new All();
        return m;
    }

    public QueryBuilder playsIn(String team) {
        this.matcher = new And(new PlaysIn(team), matcher);
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String fieldname) {
        this.matcher = new And(new HasAtLeast(value, fieldname), matcher);
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String fieldname) {
        this.matcher = new And(new HasFewerThan(value, fieldname), matcher);
        return this;
    }

    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        this.matcher = new Or(m1, m2);
        return this;
    }

    public QueryBuilder not(Matcher m) {
        this.matcher = new Not(m);
        return this;
    }

}
