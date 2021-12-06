/*
	직급에 다음 데이터를 추가하는 쿼리 작성
    사원, 대리, 과장, 부장, 전무, 이사, 대표이사

*/

/* insert department(de_department) value ('사원');
insert department(de_department) value ('대리');
insert department(de_department) value ('과장');
insert department(de_department) value ('부장');
insert department(de_department) value ('전무');
insert department(de_department) value ('이사');
insert department(de_department) value ('대표이사');
*/
/*
insert salary(sa_level, sa_base_salary, sa_add_salary) value ('사원', 200, 10);
insert salary(sa_level, sa_base_salary, sa_add_salary) value ('대리', 230, 15);
insert salary(sa_level, sa_base_salary, sa_add_salary) value ('과장', 250, 20);
insert salary(sa_level, sa_base_salary, sa_add_salary) value ('부장', 280, 30);
insert salary(sa_level, sa_base_salary, sa_add_salary) value ('전무', 300, 35);
insert salary(sa_level, sa_base_salary, sa_add_salary) value ('이사', 350, 40);
insert salary(sa_level, sa_base_salary, sa_add_salary) value ('대표이사', 400, 50);
-----------------------------------위와 아래와 동일한 문구-----------------------------------------------
insert into salary
	values ('사원', 200, 10),('대리', 230, 15),('과장', 250, 20),('부장', 280, 30),('전무', 300, 35),
			('이사', 350, 40),('대표이사', 400, 50);
*/
-- insert into department values ('영업'),('회계'),('관리'),('마케팅'),('개발');

select * from employee;
-- insert into employee values(2019001, '123456-1234567', '홍길동', '사원', 2, '회계', 2019);








