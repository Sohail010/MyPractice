INSERT INTO `employee`.`personal`
(`EmployeeID`,
`FirstName`,
`LastName`,
`Address`,
`City`,
`State`,
`Zip`)
VALUES
('EN-26',
'Susan',
'Shipe',
'240 Fifth Ave.',
'New York',
'Ny',
10018);
UPDATE `employee`.`personal`
SET
`EmployeeID` = 'EN-10',
`FirstName` = 'Carol',
`LastName` = 'Schaaf',
`Address` = '2306 Palisade Ave.',
`City` = 'Union City	',
`State` = '	NJ',
`Zip` =  07087
WHERE `EmployeeID` = 'EN-10';
;