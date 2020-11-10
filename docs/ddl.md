## Data model data definition language (DDL)

```sqlite
CREATE TABLE IF NOT EXISTS `Todo`
(
    `todo_id`       INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `task`          INTEGER                           NOT NULL,
    `task_name`     TEXT,
    `user_id`       INTEGER                           NOT NULL,
    `created`       INTEGER                           NOT NULL,
    `calendar_date` INTEGER                           NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `user_profile` (`user_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS `index_Todo_task_task_name_user_id_created_calendar_date` ON `Todo` (`task`,
                                                                                                `task_name`,
                                                                                                `user_id`,
                                                                                                `created`,
                                                                                                `calendar_date`);

CREATE INDEX IF NOT EXISTS `index_Todo_user_id` ON `Todo` (`user_id`);

CREATE TABLE IF NOT EXISTS `user_profile`
(
    `user_id`   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `oauth_key` TEXT                              NOT NULL
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_user_profile_oauth_key` ON `user_profile` (`oauth_key`);

CREATE TABLE IF NOT EXISTS `Motivator`
(
    `motivator_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `activity`     TEXT                              NOT NULL,
    `user_id`      INTEGER                           NOT NULL,
    `motivator`    TEXT                              NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `user_profile` (`user_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_Motivator_activity` ON `Motivator` (`activity`);

CREATE INDEX IF NOT EXISTS `index_Motivator_user_id_motivator` ON `Motivator` (`user_id`, `motivator`);

```

[`ddl.sql`](sql/ddl.sql)
