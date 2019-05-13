DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(250) NOT NULL,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  birth_date DATE NOT NULL
);

INSERT INTO users (email, first_name, last_name, birth_date) VALUES
  ('tony.stark@townsq.io', 'Tony', 'Stark', PARSEDATETIME('1970-05-29', 'yyyy-MM-dd')),
  ('steve.rogers@townsq.io', 'Steve', 'Rogers', PARSEDATETIME('1918-07-04', 'yyyy-MM-dd')),
  ('bruce.banner@townsq.io', 'Bruce', 'Banner', PARSEDATETIME('1969-12-18', 'yyyy-MM-dd')),
  ('thor.odinson@townsq.io', 'Thor', 'Odinson', PARSEDATETIME('1000-01-01', 'yyyy-MM-dd')),
  ('clinton.barton@townsq.io', 'Clinton', 'Barton', PARSEDATETIME('1971-01-07', 'yyyy-MM-dd')),
  ('natasha.romanoff@townsq.io', 'Natasha', 'Romanoff', PARSEDATETIME('1984-11-22', 'yyyy-MM-dd'));