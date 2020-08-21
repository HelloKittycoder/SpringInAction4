package spittr.domain;

import javax.persistence.*;

@Entity
public class Spitter {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "username")
  private String username;
  @Column(name = "password")
  private String password;
  @Column(name = "fullname")
  private String fullName;
  @Column(name = "email")
  private String email;
  @Column(name = "updateByEmail")
  private boolean updateByEmail;

  public Spitter() {
  }

  public Spitter(String username, String password, String fullName) {
    this.username = username;
    this.password = password;
    this.fullName = fullName;
  }

  public Spitter(Long id, String username, String password, String fullName) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.fullName = fullName;
  }

  public Spitter(Long id, String username, String password, String fullName, String email, boolean updateByEmail) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.fullName = fullName;
    this.email = email;
    this.updateByEmail = updateByEmail;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean isUpdateByEmail() {
    return updateByEmail;
  }

  public void setUpdateByEmail(boolean updateByEmail) {
    this.updateByEmail = updateByEmail;
  }

  @Override
  public String toString() {
    return "Spitter{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", fullName='" + fullName + '\'' +
            ", email='" + email + '\'' +
            ", updateByEmail=" + updateByEmail +
            '}';
  }
}
