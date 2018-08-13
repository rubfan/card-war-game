package game.config;

import game.repository.helper.QueryHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author ruslangramatic on 4/14/18.
 */
public class DeployDbConfig {
    private static final Properties dbProperties = new Properties();
    static {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String dbConfigPath = rootPath + "config/db.properties";
        try {
            dbProperties.load(new FileInputStream(dbConfigPath));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final String DB_USER = dbProperties.getProperty("db.user");
    public static final String DB_PASSWORD = dbProperties.getProperty("db.password");
    public static final String USER_PASSWORD = "?user=" + DB_USER + "&password=" + DB_PASSWORD;
    public static final String DB_NAME = dbProperties.getProperty("db.name");
    public static final String DB_DRIVER = dbProperties.getProperty("db.driver");
    public static final String DB_HOST = dbProperties.getProperty("db.host");
    public static final String DB_CONNECTION_URL = DB_HOST + USER_PASSWORD;
    public static final String DB_DATABASE_URL = DB_HOST + DB_NAME + USER_PASSWORD;

    private static String DB_SCRIPTS_FOLDER = dbProperties.getProperty("db.scripts.folder");

    public void deployDb() {
        new QueryHelper() {
            protected void executeQuery(Statement statement, Connection connection) throws SQLException {
                statement.executeUpdate("drop database if exists " + DB_NAME);
                statement.executeUpdate("create database " + DB_NAME);
                statement.executeUpdate("use " + DB_NAME);
                //Get file from resources folder
                ClassLoader classLoader = getClass().getClassLoader();
                //Load all sql files and run all sql scripts into them
                File folder = new File(classLoader.getResource(DB_SCRIPTS_FOLDER).getFile());
                loadSqlFilesFromFolder(statement, folder);
            }
        }.runWithoutDb();
    }

    private void loadSqlFilesFromFolder(Statement statement, final File folder) throws SQLException {
        File[] files = folder.listFiles();
        Arrays.sort(files);
        for (final File file : files) {
            if (file.isDirectory()) {
                loadSqlFilesFromFolder(statement, file);
            } else if (file.getName().endsWith(".sql")){
                executeSqlFile(statement, file);
            }
        }
    }

    private void executeSqlFile(Statement statement, File inputFile) throws SQLException {
        System.out.println("********Execute File: " + inputFile.getName() + " ********\n");
        String delimiter = ";"; // delimiter
        Scanner scanner; // create scanner
        try {
            scanner = new Scanner(inputFile).useDelimiter(delimiter);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
            return;
        }

        while(scanner.hasNext()) { // loop through the sql file statements
            String rawStatement = scanner.next().trim();
            if(rawStatement.length() > 0) {
                rawStatement += delimiter; // Get statement
                System.out.println("=======Execute Statement=======");
                System.out.println(rawStatement.trim());
                statement.execute(rawStatement);// Execute statement
                System.out.println("=======Execution Success!=======\n");
            }
        }
        scanner.close();
        System.out.println("********Execution of File: " + inputFile.getName() + " Success!********\n");
    }
}
