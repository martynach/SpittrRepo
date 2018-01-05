package spittr;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Spitter {

    private Long id;

    @NotNull
    @Size(min=4, max=16, message = "{username.size}")
    private String username;

    //* zero or more times
    //? once or not at all
    //+ one or more times
    @NotNull
    @Size(min=4, max=24, message = "{password.size}")
    @Pattern(regexp = ".*[0-9].*", message = "{password.pattern}")
    private String password;

    @NotNull
    @Size(min=3, max=24, message = "{firstname.size}")
    private String firstname;

    @NotEmpty
    @Size(min=3, max=24, message = "{lastname.size}")
    private String lastname;

    public Spitter() {}


    public Spitter(String username, String password, String firstname, String lastname) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Spitter(Long id, String username, String password, String firstname, String lastname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj, "id");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id");
    }

    @Override
    public String toString() {
        return "Spitter id: " + id + ", username: " + username + ", firstname: " + firstname + ", lastname: " + lastname;
    }
}
