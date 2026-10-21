
package SaveServlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {

    public static Connection getConnection() {

        String url = "jdbc:mysql://localhost:3306/employee";
        String username = "root";
        String password = "System@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                url, username, password
            );
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    // INSERT EMPLOYEE
    public static int save(Emp e) {

        String sql =
            "INSERT INTO user905(name, department, email, salary) VALUES (?, ?, ?, ?)";

        try (Connection con = getConnection()) {

            if (con == null) return 0;

            try (PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, e.getName());
                ps.setString(2, e.getDepartment());
                ps.setString(3, e.getEmail());
                ps.setString(4, e.getSalary());

                return ps.executeUpdate();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    // GET ALL EMPLOYEES
    public static List<Emp> getAllEmployees() {

        List<Emp> list = new ArrayList<>();

        String sql = "SELECT * FROM user905";

        try (Connection con = getConnection()) {

            if (con == null) return list;

            try (PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    Emp e = new Emp();

                    e.setId(rs.getInt("id"));
                    e.setName(rs.getString("name"));
                    e.setEmail(rs.getString("email"));
                    e.setDepartment(rs.getString("department"));
                    e.setSalary(rs.getString("salary"));

                    list.add(e);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }

    // GET EMPLOYEE BY ID
    public static Emp getEmployeeById(int id) {

        Emp e = null;

        String sql = "SELECT * FROM user905 WHERE id = ?";

        try (Connection con = getConnection()) {

            if (con == null) return null;

            try (PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setInt(1, id);

                try (ResultSet rs = ps.executeQuery()) {

                    if (rs.next()) {

                        e = new Emp();

                        e.setId(rs.getInt("id"));
                        e.setName(rs.getString("name"));
                        e.setEmail(rs.getString("email"));
                        e.setDepartment(rs.getString("department"));
                        e.setSalary(rs.getString("salary"));
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }

    // UPDATE EMPLOYEE
    public static int update(Emp e) {

        String sql =
            "UPDATE user905 SET name=?, email=?, department=?, salary=? WHERE id=?";

        try (Connection con = getConnection()) {

            if (con == null) return 0;

            try (PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, e.getName());
                ps.setString(2, e.getEmail());
                ps.setString(3, e.getDepartment());
                ps.setString(4, e.getSalary());
                ps.setInt(5, e.getId());

                return ps.executeUpdate();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    // DELETE EMPLOYEE
    public static int delete(int id) {

        String sql = "DELETE FROM user905 WHERE id = ?";

        try (Connection con = getConnection()) {

            if (con == null) return 0;

            try (PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setInt(1, id);

                return ps.executeUpdate();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }
}
