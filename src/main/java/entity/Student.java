package entity;

import javax.persistence.*;

/**
 * Created by ANAN011 on 6/6/2017.
 *
 * @author Prajesh Ananthan, arvato Systems Malaysia Sdn Bhd
 *         <p>
 *         Many students can have a single guide
 *         A single can only have a single guide
 */
@Entity
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "enrollment_id", nullable = false)
  private String enrolllmentId;

  private String name;

  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
  @JoinColumn(name = "guide_id")
  private Guide guide;

  public Student() {
  }

  public Student(String enrolllmentId, String name, Guide guide) {
    this.enrolllmentId = enrolllmentId;
    this.name = name;
    this.guide = guide;
  }

  public Guide getGuide() {
    return guide;
  }

  public void setGuide(Guide guide) {
    this.guide = guide;
  }
}
