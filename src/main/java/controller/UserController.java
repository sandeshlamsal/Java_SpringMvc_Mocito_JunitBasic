package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.User;
import service.UserService;

@RestController	
@RequestMapping(value = "/customer")
public class UserController {

  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(value = "/id", method = RequestMethod.GET, params = {"email"})
  public String getProfileIdForEmail(@RequestParam String email) {
    return userService.getUserId(email);
  }

  @RequestMapping(value = "/id/post", method = RequestMethod.POST)
  public String getHouseholdProfile(@RequestBody User user) {
    return userService.getHouseholdInformation(user);
  }

}
