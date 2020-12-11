create database if not exists examo;

USE examo;

DROP TABLE IF EXISTS Questions;
DROP TABLE IF EXISTS Answers;
DROP TABLE IF EXISTS CorrectAnswers;
DROP TABLE IF EXISTS FullQuestions;
DROP TABLE IF EXISTS Quiz;

CREATE TABLE Questions (
    QuestionId int
    PRIMARY KEY,
    text text
);

CREATE TABLE Answers (
    AnswersId int not null,
    text text,
    QuestionId int not null,
    CONSTRAINT fk_question
    FOREIGN KEY (QuestionId)
    REFERENCES Questions(QuestionId)
);

CREATE TABLE CorrectAnswers (
    AnswersId int not null,
    CONSTRAINT fk_answers
    FOREIGN KEY (AnswersId)
    REFERENCES Answers(AnswersId)
);

CREATE TABLE FullQuestions (
    FullQuestionId int not null,
    QuestionId int not null,
    CONSTRAINT fk_question
    FOREIGN KEY (QuestionId)
    REFERENCES Questions(QuestionId),
    AnswersId int not null,
    CONSTRAINT fk_answer
    FOREIGN KEY (AnswersId)
    REFERENCES Answers(AnswersId)
);

CREATE TABLE Quiz (
    id int not null,
    FullQuestionId int not null,
    CONSTRAINT fk_fullQuestionId
    FOREIGN KEY (FullQuestionId)
    REFERENCES FullQuestions(FullQuestionId)
);