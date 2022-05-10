package sg.edu.nus.iss.workshop25Redo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import static sg.edu.nus.iss.workshop25Redo.repository.Queries.*;

@Repository
public class UserRepository {
    
    @Autowired
    private JdbcTemplate template;
    
    public int checkForUsername(String username, String password) {
        SqlRowSet response = template.queryForRowSet(SQL_CHECK_FOR_USER, username, password);
        
        if (!response.next())
            return 0;
        
        return response.getInt("user_count");
        
    }
}
