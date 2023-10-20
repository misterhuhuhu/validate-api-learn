package beanvalidation.servicevalidation.controller;


import beanvalidation.servicevalidation.domain.UserAccount;
import beanvalidation.servicevalidation.service.UserAccountService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAccountController {

    @Resource
    private UserAccountService service;

    @PostMapping("/addUserAccount")
    public Object addUserAccount(@RequestBody UserAccount userAccount) {
        return service.addUserAccount(userAccount);
    }
  

}
