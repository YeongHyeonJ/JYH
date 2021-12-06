select (sa_base_salary + sa_add_salary * em_year) as '홍길동 급여' from employee
	join salary on em_sa_level = sa_level;

select * from meployee;