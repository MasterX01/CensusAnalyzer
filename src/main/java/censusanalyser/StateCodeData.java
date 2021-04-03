package censusanalyser;

import com.opencsv.bean.CsvBindByName;

public class StateCodeData {
    @CsvBindByName(column = "SrNo")
    public int serial;
    @CsvBindByName(column = "State Name")
    public String state;
    @CsvBindByName(column = "TIN")
    public long tin;
    @CsvBindByName(column = "State Code")
    public long stateCode;
}
