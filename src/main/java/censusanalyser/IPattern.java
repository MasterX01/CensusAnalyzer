package censusanalyser;

@FunctionalInterface
public interface IPattern {
    boolean matchPattern(String input, String pattern);
}
