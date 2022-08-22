import java.sql.*;

public class Database {

    Database() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:Data.db");
        Statement stat = conn.createStatement();
        stat.executeUpdate("drop table if exists userinfo;");
        stat.executeUpdate("create table userinfo (username, password, firstName, lastName);");
        PreparedStatement prep = conn.prepareStatement(
                "insert into userinfo values (?, ?, ?, ?);");

        prep.setString(1, "SmallPlayz");
        prep.setString(2, "password123");
        prep.setString(3, "myFirstName");
        prep.setString(4, "myLastName");
        prep.addBatch();

        prep.setString(1, "JohnDoe123");
        prep.setString(2, "ilikecats123");
        prep.setString(3, "John");
        prep.setString(4, "Doe");
        prep.addBatch();

        conn.setAutoCommit(false);
        prep.executeBatch();
        conn.setAutoCommit(true);

        ResultSet rs = stat.executeQuery("select * from userinfo;");
        while (rs.next()) {
            System.out.println("Username = " + rs.getString("username"));
            System.out.println("Password = " + rs.getString("password"));
            System.out.println("First Name = " + rs.getString("firstName"));
            System.out.println("Last Name = " + rs.getString("lastName"));
            System.out.println();
        }
        rs.close();
        conn.close();
    }
}
