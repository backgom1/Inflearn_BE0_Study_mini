# Inflearn_BE0_Study_mini 직원 관리 API

- 인프런 스터디 클럽 BE 0기 레포지토리 미니프로젝트 저장소
- 간단한 직원 등록, 조회, 삭제, 업데이트 기능을 갖춘 CRUD restful 구현

## 목차

- [요구사항](#요구사항)
- [프로젝트 상세 설명 링크](#프로젝트 상세 설명)
- [개발 스펙](#개발-스펙)
- [ERD](#erd)
- [기능별 설명](#프로젝트-기능별-설명)
  - [1. 직원 등록 기능](#1-직원-등록-기능)
  - [2-1. 팀 등록 기능](#2-1-팀-등록-기능)
  - [2-2. 직원의 팀 등록 기능](#2-2-직원의-팀-등록-기능)
  - [3. 팀 조회 기능](#3-팀-조회-기능)
  - [4. 직원 조회 기능](#4-직원-조회-기능)
- [팀원 피드백](#팀원-피드백)
- [트러블 슈팅 기록](#트러블-슈팅-기록)

- [참고 자료](#참고)

## 실행 방법

1. 프로젝트를 클론
   $ git clone https://github.com/backgom1/Inflearn_BE0_Study_mini.git

2. 프로젝트 디렉토리로 이동
   $ cd Inflearn_BE0_Study_mini

3. 의존성을 설치합니다.
   $ ./gradlew build

4. 서버를 실행합니다.
   $ ./gradlew bootRun

5. 브라우저에서 다음 URL로 접속합니다.
   http://localhost:8080

## 프로젝트 상세 설명

해당 프로젝트에 대해 더 자세히 설명된 자료는 `프로젝트상세.md`를 확인 하시면 될 것 같습니다.

## 요구사항

- [x] 1. 직원 등록 기능
- [x] 2. 팀 등록 기능
- [x] 3. 팀 조회 기능
- [x] 4. 직원 조회 기능
- [x] 5. 등록된 직원의 팀 등록 기능

## 개발 스펙

- Java 17
- jdk: [Amazon Corretto 17 - Amazon Corretto 17](https://docs.aws.amazon.com/corretto/latest/corretto-17-ug/downloads-list.html)
- [Spring Boot 3.2 ](https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-3.2-Release-Notes)
- Spring Data JPA
- [ MySQL 8.0 ](https://dev.mysql.com/doc/relnotes/mysql/8.0/en/)
- OS: window11, ubuntu lts 22.04.4
- gradle

[소스코드 링크](https://github.com/backgom1/Inflearn_BE0_Study_mini/tree/develop/nakyeonko3/nakyeonko3)

# 프로젝트 기능별 설명

해당 프로그램의 각 기능들은 아래의 방식으로 설명한다.

- `기능`: 해당 개발 프로젝트가 수행해야 되는 기능에 대해 상세히 설명함.
- `필수 입력 데이터`: 해당 기능을 사용하기 위해서 **반드시 입력되어야 하는 데이터**를 말함.
- `CASE`: 각 기능들의 유효성 처리, 특정 조건, 예외 상황 발생 시 조치 등을 적었다. 한걸음 더 부분에 해당

### ERD

ERD는 다음과 같다.
![](https://i.imgur.com/aQToQW1.png)

직원과 팀은 N:1 관계이다. 팀 하나에 팀이 여러명이 있을 수 있다.

employee테이블과 team테이블을 생성하는 ddl문을 작성했다.

해당 테이블들의 특징은 크게 두 가지가 있다.

1. **not null**: `work_start_date`를 제외한 모든 프로퍼티를 `not null`로 처리해서 db에 들어갈 데이터가 누락되지 않게 했다. 이를 통해 DB 자체에서도 유효성 검사를 할 수 있도록 했다.

2. **unique key**: 팀이름을 unique key로 지정해서 팀 이름이 중복 되서 들어가지 않게 했다

## 1. 직원 등록 기능

### 기능

- 직원을 등록 할 수 있어야 한다.
- 같은 이름을 가진 직원 등록을 허용한다.
- **필수 입력 데이터**: 직원 이름(name), 직무(role), 회사에 들어온 날짜(workStartDate), 생일(birthday), 직원 아이디(id)

### CASE

- 해당 기능 수행 시 필수 정보가 전부 다 등록 되지 않으면 다시 등록 절차를 수행한다.

> 처음에 동일한 이름이 등록되는 것을 막기 위해 경고 메시지를 출력하려 했지만, 다른 스터디원의 피드백을 듣고 지나치게 과한 처리라고 생각하고 삭제 했다.

```

- 한국에서 동명이인만 해도 수십명이 되는 경우가 있다.

```

- 직무(`role`)은 `MANAGER`와 `MANAGER` 외의 다른 문자열 입력을 허용하지 않는다. 매니저와 직원은 직무 외의 다른 직무 등록은 허용하지 않는다.
  > 이 부분은 Role Enum 클래스에 `MANAGER`와 `MANAGER` 만 등록 해둬서 다른 문자열 입력은 받지 않도록 했다.

## 2-1. 팀 등록 기능

### 기능

- 팀을 등록 할 수 있는 기능
- **필수 입력 데이터**: 팀 이름(name)

### CASE

- 해당 기능 수행 시 필수 정보가 전부 다 등록 되지 않으면 다시 등록 절차를 수행한다.
- 한 번에 1개의 팀을 등록 가능, 한 번에 2개의 팀을 등록 할 수 없다.
- 팀 이름은 중복 될 수 없다. 같은 이름의 팀 등록시 오류 메시지를 출력한다.

### 상세 구현

팀 엔티티와 팀 컨트롤러, 팀 서비스, 팀 리포지토리 클래스를 각각 만들어준다.

팀 등록 기능 구현시 팀 이름만 입력 받으면 되서 DTO는 만들지 않았다.

컨트롤러에서 팀 이름을 받고
서비스에서 팀 이름을 도메인을 가지고 리포지토리에 전달하도록 했다.

## 2-2. 직원의 팀 등록 기능

### 기능

- 직원이 처음에 팀을 등록하지 않기 때문에 등록된 기능이 팀을 등록할 수 있도록 이 기능을 만들었다.
- 등록된 직원이 팀을 등록할 수 있는 기능이다.
- **필수 입력 데이터**: 팀 이름(name), 직원(id)

### CASE

- 해당 기능 수행 시 필수 정보가 전부 다 등록 되지 않으면 다시 등록 절차를 수행한다.
- 한 번에 1개의 직원을 등록 가능, 한 번에 2명의 직원을 등록 할 수 없다.
- 입력된 직원 아이디를 검색하고 검색 결과가 없다면 오류 메시지를 출력한다. 등록되지 않은 직원의 등록을 허용하지 않는다.
- 팀 이름을 검색하고 검색 결과가 없다면 오류 메시지를 출력한다. 등록되지 않은 팀의 등록을 허용하지 않는다.

## 3. 팀 조회 기능

### 기능

- 모든 팀 조회 기능
- **필수 입력 데이터**: 없음
- 조회 데이터에는 팀이름(name), 매니저 이름(manager), 팀 인원수(memberCount)가 명시되어야함

### CASE

- 모든 팀의 정보를 한 번에 조회 할 수 있어야 한다.
- 특정 입력 데이터 없이도 팀 조회 기능 사용 가능하다.
- 팀 매니저 명은 누락될 수 있다. 특정 팀은 팀명만 등록되고 매니저 명은 등록되지 않을 수 있다.
- 팀 인원수 변수는 만들었다가 제거했다. 이유는 sql 쿼리문 count를 이용해서 충분히 팀 인원수를 구할 수 있다.
- **한 팀 당 다수의 매니저가 존재 할 수도 있다.** 매니저의 숫자는 명시 되지 않았다.

![](https://i.imgur.com/dQhzfmo.png)

## 4. 직원 조회 기능

### 기능

- 모든 직원의 정보를 한 번에 조회할 수 있어야 함.
- 조건 없이 직원 정보를 전체를 조회 할 수 있음.
- **필수 입력 데이터**: 없음

- 조회 된 데이터에는 직원 이름( name), 매니저명(manager), 직무(role), 생일(birthday), 회사에 들어온 날짜(workStartDate) 가 명시 되어야 한다.

### CASE

- 모든 직원의 정보를 한 번에 조회 할 수 있어야 한다.
- 특정 입력 데이터 없이도 직원 조회 기능 사용 가능하다.
- 직원 아이디를 이용해 조회해야 한다. 직원 이름은 동일한 이름이 여러 개 존재할 수 있다.

---

## 프로젝트 개선 사항

- count 함수를 이용해서 팀 인원수를 구할 수 있으니, 팀 인원 수를 DB에 굳이 저장을 할 필요가 없다.

- 생일(birthday) 부분은은 dateime을 쓰기 보다는 date를 쓰는 것을 추천한다.

- sql은 snake case로 작성 하는 걸 추천함  `user_login_log`
- url은 케밥 케이스로 작성하는 걸 추천한다. ` user-login-log`

- 동명이인에 대한 검사는 이메일이나 email이나 주민번호 같은 것으로 검사하는 것이 좋다.
- 미국은 최소 수십명의 동명이인이 존재한다. 동명이인이 입력 될 때 마다 동일한 이름이 입력될 때 마다 경고 메시지를 보내는 것은 과하다.
- 생각해보면 email이나 주민번호로 아이디 중복을 막는 것이 좋다.

- 같은 팀이름이 중복되서 등록되지 않도록, Mysql에서 테이블에 팀이름 필드에 unique key제약 조건을 걸어주는 것이 괜찮을까? 아니면 Spring에서 service 레이어에서 팀이름 중복을 검사하는 것이 좋을까?

- 서비스 클래스에서 읽기 전용 메서드는 트랜잭션을 `@Transaction(readOnly=True)`로 바꾸는 것이 좋다.

- readOnly=True로 지정하여 읽기 전용 메서드로 지정되면 jpa에서 변경감지, 스냅샷 저장을 하지 않는다.
  메모리상 성능 이점을 크게 누릴 수 있다.

## 트러블 슈팅 기록

### Error creating bean with name 'requestMappingHandlerMapping' defined in class path resource. ambiguous mapping. Cannot map method

동일한 url을 가진 레스트컨트롤러 메서드가 존재하면 이런 에러가 난다.

```

.springframework.beans.factory.BeanCreationException: Error creating bean with name 'requestMappingHandlerMapping' defined in class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]: Ambiguous mapping. Cannot map 'employeeController' method
com.group.companytimeclockapp.controller.EmployeeController#saveEmployee(EmployeeSaveRequest)
to {POST [/employee]}: There is already 'employeeController' bean method

```

#### Error: creating bean with name 'requestMappingHandlerMapping' defined in class path resource.

아래 메시지는 스프링 빈에서`requestMappingHandlerMapping  `를 생성하는 중에 에러가 발생했다는 뜻이다.

아래 에러 로그 영문을 해석 해보면 employeeController가 `{POST [/employee]}` 에 매핑된 메서드가 존재한다는 뜻이다.

같은 uri 주소를 가지는 메서드가 2개 이상 존재하기 때문에 이런 오류가 난 것이다.
`

```

.springframework.beans.factory.BeanCreationException: Error creating bean with name 'requestMappingHandlerMapping' defined in class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]: Ambiguous mapping. Cannot map 'employeeController' method
com.group.companytimeclockapp.controller.EmployeeController#saveEmployee(EmployeeSaveRequest)
to {POST [/employee]}: There is already 'employeeController' bean method

```

에러 메시지를 확인하고 바로 어디서 에러가 났는지 확인 할 수 있었기 때문에 큰 문제가 아니였다.

[RequestMappingHandlerMapping](https://docs.spring.io/spring-framework/docs/3.2.0.M1_to_3.2.0.M2/Spring%20Framework%203.2.0.M2/org/springframework/web/servlet/mvc/method/annotation/RequestMappingHandlerMapping.html) 은 스프링 웹 MVC 프레임워크 코드의 일부로 @Controller 클래스 안에 정의된 @RequestMapping 어노테이션을 인스턴스로 생성하는 클래스이다.

## 참고 자료

- [자바-스프링부트-서버개발-올인원-인프런](https://www.inflearn.com/course/lecture?courseSlug=%EC%9E%90%EB%B0%94-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8-%EC%84%9C%EB%B2%84%EA%B0%9C%EB%B0%9C-%EC%98%AC%EC%9D%B8%EC%9B%90&unitId=208208)

- `SpringBoot` 공식 문서
  [Spring Boot Reference Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#getting-started)

- [📋 데이터 모델링 개념 & ERD 다이어그램 작성 💯 총정리](https://inpa.tistory.com/entry/DB-%F0%9F%93%9A-%EB%8D%B0%EC%9D%B4%ED%84%B0-%EB%AA%A8%EB%8D%B8%EB%A7%81-1N-%EA%B4%80%EA%B3%84-%F0%9F%93%88-ERD-%EB%8B%A4%EC%9D%B4%EC%96%B4%EA%B7%B8%EB%9E%A8)
