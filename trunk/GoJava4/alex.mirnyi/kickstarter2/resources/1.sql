BEGIN TRANSACTION;

CREATE TABLE "Projects" (

	`project_id`	INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,

	`category_id`	INTEGER NOT NULL,
	`project_name`	TEXT NOT NULL,

	`project_short_description`	TEXT NOT NULL,

	`project_total_sum`	INTEGER NOT NULL,

	`project_pledged`	INTEGER NOT NULL,

	`project_days_left`	INTEGER NOT NULL,

	`project_history`	TEXT,

	`project_videoLink`	TEXT,

	`project_questions`	TEXT
);


INSERT INTO `Projects` VALUES (
1,1,'Alco Tester','Phenomenal alco test just by scanning your eyes',
50000,23000,15,NULL,NULL,NULL);


INSERT INTO `Projects` VALUES (2,1,'Eyes training device','Get 100% sight',
100000,15000,24,NULL,NULL,NULL);


INSERT INTO `Projects` VALUES (3,2,'Sing Melody',
'Sing melody and hear how it sounds in different musical instruments',
15,22,110,NULL,NULL,NULL);


CREATE TABLE "Categories" (

	`caregory_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,

	`category_name`	INTEGER NOT NULL UNIQUE
);


INSERT INTO `Categories` VALUES (1,'medicine');

INSERT INTO `Categories` VALUES (2,'music');


COMMIT;
