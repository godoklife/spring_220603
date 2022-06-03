package spring_220603.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring_220603.Entity.TestEntity;
import spring_220603.Entity.TestRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/home")    // 현재 클래스는 home으로 매핑
public class IndexController {
    @GetMapping("/main")
    public String home(){return "main";}
        // Resopnse 요구가 없을 경우 타임리프 HTML 반환

    @Autowired
    TestRepository testRepository;

    @GetMapping("/save")
    @ResponseBody
    public String getdata(HttpServletRequest request){
        // 0. 변수 요청하기
        String content = request.getParameter("content");

        // 1. 엔티티 생성
        TestEntity testEntity = new TestEntity();
        testEntity.content = content;

        // 2. 엔티티를 DB에 저장해주는 save 메서드 사용
        testRepository.save(testEntity);

        // 3. 반환
        return "작성 성공";

        // SQL문 하나도 없이 저장 성공!
    }

    @GetMapping("/getlist")
    public void getlist(HttpServletResponse response){
        // 1. 모든 엔티티를 호출하기
        List<TestEntity> testEntity = testRepository.findAll();
            // .findAll() : 모든 엔티티를 호출
        // 2. JSON화 하기
        JSONArray array = new JSONArray();
        for(TestEntity tmp : testEntity){
            JSONObject object = new JSONObject();
            object.put("no", tmp.no);
            object.put("content", tmp.content);
            array.put(object);
        }
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json");
            response.getWriter().print(array);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/update")
    @ResponseBody
    @Transactional  // javax 트랜잭션 어노테이션
    public String update(HttpServletRequest request) throws IOException{
        request.setCharacterEncoding("utf-8");
        // 1. 변수 요청하기
        int no = Integer.parseInt(request.getParameter("no"));
        String content = request.getParameter("content");

        // 2. PK값을 이용한 엔티티 찾기
        Optional<TestEntity> optionalTestEntity = testRepository.findById(no);
            // Optional 클래스 : 제네릭 클래스의 객체를 저장, 만약 null이면 터지지 않고 저장
        // 3. Option 엔티티 빼오기 [ Optional 객체 내 실제 entity 가져오기 ]
        TestEntity entity = optionalTestEntity.get();
        // 4. 수정하기
        entity.content = content;
        return "1";
    }

    @GetMapping("/delete")
    @ResponseBody
    public String delete(HttpServletRequest request){
        int no = Integer.parseInt(request.getParameter("no"));
        Optional<TestEntity> optionalTestEntity = testRepository.findById(no);

        // Optional 내 엔티티 삭제하기
        TestEntity entity = optionalTestEntity.get();
        testRepository.delete(entity);
        return "1";
    }

    // 매핑의 종류는 총 다섯가지가 있다!.
    // @RequestMapping  : 모든 URL 매핑 가능.
    // @GetMapping      : GET 메서드 URL 매핑
    // @PostMapping     : POST 메서드 URL 매핑
    // @PutMapping      : PUT 메서드
    // @DeleteMapping   :
}
