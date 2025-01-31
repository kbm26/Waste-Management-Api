CREATE TABLE waste_categories (
    waste_category_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(255) NOT NULL
);

CREATE TABLE disposal_guidelines (
    disposal_guideline_id INT PRIMARY KEY AUTO_INCREMENT,
    waste_category_id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255) NOT NULL,
    FOREIGN KEY (waste_category_id) REFERENCES waste_categories(waste_category_id)
);

CREATE TABLE recycling_tips (
    recycling_tip_id INT PRIMARY KEY AUTO_INCREMENT,
    waste_category_id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255) NOT NULL,
    FOREIGN KEY (waste_category_id) REFERENCES waste_categories(waste_category_id)
);
