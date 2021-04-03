package censusanalyser;

public class InputValidator {
    private static final String EXTENSION_REGEX = ".*.csv$";
    IPattern iPattern;
    public InputValidator() {
        iPattern = ((input, pattern) -> input.matches(pattern));
    }
    public boolean validateFileExtension(String path) throws CensusAnalyserException {
        return iPattern.matchPattern(path , EXTENSION_REGEX);
    }

}
