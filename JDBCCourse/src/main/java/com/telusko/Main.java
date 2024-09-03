package com.telusko;
import java.sql.*; // importing packages
public class Main {
    public static void main(String[] args) throws Exception {


        int sid=101;
        String sname="Max";
        int marks=40;


        String url = "jdbc:mysql://localhost:3306/demo";
        String username = "root";
        String password = "root";
        String query = "insert into student values (" + sid + ",'" + sname + "'," + marks + ")"; //this is old method and instead of this we use prepared statement
//

//        //problem 1
//        //insert into student values (101,'Max',40) normally we put this...
//        //but if we have to give sid, sname and marks after initialising
//        //then max is usually given in 'Max' so we have to give that ' ' also in " " as given below
//        String query = "insert into student values (" + sid + ",'" + sname + "'," + marks + ")";
        // Class.forName("com.mysql.cj.jdbc.Driver"); //load and register , this line is not compulsory as without it also it will run
        Connection con = DriverManager.getConnection(url,username,password);   // create connection
        System.out.println("Connection Established!");
        Statement st = con.createStatement(); //create statement
//        ResultSet rs = st.executeQuery(query); //execute statement
        // execute() implies fetching as well change the data, executeQuery()/ just fetching data onli
        //System.out.println(rs.next());//process data, if db has next row it return true if not means it returns false
//        rs.next();
//        String name = rs.getString("sname");
//        System.out.println("Name of student is "+ name);

//        while (rs.next()){
//            System.out.print(rs.getInt(1)+" - ");
//            System.out.print(rs.getString(2)+" - ");
//            System.out.print(rs.getInt(3));
//            System.out.println();
//        } //fetching all records


        //CRUD OPERATNS
        boolean status = st.execute(query); //here in insert, update or delete query it returns false indicating the count and in sql or select query it will return true indicating it is returning result set
        System.out.println(status);



        con.close();
        System.out.println("Connection closed");





    }
}

        /*
            import package
            load and register
            create connection
            create statement
            execute statement
            process the results
            close

            //fetches onli single record
            String query = "select sname from student where sid=1";
            rs.next();
            String name = rs.getString("sname");
            System.out.println("Name of student is "+ name);

            String query = "select * from student";
            ResultSet rs = st.executeQuery(query); //execute statement
            while (rs.next()){
                System.out.print(rs.getInt(1)+" - ");
                System.out.print(rs.getString(2)+" - ");
                System.out.print(rs.getInt(3));
                System.out.println();
            }

            CRUD OPERATN
            String query = "insert into student values (5, 'vysh', 90)";
            boolean status = st.execute(query); //here in insert, update or delete query it returns false indicating the count and in sql or select query it will return true indicating it is returning result set
            System.out.println(status);
            o/p:
            Connection Established!
            false
            Connection closed

            String query = "update student set sname='Max' where sid = 5";
            boolean status = st.execute(query); //here in insert, update or delete query it returns false indicating the count and in sql or select query it will return true indicating it is returning result set
            System.out.println(status);
            o/p:
            Connection Established!
            false
            Connection closed

            String query = "delete from student where sid = 5";
            boolean status = st.execute(query); //here in insert, update or delete query it returns false indicating the count and in sql or select query it will return true indicating it is returning result set
            System.out.println(status);
            o/p:
            Connection Established!
            false
            Connection closed

         */