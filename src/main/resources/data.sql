INSERT INTO venues VALUES (default, 'endy', 'kompong chhnang'),
                          (default, 'kaya', 'kompong chhnang'),
                          (default, 'mai', 'kompong cham'),
                          (default, 'rith', 'kompong thom');

INSERT INTO attendees VALUES (default, 'sok sao', 'sao@gmail.com'),
                             (default, 'sok s', 'saohii@gmail.com'),
                             (default, 'sok sa2', 'saosi@gmail.com'),
                             (default, 'sok 2ao', 'sasdfc@gmail.com');

INSERT INTO events VALUES (default, 'ISTAD', '12-12-2026', 5);

INSERT INTO event_attendee VALUES(1,2),
                                 (8, 2);

select * from event_attendee;

SELECT * FROM attendees WHERE attendee_id = 5;