package service;

import org.springframework.stereotype.Service;

import model.User;

@Service
public class UserService {


  public String getHouseholdInformation(User user) {

    return "user";
  }

  public String getUserId(String email) {

    return "email";
  }

}
