package com.example.haifa.nursemate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.Statement;

/**
 * A sample app that connects to a Cloud SQL instance and lists all available tables
 in a database.
 */

public class DBconnection {

    public static void main(String[] args) throws SQLNonTransientConnectionException
            , IOException, SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

//        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream("C:\\Users\\User\\Desktop\\NurseMate\\NurseMateProject-5e3cea6cf0f7.json"))
//                .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
//        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();


        String thisid="1001";
        String thispass="pass1001";
        String dbpass="";

        String instanceConnectionName = "ordinal-space-267013:us-central1:nursemate";
        String databaseName = "nursematedatabase";
        String IP_of_instance = "35.194.33.194";
        String username = "dbuser";
        String password = "dbpass";

        String jdbcUrl = String.format(
                "jdbc:mysql://%s/%s?cloudSqlInstance=%s&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false",
                IP_of_instance,
                databaseName,
                instanceConnectionName);

        Connection connection = DriverManager.getConnection(jdbcUrl,username,password);

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT password FROM Nurses WHERE idnumber="+thisid);
            if(resultSet.next()) {
                dbpass=resultSet.getString(1);
                if(dbpass.equals(thispass)){
                    System.out.println("Successful login! PASS: "+dbpass);
                }
                else{
                    System.out.println("Login unsuccessful. Try again.");
                }
            }
            else{
                System.out.println("Login unsuccessful. Try again.");
            }


//            while (resultSet1.next()) {
//                System.out.println(resultSet.getString(1));
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}