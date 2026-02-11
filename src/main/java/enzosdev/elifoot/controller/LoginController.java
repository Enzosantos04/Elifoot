package enzosdev.elifoot.controller;


import enzosdev.elifoot.dto.LoginDTO;
import enzosdev.elifoot.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {


    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @PostMapping
    public LoginDTO login(@RequestBody LoginDTO loginDTO){
        return loginService.login(loginDTO);
    }
}
