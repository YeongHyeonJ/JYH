-- 과일 판매 내역을 확인

select se_date, se_fr_name, se_amount, se_price, se_type from sell;

select now() > '2021-11-26';

select se_date, se_fr_name, se_amount, se_price, se_type from sell
	where '2021-11-23' < se_date < '2021-11-25';
    
-- 오늘 과일 판매 총액
select sum(se_price) as '오늘 판매액' from sell
	where '2021-11-23' < se_date < '2021-11-25';
    
-- 딸기 총 판매액을 확인
select sum(se_price) as '딸기 판매액' from sell
	where se_fr_name = '딸기';

-- 현금 결제 금액
select sum(se_price) as '현금 판매액' from sell
	where se_type = '현금';
    
