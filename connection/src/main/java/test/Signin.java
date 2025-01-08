package test;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;
@Getter
@Setter


public class Signin {
    private String username;
    private String password;

    public Signin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Signin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
