package src;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static String info[] = new String[]{"IP","PORT","DataBase's Name","ID","PASSWORD"};
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String words[] = new String[5];
        for (int i = 0 ; i < 5 ; i ++){
            System.out.println(info[i]);
            words[i] = scanner.next();
        }
        SQL_Connector sql_connector = new SQL_Connector.builder().setIp(words[0]).setPort(words[1]).setDatabasename(words[2]).setId(words[3]).setPw(words[4]).build();
        sql_connector.Connect();
        System.out.println("Connected!");
        SQL_Operator sql_operator = new SQL_Operator(sql_connector);
        System.out.println("Get Ready to operate");
        while (true){
            System.out.println("Input 1 to Insert a Student\n2 to lookup a student by Id\n3 to remove a student by ID\n4 to update a student by ID");
            int tmp = scanner.nextInt();
            switch (tmp){
                case 1 : {
                    System.out.println("Input Info : (ID,Name,Sex)(must),(Birthday,isTuanYuan,location)");
                    String[] strings = new String[6];
                    strings[0] = scanner.next();
                    int idx = 0;
                    while (idx < 6 && strings[idx++] != null){
                        strings[idx] = scanner.next();
                    }
                    Student student = new Student.builder().setStuID(strings[0]).setStuName(strings[1]).setStuSex(strings[2]).setStuBirthday(strings[3]).setTy(strings[4].equals("t")?true:false).setStuLocation(strings[5]).build();
                    sql_operator.insertStudentByFullInfo(student);
                    break;
                }
                case 2 : {
                    System.out.println("Input ID to lookup a student :");
                    String id = scanner.next();
                    ResultSet resultSet = sql_operator.getInfoByStuId(id);
                    if (resultSet.isLast())System.out.println("Null!");
                    while (resultSet.next()){
                        for  (int i = 1 ; i <= 6 ; i ++){
                            System.out.print(resultSet.getString(i) + " ");
                        }
                        System.out.println();
                    }
                    break;
                }
                case 3 : {
                    System.out.println("Input ID to remove a student :");
                    String id = scanner.next();
                    sql_operator.delStuById(id);
                    break;
                }
                case 4 : {
                    System.out.println("Input new Info : (ID,Name,Sex)(must),(Birthday,isTuanYuan,location)");
                    String[] strings = new String[6];
                    strings[0] = scanner.next();
                    int idx = 0;
                    while (idx < 6 && strings[idx++] != null){
                        strings[idx] = scanner.next();
                    }
                    Student student = new Student.builder().setStuID(strings[0]).setStuName(strings[1]).setStuSex(strings[2]).setStuBirthday(strings[3]).setTy(strings[4].equals("t")?true:false).setStuLocation(strings[5]).build();
                    String id = scanner.next();
                    sql_operator.updateStuById(id,student);
                    break;
                }
            }
        }
    }
}
