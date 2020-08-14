# CSVApplication
CSV Application that will read a csv file and upload the records in SQLite DB

My approach for the test was to created different classes for the needed functionalities.
Used the IntelliJ IDEA.

I created the class Model in order to be able to save the information from CSV file to SQLite database accordingly to every column and row.
And providing for every row a field.

In order to read the information from CSV file I used BufferedReading parsing the data using column by column.
For storing the data I used an collection Array, to store the data one by one I used List of objects. 
To load the data from CSV file into a database I used JDBC API in order to interact with SQLite database and inserting the data in the correspondingly columns.

In order to run the code will be need to save the CSV file in main package CSVApplication or in any other new package.
In order to don't have duplicates in the SQLite database file will be need to create a new one or remove the data from existing one.

JAR File directon : https://bitbucket.org/xerial/sqlite-jdbc/downloads/
