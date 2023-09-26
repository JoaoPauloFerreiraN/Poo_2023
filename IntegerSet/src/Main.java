// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        IntergerSet c1, c2, c3, cUnion, cIntersec;

        c1 = new IntergerSet();
        c2 = new IntergerSet();
        c3 = new IntergerSet();
        cUnion = new IntergerSet();
        cIntersec = new IntergerSet();

        c1.insertElement(2);
        c2.insertElement(2);
        c2.insertElement(7);
        c3.insertElement(9);
        c3.insertElement(2);
        cUnion = c1.union(c3);
        cIntersec = c1.intersection(c2);

        c1.toSetString();
        c2.toSetString();
        cUnion.toSetString();
        cIntersec.toSetString();

        c3.deleteElement(9);
        System.out.println(c1.isEqualTo(c2));
        System.out.println(c1.isEqualTo(c3));

    }
}