-- CATEGORIES
insert into app.categories (name) values ('Arts');
insert into app.categories (name) values ('Comics');
insert into app.categories (name) values ('Crafts');
insert into app.categories (name) values ('Games');

-- QUOTES
insert into quotes (text, author) values ('Start by doing what''s necessary; then do what''s possible; and suddenly you are doing the impossible.', 'Francis of Assisi');
insert into quotes (text, author) values ('The best and most beautiful things in the world cannot be seen or even touched - they must be felt with the heart.', 'Helen Keller');
insert into quotes (text, author) values ('I can''t change the direction of the wind, but I can adjust my sails to always reach my destination.', 'Jimmy Dean');
insert into quotes (text, author) values ('Test Quote', '');

-- PROJECTS
insert into projects (name, description, amount_goal, amount_pledged, deadline, category_id, link_to_video) values ('name1', 'desc1', 1000, 0, '31.08.2015', 2, 'http://www.youtube.com/jrgri74ht3h97');
insert into projects (name, description, amount_goal, amount_pledged, deadline, category_id) values ('name2', 'desc2', 10000, 100, '15.10.2015', 4);
insert into projects (name, description, amount_goal, amount_pledged, deadline, category_id) values ('name3', 'desc3', 100, 90, '15.09.2015', 3);
insert into projects (name, description, amount_goal, amount_pledged, deadline, category_id) values ('name4', 'desc4', 100000, 50000, '31.12.2015', 4);
insert into projects (name, category_id) values ('Empty project', 4);

-- FAQs
insert into faqs (question, answer, project_id) values ('How can you imagine such idea?', 'Because of whisky, babe!', 1);  
insert into faqs (question, project_id) values ('DB are working?', 2);

-- EVENTS
insert into events (description, event_date, project_id) values ('We are going to start!', '01.01.2015', 1);
insert into events (description, event_date, project_id) values ('We have almost finished!', '31.05.2015', 1);
insert into events (description, event_date, project_id) values ('Blah-blah-blah-blah...', '01.06.2015', 2);

-- REWARDS
insert into reward_options (amount, description, project_id) values (10, 'Cool T-shirt', 1);
insert into reward_options (amount, description, project_id) values (50, 'free beta testing', 1);
insert into reward_options (amount, description, project_id) values (100, 'lifelong title of founder', 1);