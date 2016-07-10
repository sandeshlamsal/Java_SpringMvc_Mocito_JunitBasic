package model;

import lombok.Data;

@Data
public class User {

    private String username;
	public void setUsername(String username) {
        this.username = username;
    }


}