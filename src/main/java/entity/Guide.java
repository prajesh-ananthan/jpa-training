package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ANAN011 on 6/6/2017.
 *
 * @author Prajesh Ananthan, arvato Systems Malaysia Sdn Bhd
 *         <p>
 *         A single guide can have multiple Students
 */

@Entity
public class Guide {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "staff_id", nullable = false)
  private String staffId;

  private String name;
  private Integer salary;

  @OneToMany(mappedBy = "guide", cascade = {CascadeType.PERSIST})
  private Set<Student> students = new HashSet<Student>();

  public Guide() {
  }

  public Guide(String staffId, String name, Integer salary) {
    this.staffId = staffId;
    this.name = name;
    this.salary = salary;
  }

  public Set<Student> getStudents() {
    return students;
  }

  public void addStudent(Student student) {
    students.add(student);
    student.setGuide(this);
  }

  public Long getId() {
    return id;
  }

  public String getStaffId() {
    return staffId;
  }

  public String getName() {
    return name;
  }

  public Integer getSalary() {
    return salary;
  }
}
