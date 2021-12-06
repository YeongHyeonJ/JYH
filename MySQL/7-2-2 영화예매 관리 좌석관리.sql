select th_name as '위치', sc_date as '날짜', mo_title as '영화제목', sc_option ,  mo_age as '연령', sc_room_num as '상영관', sc_time as '상영시작시간',  
		mo_runtime as '상영시간', th_seat_count as '남은좌석' 
	from `schedule` 
    join theater on sc_th_num = th_num
    join movie on sc_mo_num = mo_num
    where sc_date = '2021-12-01';
    
-- insert ticketing values(1,'abc123',2);
-- insert ticketing_list values(1,1,2),(2,1,3);

update `schedule` set sc_seat = sc_seat - 2 
	where sc_date = '2021-12-01' and sc_time = '21:20' and sc_room_num = 1;
select * from schedule;
select tl_num as '예매번호', tk_me_id as '예매 아이디', sc_date as '날짜', sc_time as '상영시간', mo_title as '영화제목', st_name as '좌석', st_room_num as '상영관' from ticketing_list
	join ticketing on tl_tk_num = tk_num
    join schedule on tk_sc_num = sc_num
    join movie on sc_mo_num = mo_num
    join seat on tl_st_num = st_num
    where tk_me_id = 'abc123'
	;

select th_name, st_room_num, st_name from seat join theater on st_th_num = th_num where th_name = 'cgv강남점' and st_room_num = 1;

select * from ticketing_list 
	join ticketing on tl_tk_num = tk_num
    join schedule on tk_sc_num = sc_num
    where sc_th_num = 1 and sc_room_num = 1 and sc_date = '2021-12-01' and sc_time = '21:20';
    
select st_name from seat left 
		join(select * from ticketing_list
				join ticketing on tl_tk_num = tk_num
				where tk_sc_num = 2) 
			as tl 
        on st_num = tl_st_num
        where st_th_num = 1 and st_room_num = 1 and tl_num is null;