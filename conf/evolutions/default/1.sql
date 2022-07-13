# --- !Ups


CREATE TABLE question
(
    contentId     VARCHAR(768) PRIMARY KEY,
    questionId    BIGINT NOT NULL AUTO_INCREMENT UNIQUE KEY,
    language      CHAR(2) NOT NULL,
    createdAt     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    question      VARCHAR(500) NOT NULL,
    answer1       VARCHAR(300) NULL,
    answer2       VARCHAR(300) NULL,
    answer3       VARCHAR(300) NULL,
    answer4       VARCHAR(300) NULL,
    answer5       VARCHAR(300) NULL,
    answer6       VARCHAR(300) NULL,
    answer7       VARCHAR(300) NULL,
    answer8       VARCHAR(300) NULL,
    answer9       VARCHAR(300) NULL
);


CREATE TABLE report
(
    reportId   BIGINT    NOT NULL,
    externalId BIGINT    NOT NULL,
    modified   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (reportId)
);

CREATE TABLE reportquestion
(
    reportQuestionId  BIGINT NOT NULL AUTO_INCREMENT,
    reportId          BIGINT NOT NULL,
    questionId        BIGINT NOT NULL,
    importance        INT    NOT NULL,
    selectedAnswer1   SMALLINT NULL,
    selectedAnswer2   SMALLINT NULL,
    selectedAnswer3   SMALLINT NULL,
    selectedAnswer4   SMALLINT NULL,
    selectedAnswer5   SMALLINT NULL,
    selectedAnswer6   SMALLINT NULL,
    selectedAnswer7   SMALLINT NULL,
    selectedAnswer8   SMALLINT NULL,
    selectedAnswer9   SMALLINT NULL,
    fineWithAnswer1   SMALLINT NULL,
    fineWithAnswer2   SMALLINT NULL,
    fineWithAnswer3   SMALLINT NULL,
    fineWithAnswer4   SMALLINT NULL,
    fineWithAnswer5   SMALLINT NULL,
    fineWithAnswer6   SMALLINT NULL,
    fineWithAnswer7   SMALLINT NULL,
    fineWithAnswer8   SMALLINT NULL,
    fineWithAnswer9   SMALLINT NULL,
    explainText       VARCHAR(5000) NULL,
    PRIMARY KEY (reportQuestionId),
    CONSTRAINT fk_reportquestion_report FOREIGN KEY (reportId) REFERENCES report (reportId),
    CONSTRAINT fk_reportquestion_question FOREIGN KEY (questionId) REFERENCES question (questionId)
);


INSERT INTO question (contentId, questionId, language, createdAt, question, answer1, answer2, answer3, answer4)
VALUES ('How often are you open with your feelings?█Always█Usually█Rarely█Never', 1, 'en', '2013-07-22 12:50:05', 'How often are you open with your feelings?', 'Always', 'Usually', 'Rarely', 'Never');

INSERT INTO report (reportId, externalId, modified)
VALUES (1, 1, '2013-07-22 12:50:05');
INSERT INTO reportquestion (reportQuestionId, reportId, questionId, importance, selectedAnswer3, fineWithAnswer2, fineWithAnswer5, explainText)
VALUES (1, 1, 1, 50, 1, 1, 1, "im usually open with my feelings");


# --- !Downs

DROP TABLE IF EXISTS `reportquestion`;
DROP TABLE IF EXISTS `report`;
DROP TABLE IF EXISTS `question`;
