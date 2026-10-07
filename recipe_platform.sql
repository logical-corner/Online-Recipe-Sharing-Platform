CREATE DATABASE IF NOT EXISTS recipe_platform;

USE recipe_platform;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100),
    role VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE recipes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    name VARCHAR(100),
    category VARCHAR(50),
    description TEXT,
    ingredients TEXT,
    instructions TEXT,
    cooking_time VARCHAR(20),
    difficulty VARCHAR(20),
    image VARCHAR(255),
    status VARCHAR(20) DEFAULT 'PENDING',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE ratings (
    id INT PRIMARY KEY AUTO_INCREMENT,
    recipe_id INT,
    user_id INT,
    rating INT,
    review TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (recipe_id) REFERENCES recipes(id),
    FOREIGN KEY (user_id) REFERENCES users(id),

    UNIQUE(recipe_id, user_id)
);

CREATE TABLE collections (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    recipe_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (recipe_id) REFERENCES recipes(id),

    UNIQUE(user_id, recipe_id)
);

CREATE TABLE browsing_history (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    recipe_id INT,
    viewed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (recipe_id) REFERENCES recipes(id)
);

CREATE TABLE messages (
    id INT PRIMARY KEY AUTO_INCREMENT,
    sender_id INT,
    receiver_id INT,
    message TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (sender_id) REFERENCES users(id),
    FOREIGN KEY (receiver_id) REFERENCES users(id)
);

CREATE TABLE settings (
    id INT PRIMARY KEY AUTO_INCREMENT,
    setting_name VARCHAR(100),
    setting_value VARCHAR(255)
);

INSERT INTO users
(name, email, password, role)
VALUES
('Admin', 'admin@gmail.com', 'admin123', 'ADMIN');

INSERT INTO settings
(setting_name, setting_value)
VALUES
('website_name', 'RecipeShare'),
('allow_reviews', 'true'),
('allow_ratings', 'true');