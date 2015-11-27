use kickstarter;

INSERT INTO quote (text, author) 
values ('sql quote 1.', 'Vova Vova'),
 ('sql quote 2 kjgkdfjgkdfjgkdfgf.', 'Vova Vova');
 
INSERT INTO category (id, name) VALUES 
	('1', 'Art'), 
	('2', 'Design'), 
	('3', 'Sport');

INSERT INTO `project` (`id`, `categoryId`, `name`, `description`, `goal`, `daysToGo`, `owner`, `videoUrl`) VALUES 
('1', '1', 'Super project sql', 'descr', '1000', '14', 'owner', 'link'),
('2', '1', 'Second project sql', 'descr2', '1000', '40', 'own', 'link2'),
('3', '2', 'X project sql', 'descr23', '1000', '40', 'owner3', 'link3');

INSERT INTO `reward` (`id`, `projectId`, `pledge`, `benefit`) VALUES 
('1', '1', '1', 'a little one sql'),
('2', '1', '10', 'a middle one sql'),
('3', '1', '40', 'a a big one sql'),
('4', '2', '30', 'something sql');

INSERT INTO `question` (`id`, `projectId`, `questionText`) VALUES 
('1', '1', 'Very smart sql question'),
('2', '2', 'How much is the fish?');

INSERT INTO `payment` (`id`, `projectId`, `name`, `cardNumber`, `pledge`) VALUES 
('1', '1', 'Vova Vova', '2342 3434 2342 3424', '100'),
('2', '2', 'Vova Vova', '2342 3434 2342 3424', '50');
