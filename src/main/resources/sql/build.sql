
drop table if exists category ;
create table category (
    id          integer not null,
    parent_id   integer,
    code        varchar(5) CONSTRAINT firstkey PRIMARY KEY,
    title       varchar(40) NOT NULL,
    date_prod   date,
    description varchar(100)
);


insert into category(id, parent_id,code,title,date_prod,description) values(1,null,'T1' , 'Mathematics', CURRENT_DATE, 'All mathematics');
insert into category(id, parent_id,code,title,date_prod,description) values(2,1,'ALG' , 'Algebra', CURRENT_DATE, 'All algebra');
insert into category(id, parent_id,code,title,date_prod,description) values(3,1,'GEO' , 'Geometry', CURRENT_DATE, 'All geometry');
insert into category(id, parent_id,code,title,date_prod,description) values(4,1,'T4' , 'Analysis', CURRENT_DATE, 'All analysis');
insert into category(id, parent_id,code,title,date_prod,description) values(5,2,'NUMTH' , 'Number theory', CURRENT_DATE, 'All number theory');


insert into category(id, parent_id,code,title,date_prod,description) values((SELECT MAX(ID) + 1 from category),(select id from category where code = 'GEO'),'G1' , 'Plane geometry', CURRENT_DATE, 'Plane geometry');
insert into category(id, parent_id,code,title,date_prod,description) values((SELECT MAX(ID) + 1 from category),(select id from category where code = 'GEO'),'G2' , 'Space geometry', CURRENT_DATE, 'Space geometry');
insert into category(id, parent_id,code,title,date_prod,description) values((SELECT MAX(ID) + 1 from category),(select id from category where code = 'GEO'),'G3' , 'Hilbert geometry', CURRENT_DATE, 'Hilbert geometry');

