DROP TABLE Photoz;

CREATE TABLE Photoz (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  file_name VARCHAR(255),
  content_type VARCHAR(255),
  data BLOB,
  test varchar(50)
);