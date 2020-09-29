create table earthquake
(
   id numeric(8) not null primary key auto_increment,
   start_time varchar(255),
   end_time varchar(255),
   min_magnitude varchar(255),
   max_magnitude varchar(255),
   earthquakes clob
); 