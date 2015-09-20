INSERT INTO PUBLIC.QUOTES (ID, PRESENTATION)
VALUES (1, '  If you want to achieve greatness stop asking for permission.    -Anonymous');
INSERT INTO PUBLIC.QUOTES (ID, PRESENTATION)
VALUES (2, '  Things work out best for those who make the best of how things work out.    -John Wooden');
INSERT INTO PUBLIC.QUOTES (ID, PRESENTATION)
VALUES (3, '  If you are not willing to risk the usual you will have to settle for the ordinary.    -Jim Rohn');
INSERT INTO PUBLIC.CATEGORIES (ID, NAME) VALUES (1, 'Games');
INSERT INTO PUBLIC.CATEGORIES (ID, NAME) VALUES (2, 'Music');
INSERT INTO PUBLIC.CATEGORIES (ID, NAME) VALUES (3, 'Films');
INSERT INTO PUBLIC.PROJECTS (ID, NAME, DESCRIPTION, CATEGORY_ID, COST, BALANCE, DEAD_LINE, VIDEO_LINK, HISTORY)
VALUES
  (2, 'StarCraft 2', 'continue of epic game', 1, 5000000, 0, '01/01/2017', 'https://www.youtube.com/embed/MVbeoSPqRs4',
   NULL);
INSERT INTO PUBLIC.PROJECTS (ID, NAME, DESCRIPTION, CATEGORY_ID, COST, BALANCE, DEAD_LINE, VIDEO_LINK, HISTORY)
VALUES
  (3, 'Kosinka 2', '2-nd part of epic game', 1, 3000000, 0, '01/01/2016', 'https://www.youtube.com/embed/CckOHAGPB0Q',
   'We have collected 100000$ now. We need to collect more to start development.');
INSERT INTO PUBLIC.PROJECTS (ID, NAME, DESCRIPTION, CATEGORY_ID, COST, BALANCE, DEAD_LINE, VIDEO_LINK, HISTORY)
VALUES
  (1, 'GTA 5', '5-th episode of epic game', 1, 100000, 0, '01/01/2016', 'https://www.youtube.com/embed/SC66xH7s-0M',
   'we just starter and its nothing to say now! To be continue.');
INSERT INTO PUBLIC.QUESTIONS_AND_ANSWERS (ID, QUESTION, ANSWER, PROJECT_ID)
VALUES (1, 'When will you release PC version?', 'Next year.', 1);
INSERT INTO PUBLIC.QUESTIONS_AND_ANSWERS (ID, QUESTION, ANSWER, PROJECT_ID)
VALUES (2, 'Q: Will you develop version for Mac and Linux? ', 'A: No. Only Windows', 3);