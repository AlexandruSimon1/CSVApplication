package utils;

import model.Model;

import java.sql.*;
import java.util.List;

import static utils.CSVReader.*;

public class CSVLoader {
    public static void LoadCSVIntoDatabase(List<Model> recordList) {
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:X.db");
            for (Model m : recordList) {
                String sql = "INSERT INTO X (A, B, C, D, E,F,G,H,I,J) VALUES (?, ?, ?, ?, ?, ?, ?, ? ,? ,?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, m.getA());
                preparedStatement.setString(2, m.getB());
                preparedStatement.setString(3, m.getC());
                preparedStatement.setString(4, m.getD());
                preparedStatement.setString(5, m.getE());
                preparedStatement.setString(6, m.getF());
                double real = m.getG();
                double roundG = Math.round(real * 100.0) / 100.0;
                preparedStatement.setDouble(7, roundG);
                preparedStatement.setString(8, m.getH());
                preparedStatement.setString(9, m.getI());
                preparedStatement.setString(10, m.getJ());
                preparedStatement.executeUpdate();
            }
        } catch (NullPointerException NPE) {
            System.out.println("Records Uploaded");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }
        CSVWriter.writeStat(invalidColumn, record, recordList);
    }
}
