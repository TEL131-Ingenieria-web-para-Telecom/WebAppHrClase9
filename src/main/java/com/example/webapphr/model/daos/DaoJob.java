package com.example.webapphr.model.daos;

import com.example.webapphr.model.beans.Job;

import java.sql.*;
import java.util.ArrayList;

public class DaoJob {

    public ArrayList<Job> lista() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/hr";
        ArrayList<Job> lista = new ArrayList<>();
        String sql = "select * from jobs";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                Job job = new Job();
                job.setJobId(rs.getString(1));
                job.setJobTitle(rs.getString(2));
                job.setMinSalary(rs.getInt(3));
                job.setMaxSalary(rs.getInt(4));
                lista.add(job);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void guardar(Job job) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/hr";
        String sql = "INSERT INTO jobs (job_id, job_title, min_salary, max_salary) VALUES (?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, job.getJobId());
            pstmt.setString(2, job.getJobTitle());
            pstmt.setInt(3, job.getMinSalary());
            pstmt.setInt(4, job.getMaxSalary());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void borrar(String jobId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/hr";
        String sql = "DELETE FROM jobs WHERE job_id = ?";

        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, jobId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Job buscarPorId(String jobId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/hr";

        Job job = null;

        String sql = "select * from jobs WHERE job_id = ?";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1, jobId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    job = new Job();
                    job.setJobId(rs.getString(1));
                    job.setJobTitle(rs.getString(2));
                    job.setMinSalary(rs.getInt(3));
                    job.setMaxSalary(rs.getInt(4));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return job;
    }

    public void actualizar(String jobId, String jobTitle, int minSalary, int maxSalary) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/hr";
        String sql = "UPDATE jobs SET job_title = ?, min_salary = ?, max_salary = ? WHERE job_id = ?";

        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(4, jobId);
            pstmt.setString(1, jobTitle);
            pstmt.setInt(2, minSalary);
            pstmt.setInt(3, maxSalary);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void actualizarParcial(String jobId, String jobTitle, int minSalary) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/hr";
        String sql = "UPDATE jobs SET job_title = ?, min_salary= ?  WHERE job_id = ?";

        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, jobTitle);
            pstmt.setInt(2, minSalary);
            pstmt.setString(3, jobId);
            pstmt.executeUpdate();
        }
    }

    public ArrayList<Job> buscarPorJobTitle(String jobTitle) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/hr";
        ArrayList<Job> lista = new ArrayList<>();
        String sql = "select * from jobs where job_title = ?";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, jobTitle);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Job job = new Job();
                    job.setJobId(rs.getString(1));
                    job.setJobTitle(rs.getString(2));
                    job.setMinSalary(rs.getInt(3));
                    job.setMaxSalary(rs.getInt(4));
                    lista.add(job);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
}
