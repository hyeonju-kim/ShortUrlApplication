# 미니프로젝트 ShortUrl Application 만들기

## **화면 기능 설명**

1.  원하는 사이트의 url 주소를 텍스트 창에 입력하면, 등록시간과 함께 유니크한 짧은 url 주소를 반환한다.
2.  짧은 url주소를 클릭하면, 원래의 긴 url주소를 입력하는 것처럼 리다이렉트된다.
3.  같은 주소를 등록하게 되면, AOP를 사용하여 익셉션을 던져 에러페이지를 반환한다.
4.  naver, daum이 포함된 주소는 마찬가지로 AOP기능을 사용하여 익셉션을 던져 에러페이지를 반환한다.
5.  짧은 url에 3이 포함된 주소를 리다이렉트 할 시에는 인터셉터를 사용하여 등록페이지로 리다이렉트된다.
6.  짧은 url을 호출하면, 리다이렉트된 호출의 수가 카운트 되어 대시보드 창에 나타난다.

## **사용한  기술스택**

1.  Spring Web MVC
2.  Spring Boot v2.7.11 (Gradle, java17)
3.  H2 DB (RDB)
4.  Spring Data JPA (ORM)
5.  AWS EC2(Infra)
6.  Thymeleaf

<div align\=center\>

<img src\="[https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white](https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white)"\>

<img src\="[https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white](https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white)"\>

<img src\="[https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white](https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white)"\>

<img src\="[https://img.shields.io/badge/bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white](https://img.shields.io/badge/bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white)"\>

<img src\="[https://img.shields.io/badge/amazonaws-232F3E?style=for-the-badge&logo=amazonaws&logoColor=white](https://img.shields.io/badge/amazonaws-232F3E?style=for-the-badge&logo=amazonaws&logoColor=white)"\>

<img src\="[https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white](https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white)"\>

<img src\="[https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white](https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white)"\>

<img src\="[https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white](https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white)"\>

##  **소요기간**

약 3주간 (23/5/9~5/27)

> 진행 과정을 \[[기술 블로그\](www.yeees.com)](http://www.yeees.tistory.com/)에 정리했습니다.

<p align="center">
  <img src="https://github.com/hyeonju-kim/ShortUrlApplication/assets/58349668/602a4033-1adc-4876-8ab8-e4c954f710d1">
</p>
