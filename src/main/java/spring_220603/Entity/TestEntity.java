package spring_220603.Entity;

import javax.persistence.*;

@Entity // 해당 클래스를 엔티티로 사용하겠다!~~~!!!
public class TestEntity { // 클래스
    @Id // PK 값 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 설정
    public int no;  // 필드
    @Column(name="content")
    public String content;  // 필드
}
// 엔티티??