CREATE OR REPLACE TRIGGER trigger_projects
  BEFORE INSERT ON projects
  FOR EACH ROW
BEGIN
  :new.id 
  := seq_id.nextval;
END;
/