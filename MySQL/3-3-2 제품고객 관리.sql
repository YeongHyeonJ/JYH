select * from 고객;
select distinct 등급 from 고객;

select * from 주문
	where 주문고객 = 'apple';
    
select distinct 제품명 from 주문
	join 제품 on 주문제품  = 제품번호 
    where 주문고객 = 'apple';
    
select distinct 고객이름 as 고객명단 from 고객
	join 주문 on 주문고객 = 고객아이디
    join 제품 on 주문제품 = 제품번호
    where 제품명 = '쿵떡파이';
