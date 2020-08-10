package com.revature.dao;

import com.revature.config.ConnectionUtil;
import com.revature.model.Category;
import com.revature.model.Flashcard;
import com.revature.model.Role;
import com.revature.model.User;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class FlashcardRepository implements CrudRepository{

    ConnectionUtil cu;

    public FlashcardRepository(ConnectionUtil cuu){
        cu = cuu;
    }

    @Override
    public Object save(Object t) throws SQLException {
        Flashcard f = (Flashcard) t;
        Connection c = cu.connect();
        String sql = "insert into flashcard(question, answer, category_id) values" +
                "(?,?,?)";
        PreparedStatement s = c.prepareStatement(sql);
        s.setString(1,f.getQuestion());
        s.setString(2,f.getAnswer());
        s.setInt(3,f.getCategory().getID());
        s.executeUpdate();
        return f;
    }

    @Override
    public Set<Object> findAll() throws SQLException {
        Connection c = cu.connect();
        Set<Object> allFlash = new HashSet<>();
        Flashcard f = new Flashcard();
        String sql = "select * from flashcard";
        Statement s = c.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while(rs.next()){
            f.setAnswer(rs.getString("answer"));
            f.setId(rs.getInt("flashcard_id"));
            f.setQuestion(rs.getString("question"));
            String cat = String.valueOf(Category.class .getEnumConstants() [(rs.getInt("category_id"))]);
            if(cat.equals("math")){
                f.setCategory(Category.math);
            }
            else if(cat.equals("science")){
                f.setCategory(Category.science);
            }
            else{
                f.setCategory(Category.english);
            }
            allFlash.add(f);
        }
        return allFlash;
    }

    @Override
    public Object findById(int id) throws SQLException {
        Connection c = cu.connect();
        Flashcard f = new Flashcard();
        String sql = "select * from flashcard where flashcard_id = ?";
        PreparedStatement s = c.prepareStatement(sql);
        s.setInt(1,id);
        ResultSet rs = s.executeQuery();
        while(rs.next()){
            f.setAnswer(rs.getString("answer"));
            f.setQuestion(rs.getString("question"));
            f.setId(rs.getInt("flashcard_id"));
            String cat = String.valueOf(Category.class .getEnumConstants() [(rs.getInt("category_id"))]);
            if(cat.equals("math")){
                f.setCategory(Category.math);
            }
            else if(cat.equals("science")){
                f.setCategory(Category.science);
            }
            else{
                f.setCategory(Category.english);
            }
        }
        return f;
    }

    @Override
    public boolean update(Object t) throws SQLException {
        Flashcard f = (Flashcard) t;
        Connection c = cu.connect();
        String sql = "update flashcard set question = ?, answer = ?, category_id = ? where user_id = ?";
        PreparedStatement s = c.prepareStatement(sql);
        s.setString(1,f.getQuestion());
        s.setString(2,f.getAnswer());
        Category cat = f.getCategory();
        if(cat.toString().equals("math")){
            s.setInt(3,1);
        }
        else if(cat.toString().equals("science")){
            s.setInt(3,2);
        }
        else{
            s.setInt(3,3);
        }
        s.setInt(4,f.getId());
        int i = s.executeUpdate();
        if(i != 1){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        Connection c = cu.connect();
        String sql = "delete from flashcard  where user_id = ?";
        PreparedStatement s = c.prepareStatement(sql);
        s.setInt(1,id);
        int i = s.executeUpdate();
        if(i != 1){
            return false;
        }
        else{
            return true;
        }
    }

    public Set<Flashcard> findFlashCardByCategory(Category cat) throws SQLException {
        Connection c = cu.connect();
        Set<Flashcard> allFlash = new HashSet<>();
        Flashcard f = new Flashcard();
        String sql = "select * from flashcard where category_id = ?";
        PreparedStatement s = c.prepareStatement(sql);
        if(cat.toString().equals("math")){
            s.setInt(1,1);
        }
        else if(cat.toString().equals("science")){
            s.setInt(1,2);
        }
        else{
            s.setInt(1,3);
        }
        ResultSet rs = s.executeQuery();
        while(rs.next()){
            f.setId(rs.getInt("flashcard_id"));
            f.setAnswer(rs.getString("answer"));
            f.setQuestion(rs.getString("question"));
            String cate = String.valueOf(Category.class .getEnumConstants() [(rs.getInt("category_id"))]);
            if(cate.equals("math")){
                f.setCategory(Category.math);
            }
            else if(cate.equals("science")){
                f.setCategory(Category.science);
            }
            else{
                f.setCategory(Category.english);
            }
            allFlash.add(f);
        }
        return allFlash;
    }
}