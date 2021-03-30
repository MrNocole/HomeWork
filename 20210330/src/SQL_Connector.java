package src;
import java.sql.*;
public class SQL_Connector {
    private String ip , id , pw , url , port , databasename;
    private Connection connection;
    public Statement statement;
    public PreparedStatement preparedStatement;
    private ResultSet resultSet;
    SQL_Connector(builder builder){
        this.ip = builder.ip;
        this.id = builder.id;
        this.pw = builder.pw;
        this.databasename = builder.databasename;
        this.port = builder.port;
    }
    public void Connect() throws ClassNotFoundException {
        if (ip!=null && id!=null && pw != null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.url = "jdbc:mysql://"+ip+":"+port+"/"+databasename;
            try{
                connection = DriverManager.getConnection(url,id,pw);
                statement = connection.createStatement();
            } catch (SQLException throwables) {
                System.out.println("Connect not success!\n");
            }
        }
    }

    public Connection getConnection(){
        return this.connection;
    }
    public void close() throws SQLException {
        this.connection.close();
    }
    public static class builder{
        private String ip , id , pw , port , databasename ;
        private Connection connection;
        private Statement statement;
        private ResultSet resultSet;
        builder(){}
        public builder setIp(String ip) {
            this.ip = ip;
            return this;
        }

        public builder setId(String id) {
            this.id = id;
            return this;
        }

        public builder setPw(String pw) {
            this.pw = pw;
            return this;
        }

        public builder setPort(String port) {
            this.port = port;
            return this;
        }

        public builder setDatabasename(String databasename){
            this.databasename = databasename;
            return this;
        }
        public SQL_Connector build(){
            return new SQL_Connector(this);
        }
    }

}
