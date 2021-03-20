package ConnectSQLserver;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;

public class SqlDb {
    private static final String IP = "192.168.1.7";
    private static final String PORT_NUM = "1433";
    private static final String DB_NAME = "SGstore";
    private static final String CLASS = "net.sourceforge.jtds.jdbc.Driver";
    private static final String URL = "jdbc:jtds:sqlserver://" + IP + ":" + PORT_NUM + "/" + DB_NAME;
    private static final String USERNAME = "mo3tz";
    private static final String PASS = "12345";

    private Connection connection = null; private Statement statement = null;



    public HashSet getData(String tableName) {

        HashSet set =new HashSet();

        try {
            Class.forName(CLASS);
            connection = DriverManager.getConnection(URL, USERNAME, PASS);
            if (connection != null) {
                statement = connection.createStatement();

                for (int i = 0 ; i <=21 ; i++) {

                    ResultSet resultSet = statement.executeQuery("select * from "+tableName+" where counting = " + i + ";");
                    while ( resultSet.next()) {
                        set.add(resultSet.getString("uc")+"_"+resultSet.getInt("price"));

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.v("exception",": "+e.getMessage());
        }

        return set;
    }
}

