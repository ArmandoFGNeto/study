CREATE TABLE IF NOT EXISTS `jobs` (
    `id` UUID DEFAULT random_uuid() NOT NULL PRIMARY KEY,
    `name` VARCHAR(255),
    `level` INT );

CREATE TABLE IF NOT EXISTS `characters` (
    `id` UUID DEFAULT random_uuid() NOT NULL PRIMARY KEY,
    `name` VARCHAR(255) );

CREATE TABLE IF NOT EXISTS `characters_jobs` (
    `character_id` UUID NOT NULL,
    `job_id` UUID NOT NULL,
    FOREIGN KEY (`character_id`) REFERENCES characters(`id`),
    FOREIGN KEY (`job_id`) REFERENCES jobs(`id`),
    PRIMARY KEY(`character_id`,`job_id`) );