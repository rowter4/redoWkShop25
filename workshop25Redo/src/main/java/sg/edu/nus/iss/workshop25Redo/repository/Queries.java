package sg.edu.nus.iss.workshop25Redo.repository;

public interface Queries {
    public static final String SQL_CHECK_FOR_USER = 
        "select count(*) as user_count from users where username = ? and password = sha1(?)";
}
