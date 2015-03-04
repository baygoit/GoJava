SELECT * FROM
	projects
	LEFT JOIN
	categories
	ON projects.category_id = categories.id AND categories.id = 2;