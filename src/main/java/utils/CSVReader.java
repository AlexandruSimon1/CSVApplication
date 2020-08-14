package utils;

import model.Model;

import java.io.*;
import java.util.*;

public class CSVReader {
    public static String[] record = null;
    static int validColumnCount = 11;
    public static int invalidColumn = 0;
    public static void readCVSfile() {
        String csvFile = "Interview-task-data-osh (2).csv";
        List<Model> recordList = new ArrayList<Model>();
        boolean headerRow = true;
        String line;
        String delimitation = ",";
        try {
            File file = new File(csvFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            if (headerRow) {
                String HeadRow = br.readLine();
                if (HeadRow == null || HeadRow.isEmpty()) {
                    throw new FileNotFoundException(
                            "No columns defined in given CSV file." + "Please check the CSV file format.");
                }
            }
            while ((line = br.readLine()) != null) {
                record = line.split(delimitation);
                if (record.length > 0 && record.length == validColumnCount) {
                    String mergeTwoRecords = record[4] + record[5];
                    Model model = new Model(record[0], record[1], record[2], record[3], mergeTwoRecords, record[6],
                            Float.parseFloat(record[7].replace('$', ' ')), record[8], record[9], record[10]);
                    recordList.add(model);
                } else {
                    invalidColumn++;
                }
            }
            CSVLoader.LoadCSVIntoDatabase(recordList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
