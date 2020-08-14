import model.Model;
import utils.CSVLoader;
import utils.CSVReader;
import utils.CSVWriter;

import java.util.List;

import static utils.CSVReader.*;

public class Main {
    static List<Model> recordList;
    public static void main(String[] args) {
        Main test = null;
        System.out.println("Reading file ...");
        CSVReader.readCVSfile();
        CSVWriter.writeStat(invalidColumn, record, recordList);
        CSVLoader.LoadCSVIntoDatabase(test.recordList);
    }
}
