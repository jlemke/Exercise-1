package com.matc.persistence;

import com.matc.entity.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Access users in the user table.
 *
 * @author pwaite
 */
public class UserData {

    private final Logger logger = Logger.getLogger(this.getClass());

    public List<User> getAllUsers() {
        return searchDatabase("SELECT * FROM users");
    }

    //TODO add a method or methods to return a single user based on search criteria

    public List<User> getSpecificUsers(int id, String firstName, String lastName, int age) {
        String query = "Select * from users";
        List<User> users;
        boolean useWhere = true;

        if (id != 0) {
            query += " WHERE id = " + id;
            useWhere = false;
        }
        if (firstName != "") {
            if (useWhere)
                query += " WHERE";
            else
                query += " AND";
            query += " first_name = " + firstName;
            useWhere = false;
        }
        if (lastName != "") {
            if (useWhere)
                query += " WHERE";
            else
                query += " AND";
            query += " last_name = " + lastName;
        }
        if (age != 0)
            users = searchByAge(age, query);
        else
            users = searchDatabase(query);

        return users;
    }

    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setLastName(results.getString("last_name"));
        user.setFirstName(results.getString("first_name"));
        user.setUserid(results.getString("id"));
        user.setDateOfBirth(results.getString("date_of_birth"));
        return user;
    }

    public List<User> searchByAge(int age, String query) {
        List<User> allUsers = searchDatabase(query);
        List<User> foundUsers = new ArrayList<User>();

        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).calculateAge() == age)
                foundUsers.add(allUsers.get(i));
        }

        return foundUsers;
    }

    private List<User> searchDatabase(String query) {
        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;

        try {
            logger.info("Entered the try statement in searchDatabase()");

            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(query);
            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
        } catch (SQLException e) {
            System.out.println("SearchUser.getAllUsers()...SQL Exception: " + e);
        } catch (Exception e) {
            System.out.println("SearchUser.getAllUsers()...Exception: " + e);
        }
        return users;

    }


}
