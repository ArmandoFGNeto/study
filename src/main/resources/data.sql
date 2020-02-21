INSERT INTO `jobs` (`id`,`name`, `level`) VALUES
    ('10710b7d-5480-490d-8928-69cbed120325', 'Squire', 1),
    ('788f6242-ae64-41ef-9c6f-54c534c76e73', 'Soldier', 2),
    ('49b6d1fe-306a-4071-af47-9def3f109a05', 'Knight', 3),
    ('371d9009-42a1-4b2f-b0ec-fef29e413b73', 'Paladin', 4);

INSERT INTO `characters` (`id`, `name`) VALUES
    ('6c381a8a-4600-4bce-8863-997b50ee72c3', 'Delitas'),
    ('340f980c-4828-4c50-a2b8-efc6f5e752d8', 'Ramza'),
    ('3cb54d1a-bcce-44f6-ac24-9d101406df22', 'Gafgarion'),
    ('776de98e-1b49-4bf4-a6de-060e9f085277', 'Elcid');

INSERT INTO `characters_jobs` (`character_id`, `job_id`) VALUES
   ('340f980c-4828-4c50-a2b8-efc6f5e752d8', '10710b7d-5480-490d-8928-69cbed120325'),
   ('340f980c-4828-4c50-a2b8-efc6f5e752d8', '788f6242-ae64-41ef-9c6f-54c534c76e73'),
   ('340f980c-4828-4c50-a2b8-efc6f5e752d8', '49b6d1fe-306a-4071-af47-9def3f109a05'),
   ('340f980c-4828-4c50-a2b8-efc6f5e752d8', '371d9009-42a1-4b2f-b0ec-fef29e413b73'),
   ('3cb54d1a-bcce-44f6-ac24-9d101406df22', '49b6d1fe-306a-4071-af47-9def3f109a05'),
   ('776de98e-1b49-4bf4-a6de-060e9f085277', '371d9009-42a1-4b2f-b0ec-fef29e413b73');