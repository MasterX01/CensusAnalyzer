package censusanalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {

    String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
    String WRONG_INDIA_CENSUS_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    String INDIA_CENSUS_WRONG_TYPE = "./src/test/resources/IndiaStateCensusData.ppt";
    String WRONG_CENSUS_CSV_DELIMITER = "./src/test/resources/IndiaStateCensusDataWrongDelimiter.csv";
    String WRONG_CENSUS_CSV_HEADER = "./src/test/resources/WrongHeaderStateCensusData.csv";

    @Test
    public void givenIndianCensusCSVFile_ReturnsCorrectRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29,numOfRecords);
        } catch (CensusAnalyserException e) { }
    }

    @Test
    public void givenIndiaCensusData_withWrongFile_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_INDIA_CENSUS_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }

    @Test
    public void givenIndianCensusData_withCorrectFileButIncorrectType_ShouldThrowException(){
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_WRONG_TYPE);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_EXTENSION,e.type);
        }
    }

    @Test
    public void givenIndiaCensusCSVFile_WhenHavingWrongDelimiter_ShouldThrowException()  {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CENSUS_CSV_DELIMITER);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INTERNAL_FILE_ISSUES , e.type);
        }
    }

    @Test
    public void givenIndiaCensusCSVFile_WhenHavingWrongHeader_ShouldThrowException()  {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CENSUS_CSV_HEADER);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INTERNAL_FILE_ISSUES , e.type);
        }
    }

    private static final String STATE_CODE_CSV_FILE_PATH = "./src/test/resources/IndiaStateCode.csv" ;
    private static final String WRONG_STATE_CODE_CSV_FILE_PATH = "./src/main/resources/IndiaStateCode.csv" ;
    private static final String WRONG_STATE_CODE_CSV_FILE_EXTENSION = "./src/test/resources/IndiaStateCode.ppt" ;
    private static final String WRONG_STATE_CODE_CSV_INTERNAL_FILE_ISSUES = "./src/test/resources/IndiaStateCodeInternalFileIssues.csv" ;

    @Test
    public void givenStateCensusCSVFile_ShouldMatchNumberOfRecordsInFile() {
        try {
            CensusAnalyser codeAnalyser = new CensusAnalyser();
            int count = codeAnalyser.loadStateCodeData(STATE_CODE_CSV_FILE_PATH);
            Assert.assertEquals(37 , count);
        }catch (CensusAnalyserException e) { }
    }

    @Test
    public void givenStateCensusCSVFile_WhenPathIsIncorrect_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadStateCodeData(WRONG_INDIA_CENSUS_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM , e.type);
        }
    }

    @Test
    public void GivenStateCensusCSVFile_WhenFileExtensionIncorrect_ShouldThrowException()  {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadStateCodeData(WRONG_STATE_CODE_CSV_FILE_EXTENSION);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_EXTENSION , e.type);
        }
    }

    @Test
    public void givenStateCensusCSVFile_WhenHavingWrongDelimiter_ShouldThrowException()  {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadStateCodeData(WRONG_STATE_CODE_CSV_INTERNAL_FILE_ISSUES);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INTERNAL_FILE_ISSUES , e.type);
        }
    }

    @Test
    public void givenStateCensusCSVFile_WhenHavingWrongHeader_ShouldThrowException()  {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadStateCodeData(WRONG_STATE_CODE_CSV_INTERNAL_FILE_ISSUES);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INTERNAL_FILE_ISSUES , e.type);
        }
    }

}
