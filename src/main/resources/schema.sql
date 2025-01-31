CREATE TABLE WasteCategories (
    wasteCategoryId INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(255) NOT NULL
);

CREATE TABLE DisposalGuidelines (
    disposalGuidelineId INT PRIMARY KEY AUTO_INCREMENT,
    wasteCategoryId INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255) NOT NULL,
    FOREIGN KEY (wasteCategoryId) REFERENCES WasteCategories(wasteCategoryId)
);

CREATE TABLE RecyclingTips (
    recyclingTipId INT PRIMARY KEY AUTO_INCREMENT,
    wasteCategoryId INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255) NOT NULL,
    FOREIGN KEY (wasteCategoryId) REFERENCES WasteCategories(wasteCategoryId)
);
