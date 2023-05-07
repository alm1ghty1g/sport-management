insert into sport_event (ID, EVENT_NAME, REWARD, EVENT_DATE)
values (101, 'Footbal game event', 'Laptop', '2023-12-12');
insert into sport_event (ID, EVENT_NAME, REWARD, EVENT_DATE)
values (102, 'Basketball game event', 'Cellphone', '2023-11-11');
insert into sport_event (ID, EVENT_NAME, REWARD, EVENT_DATE)
values (103, 'Hockey game event', 'Keyboard', '2023-10-10');

insert into organization (ID, ORGANIZATION_NAME, SPORT_EVENT_ID)
values (501, 'Dinamo', 101);
insert into organization (ID, ORGANIZATION_NAME, SPORT_EVENT_ID)
values (502, 'Spartak', 102);
insert into organization (ID, ORGANIZATION_NAME, SPORT_EVENT_ID)
values (503, 'Juventus', 103);
insert into organization (ID, ORGANIZATION_NAME)
values (504, 'Dinamo');
insert into organization (ID, ORGANIZATION_NAME)
values (505, 'Spartak');
insert into organization (ID, ORGANIZATION_NAME)
values (506, 'Juventus');


insert into user_details (ID, FIRST_NAME, LAST_NAME)
values (1001, 'Ivan', 'Ivanov');
insert into user_details (ID, FIRST_NAME, LAST_NAME)
values (1002, 'Petr', 'Petrov');
insert into user_details (ID, FIRST_NAME, LAST_NAME)
values (1003, 'Sidor', 'Sidorov');
insert into user_details (ID, FIRST_NAME, LAST_NAME)
values (1004, 'Anton', 'Antonov');
insert into user_details (ID, FIRST_NAME, LAST_NAME)
values (1005, 'Egor', 'Egorov');



insert into participant (ID, FIRST_NAME, LAST_NAME, ORGANIZATION_ID)
values (601, 'Oleg', 'Olegov', 501);
insert into participant (ID, FIRST_NAME, LAST_NAME, ORGANIZATION_ID)
values (602, 'Dmitry', 'Dmitriev', 501);
insert into participant (ID, FIRST_NAME, LAST_NAME, ORGANIZATION_ID)
values (603, 'Vasek', 'Vasin', 501);
insert into participant (ID, FIRST_NAME, LAST_NAME, ORGANIZATION_ID)
values (604, 'Tolik', 'Tolikov', 502);
insert into participant (ID, FIRST_NAME, LAST_NAME, ORGANIZATION_ID)
values (605, 'Slava', 'Slavikov', 502);
insert into participant (ID, FIRST_NAME, LAST_NAME, ORGANIZATION_ID)
values (606, 'George', 'Georgiev', 502);
insert into participant (ID, FIRST_NAME, LAST_NAME, ORGANIZATION_ID)
values (607, 'Arkadi', 'Arkadiev', 503);
insert into participant (ID, FIRST_NAME, LAST_NAME, ORGANIZATION_ID)
values (608, 'Ildar', 'Ildarov', 503);
insert into participant (ID, FIRST_NAME, LAST_NAME, ORGANIZATION_ID)
values (609, 'Igor', 'Igorev', 503);

