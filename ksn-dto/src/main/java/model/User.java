package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class User {

    private UUID id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private boolean active;

    private List<> articles;
}
