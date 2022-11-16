insert into users (name, email, password, nickname, activated) values ('관리자', 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin', 1);
insert into users (name, email, password, nickname, activated) values ('유저', 'user', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'user', 1);

insert into authority (authority_name) values ('ROLE_USER');
insert into authority (authority_name) values ('ROLE_ADMIN');

insert into user_authority (id, authority_name) values (1, 'ROLE_USER');
insert into user_authority (id, authority_name) values (1, 'ROLE_ADMIN');
insert into user_authority (id, authority_name) values (2, 'ROLE_USER');
