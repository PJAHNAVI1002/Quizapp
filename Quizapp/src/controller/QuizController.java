package controller;

import model.Quiz;
import utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QuizController {
	
	public void addQuiz(Quiz quiz) throws SQLException {
        Connection conn = DatabaseUtil.getConnection();
        String sql = "INSERT INTO quizzes (title, description) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, quiz.getTitle());
            stmt.setString(2, quiz.getDescription());
            stmt.executeUpdate();
        }
    }

  
    public void deleteQuiz(int quizId) throws SQLException {
        Connection conn = DatabaseUtil.getConnection();
        String sql = "DELETE FROM quizzes WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, quizId);
            stmt.executeUpdate();
        }
    }

    
    public void updateQuiz(Quiz quiz) throws SQLException {
        Connection conn = DatabaseUtil.getConnection();
        String sql = "UPDATE quizzes SET title = ?, description = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, quiz.getTitle());
            stmt.setString(2, quiz.getDescription());
            stmt.setInt(3, quiz.getId());
            stmt.executeUpdate();
        }
    }

}
