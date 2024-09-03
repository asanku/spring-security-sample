package com.telusko;
import java.sql.*;

public class MainPrepared {
    public static void main(String[] args) throws Exception {

        int sid=102;
        String sname="Jasmine";
        int marks=50;

        String url = "jdbc:mysql://localhost:3306/demo";
        String username = "root";
        String password = "root";
        String query = "insert into student values (?,?,?)";

        Connection con = DriverManager.getConnection(url,username,password);   // create connection
        System.out.println("Connection Established!");

        PreparedStatement st = con.prepareStatement(query); // gives pre compiled query
        st.setInt(1, sid);
        st.setString(2, sname);
        st.setInt(3, marks);


        st.execute(); //here in insert, update or delete query it returns false indicating the count and in sql or select query it will return true indicating it is returning result set


        con.close();
        System.out.println("Connection closed");
    }
}

//prepared statement is used when the data used is
// stored in a variable from where we have to access
// it and reduce the complexity of
// putting "insert into student values (" + sid + ",'" + sname + "'," + marks + ")";
