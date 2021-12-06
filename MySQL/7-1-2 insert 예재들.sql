SELECT * FROM shoppingmall.category;
--  카테고리 항목 추가
/* insert into category(ca_main,ca_sub)
	values('아우터','점퍼'),('아우터','코트'),('상의','티셔츠'),('상의','블라우스/셔츠'),('하의','데님'),('하의','팬츠'),('하의','스커트');
*/

-- 제품목록 추가
/*
insert into goods 
	values(1, '아크 폭스터 패딩', 159000, '패딩', 1),
    (2, '엘비아 앙모코트', 229000, '앙모코트', 2),
    (3, '클로 다운후드', 99000, '다운후드', 3),
    (4, '파코 레이어드탑', 43000, '탑', 4),
    (5, '기모 와이드 데님팬츠', 43000, '데님팬츠', 5),
    (6, '롤스 버튼 팬츠', 36000, '버튼팬츠', 6);
*/
-- insert into address(ad_name,ad_address,ad_post_num,ad_address_detail) value('홍길동','청주시','1234','그린컴퓨터');
-- insert into member values('abc123', 'abc123', '홍길동', '010-1234-5678', '남',1);

-- insert into shoppingmall.option values(1,'화이트','s',10,1);
-- insert into `order` values('2021HNT001', 'abc123', 1, now(), 1, 159000);
-- update `option` set op_stock = op_stock - 1 where op_num = 1;

-- insert into review values(1, 'abc123', 1, '패딩좋아요', '따듯해요' , now());

select gd_name from goods join category 
	on goods.ca_num = category.ca_num
		where ca_main = '아우터';
-- 아우터 중에서 구매가 가능한 모든제품 확인, 재고가 있는지.
select gd_name as '구매가능한 아우터' from goods join category
	on goods.ca_num = category.ca_num
    join `option`
    on gd_num = op_num
    where ca_main = '아우터' and op_stock > 0;
    
select goods.* from 
	(select *from `order` where or_state != '주문취소' and or_state != '환불' ) as order2
    join `option` on or_op_num = op_num 
	join goods on gd_num =  op_gd_num 
    join 
    (select * from category where ca_main = '아우터') as category2
	on category2.ca_num = goods.ca_num    
    group by gd_num
    order by sum(or_amount) desc
    limit 4;
    
-- 등록된 아우터 제품종류 전체개수 확인
	select count(*) from goods join category on goods.ca_num = category.ca_num
		where ca_main = '아우터';
    
    select * from goods
		join category on category.ca_num = goods.ca_num
        where ca_main = '아우터'
        limit 10, 10;
        ;
    
-- abc123 회원의 주문한 횟수
	
select count(*) from `order`
	where or_me_id = 'abc123';
    
-- abc123 회원의 상반기 사용 금액

select sum(or_total_price) from `order`
	where or_me_id = 'abc123' and or_state = '결제완료' and or_date like '2021%' and or_date < '2021-07-01';

select * from review join goods
	on re_gd_num = gd_num;