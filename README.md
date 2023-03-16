# time-deal-server

## time-deal-server v1.0
> **개발기간: 2023.03 ~ 2023.3**

## 프로젝트 소개

쇼핑몰 타임딜 서버의 API들을 구현해본 토이 프로젝트입니다.
- 회원가입, 로그인, 로그아웃, 회원탈퇴
- 상품등록, 상품수정, 상품삭제 상품 목록 조회
- 타임딜 등록, 타임딜 삭제, 타임딜 목록 조회
- 주문(동시성 제어)

---

## Stacks 🐈

### Environment
![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-007ACC?style=for-the-badge&logo=Visual%20Studio%20Code&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=Git&logoColor=white)
![Github](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=GitHub&logoColor=white)             

### Development
![Java](https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Spring Boot](https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/springdatajpa-6DB33F?style=for-the-badge&logo=springdatajpa&logoColor=white)


---
## ERD
<img width="1161" alt="v1" src="https://user-images.githubusercontent.com/62919440/225608421-f1fa633d-27f5-4b57-a097-39d4c915d957.png">

## 와이어 프레임
<img width="1500" alt="v1" src="https://user-images.githubusercontent.com/62919440/225608495-09e9d106-bb21-4cd2-9c4b-47cf76fdc61d.png">
⚠️ 프론트 단을 구현한 것이 아닌 API 설계 위한 간단한 와이어프레임

## API 명세서

### 회원

<details>
<summary>회원가입</summary>
<div markdown="1">


POST /user/new 

body : UserJoinRequestDto

```json
{
  "username" : "test",
  "password" : "1234",
  "passwordConfirm" : "1234",
  "email" : "test@google.com",
  "phoneNumber" : "010-1234-5678",
  "gender" : "WOMAN",
  "ROLE" : "USER"
}
```


</div>
</details>

<details>
<summary>로그인</summary>
<div markdown="1">


POST /user 

body : UserLoginRequestDto

```json
{
  "username" : "test",
  "password" : "1234"
}
```


</div>
</details>

<details>
<summary>로그아웃</summary>
<div markdown="1">


DELETE /user

</div>
</details>

<details>
<summary>회원 탈퇴</summary>
<div markdown="1">


DELETE /user/delete

</div>
</details>

---

### 상품

<details>
<summary>상품 등록</summary>
<div markdown="1">


POST /product 

body : ProductAddRequestDto

```json
{
  "name" : "testProduct",
  "price" : 10000,
  "brandName" : "testBrand"
}
```


</div>
</details>


<details>
<summary>상품 목록 조회</summary>
<div markdown="1">


GET /product 

return : ProductListResponseDto

```json
[
  {
    "name" : "testProduct1",
    "price" : 10000
  },
  {
    "name" : "testProduct2",
    "price" : 20000
  }
]
```


</div>
</details>

<details>
<summary>상품 수정</summary>
<div markdown="1">


PUT /product/{productId}

body : ProductModifyRequestDto

```json
{
  "price" : 10000
}
```


</div>
</details>

<details>
<summary>상품 삭제</summary>
<div markdown="1">


DELETE /product/{productId} 


</div>
</details>

---

### 타임딜

<details>
<summary>타임딜 등록</summary>
<div markdown="1">


POST /timedeal 

body : TimeDealAddRequestDto

```json
{
  "amount" : 10,
  "discountPrice" : 5000,
  "productId" : 1,
  "startTime" : "2023-04-01T00:00:00"
}
```


</div>
</details>


<details>
<summary>타임딜 목록 조회</summary>
<div markdown="1">


GET /timedeal 

return : TimeDealListResponseDto

```json
[
  {
    "name" : "testTimeDeal1",
    "discountPrice" : 5000,
    "originalPrice" : 10000,
    "amount" : 10,
    "startTime" : "2023-04-01T00:00:00"
  },
  {
    "name" : "testTimeDeal2",
    "discountPrice" : 7000,
    "originalPrice" : 30000,
    "amount" : 15,
    "startTime" : "2023-03-28T00:00:00"
  }
]
```


</div>
</details>

<details>
<summary>타임딜 수정</summary>
<div markdown="1">


PUT /timedeal/{timedealId}

body : TimeDealModifyRequestDto

```json
{
  "amount" : 15,
  "discountPrice" : 7000,
  "startTime" : "2023-03-27T00:00:00"
}
```


</div>
</details>

<details>
<summary>타임딜 삭제</summary>
<div markdown="1">


DELETE /timedeal/{timedealId} 


</div>
</details>

---

### 주문

<details>
<summary>주문</summary>
<div markdown="1">


POST /order 

body : OrderCreateRequestDto

```json
{
  "userId" : 1,
  "timeDealId" : 1,
  "price" : 5000,
}
```


</div>
</details>



