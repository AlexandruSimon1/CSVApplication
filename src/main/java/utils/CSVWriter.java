package utils;

import model.Model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {
    public static void writeStat(int invalidColumn, String[] record, List<Model> recordList){
        int recordsReceived = record.length;
        try {
            String logfile = "logFile.txt";
            String statistics = "Following are the statistics :\r\n#"+recordsReceived+ " of records received.\r\n#"
                    + recordList.size() + " of records processed. \r\n#" + invalidColumn + " of records failed.";
            FileWriter fileWriter = new FileWriter(logfile);
            fileWriter.write(statistics);
            fileWriter.close();
        } catch (IOException e) {
        }  catch(NullPointerException ex) {
        }
    }
}
