
-- Insert members
INSERT INTO member (id, first_name, last_name, email, role) VALUES
('354c2bd6-d091-4c59-8020-84efb0b510e2', 'Elizabeth', 'Phakane', 'elizabeth.phakane@ioco.tech', 'Frontend Developer'),
('a81322a0-1512-422a-8fcb-592220628bf5', 'Kingsly', 'Mkgwathi', 'kingsly.mokgwathi@ioco.tech', 'Frontend Developer'),
('d886b1fb-645c-43de-8f7c-6bf7fbcb96b5', 'Edgar', 'Makoba', 'edgar.makoba@ioco.tech', 'Frontend Developer'),
('56c13ae1-4c67-4196-9aaa-336a57a46459', 'Siyabonga', 'Bekwa', 'siyabonga.bekwa@ioco.tech', 'Frontend Developer'),
('4f05e87b-1bc7-4fbe-ae31-aca5785c2986', 'Ruth', 'Hlongwane', 'ruth.hlongwane@ioco.tech', 'Frontend Developer'),
('7fd1f20d-4894-4607-a55f-a18ae36dda09', 'Molefe', 'Sealanyane', 'molefe.sealanyane@ioco.tech', 'Frontend Developer');
-- Insert stakeholders
INSERT INTO stakeholder (id, first_name, last_name, email, role, is_internal, organisation) VALUES
('d290f1ee-6c54-4b01-90e6-d701748f0851', 'Gontse', 'Kekana', 'gontse.kekana@ioco.tech', 'Business Unit Manager', TRUE, 'EOH'),
('766b1d1c-31e4-4b4c-9b08-885a995bb9a7', 'Gabi', 'Kuboni', 'gabi.kuboni@ioco.tech', 'Scrum Master', TRUE, 'EOH'),
('4a1e6629-315f-405f-9cac-2eaae4bb960f', 'Jome', 'Akpoduado', 'jome.akpoduado@ioco.tech', 'Head of Technology', FALSE, 'Microsoft South Africa');

-- Insert stakeholder properties
INSERT INTO stakeholder_properties (id, first_name, last_name, email, role, organisation, is_internal, can_review, can_be_reviewed, stakeholder_id) VALUES
('3e3a5c40-12f4-4c54-8f62-50f09f4e4b57', 'Gontse', 'Kekana', 'gontse.kekana@ioco.tech', 'Business Unit Manager', 'EOH', TRUE, TRUE, TRUE, 'd290f1ee-6c54-4b01-90e6-d701748f0851'),
('4b5f8f77-4e63-4b48-9822-5f1cdef1a37e', 'Gabi', 'Kuboni', 'gabi.kuboni@ioco.tech', 'Scrum Master', 'EOH', TRUE, TRUE, TRUE, '766b1d1c-31e4-4b4c-9b08-885a995bb9a7'),
('a7615c7e-8ed7-4c34-9a84-332f52db78a5', 'Jome', 'Akpoduado', 'jome.akpoduado@ioco.tech', 'Head of Technology', 'Microsoft South Africa', FALSE, TRUE, TRUE, '4a1e6629-315f-405f-9cac-2eaae4bb960f');


-- Insert review groups
INSERT INTO review_group (id, name, can_review_each_other, template) VALUES
('2709276d-2579-493d-8c86-af0dd046f610', 'Capricorn Feature Team', TRUE, 'default'),
('54f03bfb-6a75-4ff0-aa60-be7df91b4452', 'Appstronauts', FALSE, 'default');

-- Insert review group members
INSERT INTO review_group_members (review_group_id, member_id) VALUES
('2709276d-2579-493d-8c86-af0dd046f610', '354c2bd6-d091-4c59-8020-84efb0b510e2'),
('2709276d-2579-493d-8c86-af0dd046f610', 'a81322a0-1512-422a-8fcb-592220628bf5'),

('54f03bfb-6a75-4ff0-aa60-be7df91b4452', '7fd1f20d-4894-4607-a55f-a18ae36dda09'),
('54f03bfb-6a75-4ff0-aa60-be7df91b4452', '4f05e87b-1bc7-4fbe-ae31-aca5785c2986'),
('54f03bfb-6a75-4ff0-aa60-be7df91b4452', '56c13ae1-4c67-4196-9aaa-336a57a46459');

-- Insert review group stakeholders
INSERT INTO review_group_stakeholder (review_group_id, stakeholder_id) VALUES
('2709276d-2579-493d-8c86-af0dd046f610', '3e3a5c40-12f4-4c54-8f62-50f09f4e4b57'),
('54f03bfb-6a75-4ff0-aa60-be7df91b4452', '4b5f8f77-4e63-4b48-9822-5f1cdef1a37e');

