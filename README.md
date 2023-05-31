## **✨ 미니 개인프로젝트 ShortUrl Application 만들기**

## **👉🏻 화면 기능 설명**

1.  원하는 사이트의 url 주소를 텍스트 창에 입력하면, 등록시간과 함께 **유니크한 짧은 url 주소**를 반환한다.
2.  짧은 url주소를 클릭하면, 원래의 긴 url주소를 입력하는 것처럼 **리다이렉트**된다.
3.  **이미 등록한 주소**를 등록하게 되면, AOP를 사용하여 익셉션을 던져 **에러페이지**를 반환한다.
4.  **naver, daum이 포함된 주소**는 마찬가지로 AOP기능을 사용하여 익셉션을 던져 **에러페이지**를 반환한다.
5.  짧은 url에 **3이 포함된 주소**를 리다이렉트 할 시에는 인터셉터를 사용하여 **등록페이지로 리다이렉트**된다.
6.  짧은 url을 호출하면, **리다이렉트된 호출의 수**가 **카운트** 되어 대시보드 창에 나타난다.

## **⚙ 기술 스택**

1.  Spring Web MVC
2.  Spring Boot v2.7.11 (Gradle, java17)
3.  H2 DB (RDB)
4.  Spring Data JPA (ORM)
5.  AWS EC2(Infra)
6.  Thymeleaf

## **👉🏻 소요기간**

**약 3주간 (23/5/9~5/27)**

## **👉🏻 시연영상**
<p align="center">
  <img src="https://github.com/hyeonju-kim/ShortUrlApplication/assets/58349668/602a4033-1adc-4876-8ab8-e4c954f710d1">
</p>

> 진행 과정을 [기술 블로그](https://yeees.tistory.com/180)에 정리했습니다.
