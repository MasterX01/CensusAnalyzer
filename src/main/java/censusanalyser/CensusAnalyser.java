package censusanalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CensusAnalyser {
    public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException {
        int numOfEntries = 0;
        try {
            InputValidator inputValidator = new InputValidator();
            boolean result = inputValidator.validateFileExtension(csvFilePath);
            if (!result)
                throw new CensusAnalyserException("Please check extension of your file", CensusAnalyserException.ExceptionType.INCORRECT_EXTENSION);

            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndiaCensusCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();;
            Iterable<IndiaCensusCSV> iterable = () -> censusCSVIterator;
            numOfEntries = (int) StreamSupport.stream(iterable.spliterator(), false).count();
        } catch (IOException e) {
            throw new CensusAnalyserException("File Path Issues", CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        } catch (IllegalStateException e) {
            throw new CensusAnalyserException("Parsing Error", CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
        } catch (RuntimeException e) {
            throw new CensusAnalyserException("Delimiter Error", CensusAnalyserException.ExceptionType.INTERNAL_FILE_ISSUES);
        }
        return numOfEntries;
    }
}
