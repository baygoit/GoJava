INSERT INTO projects (category_id, name, description, need_sum, current_sum, days_left, project_history, link_on_video, questions_and_answers)
SELECT 1,'Bicycle_test', 'Bicycle description', 1000, 100, 10, 'History', 'Link on video', 'Questions and answers'
UNION 
SELECT 1,'Snowboard_test', 'Snowboard description', 2000, 200, 20, 'History', 'Link on video', 'Questions and answers'
UNION 
SELECT 2,'BMW X3_test', 'BMW X3 description', 3000, 300, 30, 'History', 'Link on video', 'Questions and answers'
UNION 
SELECT 2,'Audi Q5_test', 'Audi Q5 description', 4000, 400, 40, 'History', 'Link on video', 'Questions and answers'
UNION 
SELECT 3,'Laptop_test', 'Laptop description', 5000, 500, 50, 'History', 'Link on video', 'Questions and answers'
UNION 
SELECT 3,'Mobile phone_test', 'Mobile phone description', 6000, 600, 60, 'History', 'Link on video', 'Questions and answers';
