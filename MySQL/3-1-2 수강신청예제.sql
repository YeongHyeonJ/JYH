    
-- 2021160001 학번 학생이 컴퓨터개론 3분반 강의 신청, 알맞은 쿼리
-- insert into course(co_st_num, co_su_num) values(2021160001, 1);

-- 201160015 학번 학생이 컴퓨터개론 3분반 강의 신청
-- insert into course(co_st_num, co_su_num) 
-- select 2021160015, su_num from subject 
-- where su_class_num = 3 and su_title = '컴퓨터 개론';

-- 2021160123 학번 홍길동 학생이 수강중인 컴퓨터개론 3분반 성적이 A+ 입력
-- update course set co_score = 'A+' where co_st_num = '2021160123';

-- 홍길동 학생이 수강한 수강 과목의 수

select count(*) as '홍길동 학생 수강 과목 수' from course
	join student on co_st_num = st_num
    where st_name = '홍길동';
    
select count(*) as '컴퓨터개론 3분반 현재 수강 신청 인원' from course
	join subject on su_num = co_su_num
    where su_title = '컴퓨터 개론' and su_class_num = 3;
    
select count(*) as '이순신 교수님의 강의 수' from lecture
	join (select * from professor  where pr_name = '이순신') as t on pr_num = le_pr_num;