insert into sport_event (ID, EVENT_NAME, REWARD, EVENT_DATE, USER_ID)
values (101, 'Footbal game event', 'Laptop', '2023-05-15', null);
insert into sport_event (ID, EVENT_NAME, REWARD, EVENT_DATE, USER_ID)
values (102, 'Basketball game event', 'Cellphone', '2023-05-11', null);
insert into sport_event (ID, EVENT_NAME, REWARD, EVENT_DATE, USER_ID)
values (103, 'Hockey game event', 'Keyboard', '2023-05-10', null);
insert into sport_event (ID, EVENT_NAME, REWARD, EVENT_DATE, USER_ID)
values (104, 'Baseball game event', 'Guitar', '2023-05-10', null);
insert into sport_event (ID, EVENT_NAME, REWARD, EVENT_DATE, USER_ID)
values (105, 'Cricket game event', 'Ipad', '2023-05-10', null);
insert into sport_event (ID, EVENT_NAME, REWARD, EVENT_DATE, USER_ID)
values (106, 'Tennis game event', 'Microwave', '2023-05-10', null);
insert into sport_event (ID, EVENT_NAME, REWARD, EVENT_DATE, USER_ID)
values (107, 'Polo game event', 'Fridge', '2023-05-10', null);

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


insert into user_details (ID, FIRST_NAME, LAST_NAME, EMAIL_ADDRESS)
values (1001, 'Ivan', 'Ivanov', 'vaodincova@fa.ru');
insert into user_details (ID, FIRST_NAME, LAST_NAME, EMAIL_ADDRESS)
values (1002, 'Petr', 'Petrov', 'kagorshkov@fa.ru');
insert into user_details (ID, FIRST_NAME, LAST_NAME, EMAIL_ADDRESS)
values (1003, 'Sidor', 'Sidorov', 'malitvina@fa.ru');
insert into user_details (ID, FIRST_NAME, LAST_NAME, EMAIL_ADDRESS)
values (1004, 'Anton', 'Antonov', 'dokarpeev@fa.ru');
insert into user_details (ID, FIRST_NAME, LAST_NAME, EMAIL_ADDRESS)
values (1005, 'Egor', 'Egorov', 'teelxp@inbox.ru');
insert into user_details (ID, FIRST_NAME, LAST_NAME, EMAIL_ADDRESS)
values (1006, 'Ignat', 'Ignatov', 'koroteevmv@gmail.com');
insert into user_details (ID, FIRST_NAME, LAST_NAME, EMAIL_ADDRESS)
values (1007, 'Ashot', 'Ashotov', 'gnzholobova@fa.ru');


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


update sport_event
set USER_ID = 1001 where ID = 101;
update sport_event
set USER_ID = 1002 where ID = 102;
update sport_event
set USER_ID = 1003 where ID = 103;
update sport_event
set USER_ID = 1004 where ID = 104;
update sport_event
set USER_ID = 1005 where ID = 105;
update sport_event
set USER_ID = 1006 where ID = 106;
update sport_event
set USER_ID = 1007 where ID = 107;