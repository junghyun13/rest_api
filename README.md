일반사이트 주소체계
게시물 목록 : GET http://localhost:8080/article/list

게시물 등록(폼) : 게시물 등록 : POST http://localhost:8080/article/write OR GET http://localhost:8080/article/write

게시물 단건 조회 : GET http://localhost:8080/article/1

게시물 수정(폼) : 게시물 수정 : POST http://localhost:8080/article/1/modify OR GET http://localhost:8080/article/1/modify

게시물 삭제 : GET http://localhost:8080/article/1/delete

REST API 주소체계
게시물 목록 : GET http://localhost:8080/articles

게시물 등록 : POST http://localhost:8080/articles

게시물 단건 조회 : GET http://localhost:8080/articles/1

게시물 수정 : PATCH http://localhost:8080/articles/1 OR 게시물 수정 : PUT http://localhost:8080/articles/1

게시물 삭제 : DELETE http://localhost:8080/articles/1

회원 목록 : GET http://localhost:8080/members


http://localhost:8080/swagger-ui/index.html
rest api 스워거 문서 도입, 꾸미기
