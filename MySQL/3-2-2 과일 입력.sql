/*
insert into fruit values('딸기'	,	5000,	0,	'박스');
insert into fruit values('바나나'	,	4000,	0,	'송이');
insert into fruit values('포도'	,	10000,	0,	'상자');
insert into fruit values('수박'	,	12000,	0,	'EA');
insert into fruit values('귤'	,	10000,	0,	'박스');
*/
-- insert into store values ('행복과일가게', '청주시'),('과일상','청주시'),('과일상회','청주시');

-- 과일상회에서 딸기를 100상자를 개당 4000원에 구매를 했다. 날짜 : '2021-11-24 15:10:00'

-- insert into buy(bu_fr_name, bu_amount, bu_date, bu_unit, bu_st_name) 
-- 	values ('딸기', 100, '2021-11-24 15:10:00', '박스', '과일상회');

-- update fruit set fr_amount = fr_amount + 100 where fr_name = '딸기';

-- insert into sell(se_fr_name, se_amount, se_unit, se_price, se_date, se_type)
-- 	values('딸기', 2, '상자', 10000, now(), '현금');

-- update fruit set fr_amount = fr_amount - 2 where fr_name = '딸기';