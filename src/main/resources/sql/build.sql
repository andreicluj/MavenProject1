
drop table if exists category ;
create table category (
    id          integer not null,
    parent_id   integer,
    code        char(5) CONSTRAINT firstkey PRIMARY KEY,
    title       varchar(40) NOT NULL,
    date_prod   date,
    description varchar(100)
);


insert into category(id, parent_id,code,title,date_prod,description) values(1,0,'T1' , 'Mathematics', CURRENT_DATE, 'All mathematics');
insert into category(id, parent_id,code,title,date_prod,description) values(2,1,'T2' , 'Algebra', CURRENT_DATE, 'All algebra');
insert into category(id, parent_id,code,title,date_prod,description) values(3,1,'T3' , 'Geometry', CURRENT_DATE, 'All geometry');
insert into category(id, parent_id,code,title,date_prod,description) values(4,1,'T4' , 'Analysis', CURRENT_DATE, 'All analysis');
insert into category(id, parent_id,code,title,date_prod,description) values(5,2,'T5' , 'Number theory', CURRENT_DATE, 'All number theory');
