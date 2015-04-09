CREATE TABLE projects (
        id BIGSERIAL PRIMARY KEY NOT NULL,
        category_id BIGSERIAL REFERENCES categories(id),
        name TEXT NOT NULL,
        description TEXT,
        money_need INTEGER,
        money_has INTEGER,
        days_left INTEGER,
        history TEXT,
        video_link TEXT,
        question TEXT);