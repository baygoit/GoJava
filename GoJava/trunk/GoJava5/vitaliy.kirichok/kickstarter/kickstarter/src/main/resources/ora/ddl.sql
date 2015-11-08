---------------------------------------------
-- Export file for user KICKSTARTER        --
-- Created by Veet on 29.07.2015, 17:44:14 --
---------------------------------------------

set define off
spool ddl.log

prompt
prompt Creating table CATEGORY
prompt =======================
prompt
-- noinspection SqlDialectInspection
create table CATEGORY
(
  category_id NUMBER not null,
  name        VARCHAR2(240) not null
)
;
comment on table CATEGORY
  is 'Categories';
comment on column CATEGORY.category_id
  is 'ID';
comment on column CATEGORY.name
  is 'Name';
alter table CATEGORY
  add constraint CATEGORY_PK primary key (CATEGORY_ID);

prompt
prompt Creating table PROJECT
prompt ======================
prompt
create table PROJECT
(
  project_id    NUMBER not null,
  name          VARCHAR2(240) not null,
  description   VARCHAR2(500),
  goal          NUMBER not null,
  balance       NUMBER,
  create_date   DATE not null,
  deadline_date DATE not null,
  demo_link     VARCHAR2(500),
  category_id   NUMBER not null
)
;
comment on table PROJECT
  is 'Projects';
comment on column PROJECT.project_id
  is 'ID';
comment on column PROJECT.name
  is 'Name';
comment on column PROJECT.description
  is 'Short description';
comment on column PROJECT.goal
  is 'Goal';
comment on column PROJECT.balance
  is 'Balance';
comment on column PROJECT.create_date
  is 'Create date';
comment on column PROJECT.deadline_date
  is 'Deadline date';
comment on column PROJECT.demo_link
  is 'Link on demonstration';
comment on column PROJECT.category_id
  is 'Link on category';
alter table PROJECT
  add constraint PROJECT_PK primary key (PROJECT_ID);
alter table PROJECT
  add constraint PROJECT_CATEGORY_ID_FK foreign key (CATEGORY_ID)
  references CATEGORY (CATEGORY_ID);

prompt
prompt Creating table FAQ
prompt ==================
prompt
create table FAQ
(
  faq_id     NUMBER not null,
  question   VARCHAR2(500) not null,
  answer     VARCHAR2(500),
  project_id NUMBER not null
)
;
comment on table FAQ
  is 'FAQ';
comment on column FAQ.faq_id
  is 'ID';
comment on column FAQ.question
  is 'Question';
comment on column FAQ.answer
  is 'Answer';
comment on column FAQ.project_id
  is 'Link on project';
alter table FAQ
  add constraint FAQ_PK primary key (FAQ_ID);
alter table FAQ
  add constraint FAQ_PROJECT_ID_FK foreign key (PROJECT_ID)
  references PROJECT (PROJECT_ID);

prompt
prompt Creating table MESSAGE
prompt ======================
prompt
create table MESSAGE
(
  id   NUMBER not null,
  text VARCHAR2(500) not null
)
;
comment on table MESSAGE
  is 'Messages';
comment on column MESSAGE.id
  is 'ID';
comment on column MESSAGE.text
  is 'Message';
alter table MESSAGE
  add constraint MESSAGE_PK primary key (ID);

prompt
prompt Creating table PROJECT_EVENT
prompt ============================
prompt
create table PROJECT_EVENT
(
  project_event_id NUMBER not null,
  event_date       DATE not null,
  message          VARCHAR2(500) not null,
  project_id       NUMBER not null
)
;
comment on table PROJECT_EVENT
  is 'Project_event';
comment on column PROJECT_EVENT.project_event_id
  is 'ID';
comment on column PROJECT_EVENT.event_date
  is 'Event date';
comment on column PROJECT_EVENT.message
  is 'Message';
comment on column PROJECT_EVENT.project_id
  is 'Link on project';
alter table PROJECT_EVENT
  add constraint PROJECT_EVENT_PK primary key (PROJECT_EVENT_ID);
alter table PROJECT_EVENT
  add constraint PROJECT_EVENT_PROJECT_ID_FK foreign key (PROJECT_ID)
  references PROJECT (PROJECT_ID);

prompt
prompt Creating table REWARD
prompt =====================
prompt
create table REWARD
(
  reward_id   NUMBER not null,
  amount      NUMBER not null,
  description VARCHAR2(500) not null,
  project_id  NUMBER not null
)
;
comment on table REWARD
  is 'Rewards';
comment on column REWARD.reward_id
  is 'ID';
comment on column REWARD.amount
  is 'Amount';
comment on column REWARD.description
  is 'Description';
comment on column REWARD.project_id
  is 'Link on project';
alter table REWARD
  add constraint REWARD_PK primary key (REWARD_ID);
alter table REWARD
  add constraint REWARD_PROJECT_ID_FK foreign key (PROJECT_ID)
  references PROJECT (PROJECT_ID);

prompt
prompt Creating sequence CATEGORY_ID_SEQ
prompt =================================
prompt
create sequence CATEGORY_ID_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence FAQ_ID_SEQ
prompt ============================
prompt
create sequence FAQ_ID_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence PROJECT_EVENT_ID_SEQ
prompt ======================================
prompt
create sequence PROJECT_EVENT_ID_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence PROJECT_ID_SEQ
prompt ================================
prompt
create sequence PROJECT_ID_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence REWARD_ID_SEQ
prompt ===============================
prompt
create sequence REWARD_ID_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating trigger TR_BI_CATEGORY
prompt ===============================
prompt
CREATE OR REPLACE TRIGGER tr_bi_category
    BEFORE INSERT ON category
    FOR EACH ROW
BEGIN
    :new.category_id := category_id_seq.nextval;
END tr_bi_category;
/

prompt
prompt Creating trigger TR_BI_FAQ
prompt ==========================
prompt
CREATE OR REPLACE TRIGGER tr_bi_faq
    BEFORE INSERT ON faq
    FOR EACH ROW
BEGIN
    :new.faq_id := faq_id_seq.nextval;
END tr_bi_faq;
/

prompt
prompt Creating trigger TR_BI_PROJECT
prompt ==============================
prompt
CREATE OR REPLACE TRIGGER tr_bi_project
    BEFORE INSERT ON project
    FOR EACH ROW
BEGIN
    :new.project_id := project_id_seq.nextval;
END tr_bi_project;
/

prompt
prompt Creating trigger TR_BI_PROJECT_EVENT
prompt ====================================
prompt
CREATE OR REPLACE TRIGGER tr_bi_project_event
    BEFORE INSERT ON project_event
    FOR EACH ROW
BEGIN
    :new.project_event_id := project_event_id_seq.nextval;
END tr_bi_project_event;
/

prompt
prompt Creating trigger TR_BI_REWARD
prompt =============================
prompt
CREATE OR REPLACE TRIGGER tr_bi_reward
    BEFORE INSERT ON reward
    FOR EACH ROW
BEGIN
    :new.reward_id := reward_id_seq.nextval;
END tr_bi_reward;
/


spool off
