package repository;

import controller.RoleController;
import entity.RoleEntity;
import mySQLConfig.MySqlConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleRepository {
    private static final Logger logger = LoggerFactory.getLogger(RoleRepository.class);
    public int deleteByID(int id) {
        int count = 0;
        String query = "DELETE FROM roles r WHERE r.id = ?";
        try {
            Connection connection = MySqlConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id); // set 1st parameter ? as id
            count = preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error DeleteByID(): " + e.getLocalizedMessage());
        }
        return count;
    }
    public List<RoleEntity> findAll() {
        List<RoleEntity> roleList = new ArrayList<RoleEntity>();
        logger.info("String query = \"SELECT * FROM roles\"");
        String query = "SELECT * FROM roles";
        try{
            logger.info("Connection connection = MySqlConfig.getConnection()");
            Connection connection = MySqlConfig.getConnection();
            logger.info("PreparedStatement preparedStatement = connection.prepareStatement(query)");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            logger.info("ResultSet resultSet = preparedStatement.executeQuery()");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                logger.info("while(resultSet.next())");
                logger.info("RoleEntity roleEntity = new RoleEntity()");
                RoleEntity roleEntity = new RoleEntity();
                logger.info("roleEntity.setId(resultSet.getInt(\"id\"))");
                roleEntity.setId(resultSet.getInt("id"));
                logger.info("roleEntity.setName(resultSet.getString(\"name\"))");
                roleEntity.setName(resultSet.getString("name"));
                logger.info("roleEntity.setDesc(resultSet.getString(\"description\")");
                roleEntity.setDesc(resultSet.getString("description"));
                roleList.add(roleEntity);
            }
        } catch (Exception e) {
            System.out.println("Error findAll(): " + e.getLocalizedMessage());
        }
        return roleList;
    }
    public int addRole(String roleName, String roleDescription) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO roles( name, description ) VALUES (?, ?);";
        int insertedRowCount = 0;
        try {
            connection = MySqlConfig.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, roleName);
            preparedStatement.setString(2, roleDescription);
            insertedRowCount = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error addRole(): " + e.getLocalizedMessage());
        } finally {
            // Step 5: Close the PreparedStatement and the database connection in the finally block
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    System.out.println("Error closing PreparedStatement: " + e.getLocalizedMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getLocalizedMessage());
                }
            }
        }
        return insertedRowCount;
    }
}
