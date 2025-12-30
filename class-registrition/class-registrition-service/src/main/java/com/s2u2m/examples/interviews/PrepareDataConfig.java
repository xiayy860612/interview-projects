package com.s2u2m.examples.interviews;

import com.s2u2m.examples.interviews.repository.auth.RoleEntity;
import com.s2u2m.examples.interviews.repository.auth.UserEntity;
import com.s2u2m.examples.interviews.repository.auth.UserRepository;
import jakarta.annotation.PostConstruct;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PrepareDataConfig {
  private final UserRepository userRepository;

  @PostConstruct
  void init() {
    userRepository.save(createStudent());
    userRepository.save(createProfessor());
  }

  private UserEntity createProfessor() {
    UserEntity professor = new UserEntity();
    professor.setUsername("professor1");
    professor.setPassword("{noop}123456");

//    RoleEntity role = new RoleEntity();
//    role.setName("PROFESSOR");
//    professor.setRoles(List.of(role));
    return professor;
  }

  private UserEntity createStudent() {
    UserEntity student = new UserEntity();
    student.setUsername("student1");
    student.setPassword("{noop}123456");

//    RoleEntity role = new RoleEntity();
//    role.setName("STUDENT");
//    student.setRoles(List.of(role));
    return student;
  }

}
