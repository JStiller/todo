CREATE TABLE IF NOT EXISTS todos (
id          VARCHAR(36)  PRIMARY KEY,
title       VARCHAR(255) NOT NULL,
category    VARCHAR(255) NOT NULL,
description TEXT         NOT NULL,
status      TINYINT      NOT NULL
);