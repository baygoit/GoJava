prompt PL/SQL Developer import file
prompt Created on 29.07.2015 by Veet
set feedback off
set define off
prompt Disabling triggers for CATEGORY...
alter table CATEGORY disable all triggers;
prompt Disabling triggers for PROJECT...
alter table PROJECT disable all triggers;
prompt Disabling triggers for FAQ...
alter table FAQ disable all triggers;
prompt Disabling triggers for MESSAGE...
alter table MESSAGE disable all triggers;
prompt Disabling triggers for PROJECT_EVENT...
alter table PROJECT_EVENT disable all triggers;
prompt Disabling triggers for REWARD...
alter table REWARD disable all triggers;
prompt Disabling foreign key constraints for PROJECT...
alter table PROJECT disable constraint PROJECT_CATEGORY_ID_FK;
prompt Disabling foreign key constraints for FAQ...
alter table FAQ disable constraint FAQ_PROJECT_ID_FK;
prompt Disabling foreign key constraints for PROJECT_EVENT...
alter table PROJECT_EVENT disable constraint PROJECT_EVENT_PROJECT_ID_FK;
prompt Disabling foreign key constraints for REWARD...
alter table REWARD disable constraint REWARD_PROJECT_ID_FK;
prompt Deleting REWARD...
delete from REWARD;
commit;
prompt Deleting PROJECT_EVENT...
delete from PROJECT_EVENT;
commit;
prompt Deleting MESSAGE...
delete from MESSAGE;
commit;
prompt Deleting FAQ...
delete from FAQ;
commit;
prompt Deleting PROJECT...
delete from PROJECT;
commit;
prompt Deleting CATEGORY...
delete from CATEGORY;
commit;
prompt Loading CATEGORY...
insert into CATEGORY (category_id, name)
values (1, 'Category1');
insert into CATEGORY (category_id, name)
values (2, 'Category2');
insert into CATEGORY (category_id, name)
values (3, 'Category3');
commit;
prompt 3 records loaded
prompt Loading PROJECT...
insert into PROJECT (project_id, name, description, goal, balance, create_date, deadline_date, demo_link, category_id)
values (1, 'Project1 in category1', 'this is description', 30000, 18250, to_date('16-07-2015', 'dd-mm-yyyy'), to_date('30-07-2015', 'dd-mm-yyyy'), null, 1);
insert into PROJECT (project_id, name, description, goal, balance, create_date, deadline_date, demo_link, category_id)
values (2, 'Project2 in category 1', 'this is description', 3256, 1, to_date('08-07-2015', 'dd-mm-yyyy'), to_date('06-08-2015', 'dd-mm-yyyy'), 'http://stackoverflow.com/', 1);
commit;
prompt 2 records loaded
prompt Loading FAQ...
insert into FAQ (faq_id, question, answer, project_id)
values (1, 'fist question', null, 1);
insert into FAQ (faq_id, question, answer, project_id)
values (2, 'question with answer', 'this is answer', 1);
commit;
prompt 2 records loaded
prompt Loading MESSAGE...
insert into MESSAGE (id, text)
values (1, 'Hello from Database');
commit;
prompt 1 records loaded
prompt Loading PROJECT_EVENT...
insert into PROJECT_EVENT (project_event_id, event_date, message, project_id)
values (1, to_date('22-07-2015', 'dd-mm-yyyy'), 'Thank you', 1);
insert into PROJECT_EVENT (project_event_id, event_date, message, project_id)
values (2, to_date('23-07-2015', 'dd-mm-yyyy'), 'We are started', 1);
commit;
prompt 2 records loaded
prompt Loading REWARD...
insert into REWARD (reward_id, amount, description, project_id)
values (1, 1000, 'Some reward for donate 10$', 1);
insert into REWARD (reward_id, amount, description, project_id)
values (2, 3000, 'Some reward for donate 30$', 1);
insert into REWARD (reward_id, amount, description, project_id)
values (3, 4000, 'Some reward for donate 40$', 1);
commit;
prompt 3 records loaded
prompt Enabling foreign key constraints for PROJECT...
alter table PROJECT enable constraint PROJECT_CATEGORY_ID_FK;
prompt Enabling foreign key constraints for FAQ...
alter table FAQ enable constraint FAQ_PROJECT_ID_FK;
prompt Enabling foreign key constraints for PROJECT_EVENT...
alter table PROJECT_EVENT enable constraint PROJECT_EVENT_PROJECT_ID_FK;
prompt Enabling foreign key constraints for REWARD...
alter table REWARD enable constraint REWARD_PROJECT_ID_FK;
prompt Enabling triggers for CATEGORY...
alter table CATEGORY enable all triggers;
prompt Enabling triggers for PROJECT...
alter table PROJECT enable all triggers;
prompt Enabling triggers for FAQ...
alter table FAQ enable all triggers;
prompt Enabling triggers for MESSAGE...
alter table MESSAGE enable all triggers;
prompt Enabling triggers for PROJECT_EVENT...
alter table PROJECT_EVENT enable all triggers;
prompt Enabling triggers for REWARD...
alter table REWARD enable all triggers;
set feedback on
set define on
prompt Done.
