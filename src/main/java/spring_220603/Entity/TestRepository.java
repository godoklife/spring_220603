package spring_220603.Entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity, Integer> {
    // JpaRepository 인터페이스로부터 상속받기
}
    //