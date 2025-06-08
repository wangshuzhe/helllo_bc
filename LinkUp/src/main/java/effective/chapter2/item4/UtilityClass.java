package effective.chapter2.item4;

/**
 * Noninstantiable utility class (page 19)
 */
public class UtilityClass {
    //Suppress default constructor for noninstantiability
    private UtilityClass() {
        throw new AssertionError();
    }
    //Remainder omitted
}
