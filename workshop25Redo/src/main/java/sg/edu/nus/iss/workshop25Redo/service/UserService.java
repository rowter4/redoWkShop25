package sg.edu.nus.iss.workshop25Redo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.workshop25Redo.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    public UserRepository userRepo;

    public boolean authenticate(String username, String password) {
        System.out.printf(">>>>> checking for the username in service");
        return 1 == userRepo.checkForUsername(username,password);
        
    }
}
