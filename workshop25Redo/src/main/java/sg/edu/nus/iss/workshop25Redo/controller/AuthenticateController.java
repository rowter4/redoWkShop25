package sg.edu.nus.iss.workshop25Redo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.nus.iss.workshop25Redo.service.UserService;

@Controller
@RequestMapping("/authenticate")
public class AuthenticateController {
    
    @Autowired
    private UserService userSvc;

    @PostMapping
    public ModelAndView getAuthenticated(@RequestBody MultiValueMap<String,String> form) {
        
        String username = form.getFirst("username");
        String password = form.getFirst("password");

        System.out.printf(">>>>>>> username : %s , password : %s", username, password);
        ModelAndView mvc = new ModelAndView();

        if (userSvc.authenticate(username,password)) {
            mvc.setViewName("welcome");
            mvc.setStatus(HttpStatus.OK);
            mvc.addObject("username", username);
        } else {   
            mvc.setViewName("error");
            mvc.setStatus(HttpStatus.FORBIDDEN);   
        }
        
        return mvc;
    }
}
