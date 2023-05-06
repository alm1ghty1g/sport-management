insert into organization (ID, ORGANIZATION_NAME)
values (501, 'Dinamo');
insert into organization (ID, ORGANIZATION_NAME)
values (502, 'Spartak');
insert into organization (ID, ORGANIZATION_NAME)
values (503, 'Juventus');


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


insert into reward (ID, REWARD_NAME, ORGANIZATION_ID)
values (201, 'Laptop',503);
insert into reward (ID, REWARD_NAME, ORGANIZATION_ID)
values (202, 'Cellphone', 502);
insert into reward (ID, REWARD_NAME, ORGANIZATION_ID)
values (203, 'Keyboard', 501);


insert into sport_event (ID, EVENT_NAME, REWARD_ID)
values (101, 'Footbal game event', 201);
insert into sport_event (ID, EVENT_NAME, REWARD_ID)
values (102, 'Basketball game event', 202);
insert into sport_event (ID, EVENT_NAME, REWARD_ID)
values (103, 'Hockey game event', 203);


update organization
set SPORT_EVENT_ID = 101 WHERE ID = 501;
update organization
set SPORT_EVENT_ID = 102 WHERE ID = 502;
update organization
set SPORT_EVENT_ID = 103 WHERE ID = 503;

