package __btweb_2611.example.__btweb_2611.models;

import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

public class category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String images;

    @ManyToMany(mappedBy = "categories")
    private List<User> users;
}
