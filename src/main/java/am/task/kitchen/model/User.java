package am.task.kitchen.model;

import lombok.Data;

import java.util.Set;

@Data
public class User {


    private long id;

    private String username;

    private String name;

    private String surname;

    private String password;


    private Status status;




    private Set<Authority> authorities;


}
