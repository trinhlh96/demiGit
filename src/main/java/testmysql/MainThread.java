package testmysql;

import testmysql.etity.Article;

import java.sql.*;
import java.util.ArrayList;

public class MainThread {
    public static void main(String[] args) {
        System.out.println("hahahah");
//        Article article = new Article();
//        article.setId(6);
//        article.setTitle("gregreg");
//        article.setUrl("helo vietfwewef");
//        article.setDescription("hhhhhsadhhh");
//        article.setContest("hhhhhhhh");
//        article.setSource("hhhhhdwqhhh");
//        article.setStatus(0);
//        insertArticle(article);
       Article article = loadArticle(){
            System.out.println(article.toString());
        }
    }
    //lay du lieu
public static ArrayList<ArrayList> loadArticle(){
    System.out.println("Loading data....");
    ArrayList<ArrayList> listArticle = new ArrayList<ArrayList>();
    try {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatest?useUnicode=true&serverTimezone=Asia/Bangkok&characterEncoding=utf-8",
                "root",
                "123@123");
        String queryString = "SELECT id, url, title, status FROM `aricite` ORDER BY id DESC";
        PreparedStatement preparedStatement = connection.prepareStatement(queryString);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){ //chuyển con trỏ xuống dòng tiếp theo
            int id = resultSet.getInt("id");// Kiểu dữ liệu gì, trường nào(hoặc index thứ mấy,index star từ 1 )
            String url = resultSet.getString("url");
            String title = resultSet.getString("title");
            int status = resultSet.getInt("status");
            Article article = new Article(id,title, url, status);
            listArticle.add(article);
        }
        System.out.println("Thao tac thanh cong thanh cong");
    } catch (SQLException e) {
        e.printStackTrace();
    }
return listArticle;
}

//insert du lieu
    public static void insertArticle(Article article) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javatest?useUnicode=true&serverTimezone=Asia/Bangkok&characterEncoding=utf-8",
                    "root",
                    "123@123");
            String queryString = "INSERT INTO `aricite`" +
                            "(id, title, url, description, contest, `source`, status)" +
                            "VALUES (?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.setInt(1, article.getId());
            preparedStatement.setString(2, article.getTitle());
            preparedStatement.setString(3, article.getUrl());
            preparedStatement.setString(4, article.getDescription());
            preparedStatement.setString(5, article.getContest());
            preparedStatement.setString(6, article.getSource());
            preparedStatement.setInt(7, article.getStatus());
            preparedStatement.execute();
            System.out.println("ket noi thanh cong");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
