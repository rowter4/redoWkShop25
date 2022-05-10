package sg.edu.nus.iss.workshop25Redo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/protected/{view}")
public class ProtectedController {

    @GetMapping
    @PostMapping
    public ModelAndView getView(@PathVariable String view, HttpSession session) {

        String username = (String)session.getAttribute("username");
        ModelAndView mvc = new ModelAndView();
        
        mvc.setViewName(view); 
        mvc.setStatus(HttpStatus.OK);
        mvc.addObject("username", username);

        return mvc;
    }
    
}
