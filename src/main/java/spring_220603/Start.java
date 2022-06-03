package spring_220603;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Start {
    public static void main(String[] args) {
        SpringApplication.run(Start.class);
    }
}


// * API
// 1. Spring : JAVA를 이용한 미리 만들어진 다양한 API 묶음
    // 스프링부트 : 스프링 내 자주 사용되는 API들의 기본 세팅
        // @SpringBootApplication
        // 1. MVC 컴포넌트를 기본값으로 사용
        // 2. 탐켓을 내장.
        // 3. restful API : HTTP(URL)를 이용한 자원 공유

// 2. 타임리프 : 템플릿 엔진 ( 정적 문서->>HTML 에 데이터를 넣어주는 프로그램)
    // 템플릿 엔진의 종류
        // 백엔드 :  1. JSP(스프링에서는 미권장) - 2. 타임리프 - 3. 머스테치(스프링 공식)
        // 프론트엔드 : 1. REACT.js - 2. Vue.js
    // 백엔드(java / spring)   : 1. restful API 제작
    // 프론트엔드(JS)           : 1. RESTFUL API를 이용한 데이터 교환

    // 1. 스프링은 URL을 요청했을 때 @Controller 내에서 URL을 찾는다!