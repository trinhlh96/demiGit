package testmysql.etity;

import java.sql.*;

public class MainCategory {
    public static void main(String[] args) {
        Category category = new Category();
        category.setId(1);
        category.setName("trinh");
        category.setDescription("yeu hoa binh");
        category.setThumbnail("http://lalalal.vn");
//        category.setCreatedAt("2000-12-1");
        category.setStatus(0);
    }
    public static void insertCategory(Category category){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatest?useUnicode=true&serverTimezone=Asia/Bangkok&characterEncoding=utf-8",
                    "root",
                    "123@123");
            String queryString = "INSERT INTO `category`" +
                    "(id,name, description, thumbnail,createdAt, status)" +
                    "VALUES (?,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.setInt(1, category.getId());
            preparedStatement.setString(2, category.getName());
            preparedStatement.setString(3, category.getDescription());
            preparedStatement.setString(4, category.getThumbnail());
            preparedStatement.setDate(5, (Date) category.getCreatedAt());
            preparedStatement.setInt(6, category.getStatus());
            preparedStatement.execute();
            System.out.println("Insert thanh cong");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
