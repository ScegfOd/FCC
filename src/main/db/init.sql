drop table if exists users cascade;
create table users(
    uid varchar primary key,
    urole varchar not null,
    uname varchar not null,
    upassword varchar not null
);

drop table if exists orders cascade;
create table orders(
    oid bigserial primary key,
    uid varchar references users(uid),
    ostatus varchar not null,
    oitems varchar not null,
    ototal money not null,
    otime timestamp default now(),
    otc timestamp,
    ocb varchar,
    onote varchar
);

-- managers
insert into users values
('admin22', 'manager', 'Marcus Key', 'password1'),
('admin87', 'manager', 'Lana Lewis', 'password1');

-- employees
insert into users values
('empl13', 'employee', 'Manny Hinn', 'password1'),
('empl44', 'employee', 'Brenda Powers', 'password1'),
('empl15', 'employee', 'John Adams', 'password1');

-- guest; needed and will make more programming logic sense later on
insert into users values
('guest', 'guest', 'Guest', 'irrelevant');

-- customers
insert into users values
('jcombs@gmail.com', 'customer', 'Jonathan Combs', 'password'),
('chall@gmail.com', 'customer', 'Christian Hall', 'password');

-- on website, signup email will be checked if it's an email address (javascript code for this on discord)
-- also have to run signup email against database to see if that email already exist
-- first name and last name from signup will be concatenated in javascript
insert into users values
('dknight84@att.net', 'customer', 'David Knight', 'password'),
('clewis88@charter.net', 'customer', 'Charles Lewis', 'password'),
('zford84@gmail.com', 'customer', 'Zack Ford', 'password'),
('nloves22@yahoo.com', 'customer', 'Nathan Loves', 'password'),
('cruss21@outlook.com', 'customer', 'Chris Russ', 'password'),
('jsanchez36@gmail.com', 'customer', 'Jose Sanchez','password'),
('dpeters90@aol.com', 'customer', 'Don Peters', 'password'),
('bwilliams8@verizon.net', 'customer', 'Becky Williams', 'password'),
('klemon87@hotmail.com', 'customer', 'Karen Lemon', 'password'),
('lpeck24@gmail.com', 'customer', 'Larry Peck', 'password'),
('hsteins20@mail.com', 'customer', 'Harry Steins', 'password'),
('mevans43@aol.com', 'customer', 'Moe Evans', 'password'),
('tjackson5@hotmail.com', 'customer', 'Tina Jackson', 'password'),
('kchilds77@msn.com', 'customer', 'Kent Childs', 'password'),
('mtwain99@yahoo.com', 'customer', 'Martin Twain', 'password');

-- 4 ostatus: 'order placed' 'ready for pickup' 'completed' 'canceled'
-- order records will have to be refactored for 'oitems' since items/menus aren't completed yet
insert into orders values
(default,'dknight84@att.net', 'completed', 'REFACTOR', '25.36'),
(default,'clewis88@charter.net', 'completed', 'REFACTOR', '5.69'),
(default,'zford84@gmail.com', 'completed', 'REFACTOR', '15.38'),
(default,'nloves22@yahoo.com', 'canceled', 'REFACTOR', '7.98'),
(default,'cruss21@outlook.com', 'ready for pickup', 'REFACTOR', '21.05'),
(default,'jsanchez36@gmail.com', 'order placed', 'REFACTOR', '22.84'),
(default,'dpeters90@aol.com', 'order placed', 'REFACTOR', '12.33'),
(default,'bwilliams8@verizon.net', 'order placed', 'REFACTOR', '5.90'),
(default,'klemon87@hotmail.com', 'order placed', 'REFACTOR', '15.48'),
(default,'lpeck24@gmail.com', 'order placed', 'REFACTOR', '30.66'),
(default,'hsteins20@mail.com', 'order placed', 'REFACTOR', '3.25'),
(default,'mevans43@aol.com', 'order placed', 'REFACTOR', '9.57'),
(default,'tjackson5@hotmail.com', 'order placed', 'REFACTOR', '7.85'),
(default,'mtwain99@yahoo.com', 'order placed', 'REFACTOR', '21.45'),
(default,'guest', 'order placed', 'REFACTOR', '11.25');                  -- just added guest

