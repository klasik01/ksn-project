package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private UUID id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private boolean active;
    private List<LinkType> links;
}
