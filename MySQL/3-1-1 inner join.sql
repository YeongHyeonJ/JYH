-- inner join : 테이블 순서에 상관없이 동일한 결과
select le_pr_num from lecture
	inner join subject
    on le_su_num = su_num
    where su_title = '컴퓨터 개론';
    
select le_pr_num from subject
	inner join lecture
    on le_su_num = su_num
    where su_title = '컴퓨터 개론';
    
select le_pr_num from subject
	join lecture
    on le_su_num = su_num
    where su_title = '컴퓨터 개론';
-- join만 써도 inner join과 같음 // 순서바꿔도 똑같음
select le_pr_num from lecture
	join subject
    on le_su_num = su_num
    where su_title = '컴퓨터 개론';
    
-- 컴퓨터 개론 3분반 강의를 듣는 학생들의 명단을 확인하는 쿼리를 작성
-- subject

select st_num, st_name from course
	join subject
		on co_su_num = su_num
    join student
		on co_st_num = st_num
        -- 조건을 걸기 : where을 써주고 과목제목 컴퓨터 개론을 선택, 클래스 넘버인 3반을 선택
	where su_title = '컴퓨터 개론' and su_class_num = 3;
    
    
-- 2021160123 학번 홍길동 학생이 수강한 모든 과목명을 확인
select st_num, st_name, su_title from course
	join student
		on co_st_num = st_num
	join subject
		on co_su_num = su_num
	where st_num = 2021160123 and st_name = '홍길동';

-- 이순신 교수님의 강의를 듣는 학생들 명단을 확인하는 쿼리
select st_name from lecture
	join professor on pr_num = le_pr_num
	left join course on co_su_num = le_su_num
	join student on co_st_num = st_num
    where pr_name = '이순신';

select * from course
	join subject on su_num = co_su_num
    join student on st_num = co_st_num
;


