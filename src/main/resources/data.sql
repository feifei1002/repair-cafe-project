INSERT INTO product (productID, name, description, category, location, status, availability)
VALUES ('001', 'Desk', 'White 120 x 70 x 50 desk', 'furniture', 'Stow Hill', '0', '0');

INSERT INTO product (productID, name, description, category, location, status, availability)
VALUES ('002', 'Chair', 'Black 60 x 45 x 38 chair', 'furniture', 'Cathays', '0', '0');

INSERT INTO product (productID, name, description, category, location, status, availability)
VALUES ('003', 'Shoes', 'Black Air Force 1 Size 10', 'clothing', 'Canton', '0', '0');

INSERT INTO product (productID, name, description, category, location, status, availability)
VALUES ('004', 'Lawnmower', 'Green 400cc', 'Gardening', 'Newport', '0', '0');

INSERT INTO product (productID, name, description, category, location, status, availability)
VALUES ('005', 'Frisbee', 'Yellow 30cm Circumfrence', 'Toys', 'Caerphilly', '0', '0');

INSERT INTO product (productID, name, description, category, location, status, availability)
VALUES ('006', 'Book', 'The Nicomachean Ethics by Aristotle', 'Books', 'Castle', '0', '0');

INSERT INTO product (productID, name, description, category, location, status, availability)
VALUES ('007', 'Cupboard', 'Wood 2.5m x 70cm x 40cm', 'furniture', 'Cathays', '0', '0');

INSERT INTO product (productID, name, description, category, location, status, availability)
VALUES ('008', 'Laptop', 'Dell i7', 'Electronics', 'Cardiff University', '0', '0');

INSERT INTO product (productID, name, description, category, location, status, availability)
VALUES ('009', 'Pen', '4 colour ballpoint', 'stationary', 'Stow Hill', '0', '0');

INSERT INTO product (productID, name, description, category, location, status, availability)
VALUES ('010', 'Paper', 'White A4', 'stationary', 'Cardiff University', '0', '0');

INSERT INTO RepairCafe(name, address, city, postcode)
VALUES ('Abergavenny', 'Abergavenny Community Centre, The Old School, Park Street', 'Abergavenny', 'NP7 5YB');

INSERT INTO RepairCafe(name, address, city, postcode)
VALUES ('Bangor', 'SBangor Students Union, Room 3, Activities Hub, Ffriddoedd Site, Ffriddoedd Road', 'Bangor', 'LL57 2JW');

INSERT INTO RepairCafe(name, address, city, postcode)
VALUES ('Barford', 'Scout Hut, Wasperton Lane, Barford', 'Warwick', 'CV35 8DT');

INSERT INTO RepairCafe(name, address, city, postcode)
VALUES ('Beaumaris', 'Canolfan Hamdden Beaumaris, Rating Row, Beaumaris', 'Ynys Mon', 'LL58 8AL');

INSERT INTO RepairCafe(name, address, city, postcode)
VALUES ('Boat of Garten', 'Boat of Garten Community Hall, Reidhaven Park, Craigie Avenue Boat of Garten', 'Highland', 'PH24 3BL');

INSERT INTO RepairCafe(name, address, city, postcode)
VALUES ('Bridgend', 'Bryncethin Community Centre, Ogmore Terrace, Bryncethin', 'Bridgend', 'CF32 9YF');

INSERT INTO RepairCafe(name, address, city, postcode)
VALUES ('Bridgend College Pop Up Shop', '22 The Rhiw', 'Bridgend', 'CF31 3BL');

INSERT INTO RepairCafe(name, address, city, postcode)
VALUES ('Caerau', 'Caerau Menshed, Bangor Terrace, Nantyffyllon', 'Bridgend', 'CF34 0HU');

INSERT INTO RepairCafe(name, address, city, postcode)
VALUES ('Caerphilly', 'Caerphilly Miners Centre For The Community, Watford Road', 'Caerphilly', 'CF83 1ET');

INSERT INTO RepairCafe(name, address, city, postcode)
VALUES ('Caerphilly (The Furniture Revival)', 'The Furniture Revival, Unit 21 Lawn Industrial Estate, Rhymey, Tredegar', 'Gwent', 'NP22 5PW');




INSERT INTO RepairBooking(firstName, lastName, email, repairDate, category, location)
VALUES ('Fei', 'Liu', 'LiuF29@cardiff.ac.uk', '2021-11-25', 'Scooter','Bridgend');

INSERT INTO RepairBooking(firstName, lastName, email, repairDate, category, location)
VALUES ('Louis', 'Polly', 'PollyL@cardiff.ac.uk', '2021-12-02', 'Misc','Bangor');

INSERT INTO RepairBooking(firstName, lastName, email, repairDate, category, location)
VALUES ('Nikita', 'Vashchenko', 'VashchenkoN@cardiff.ac.uk', '2012-12-25', 'Heater','Barford');



INSERT INTO RepairCategory(name)
VALUES ('Apparel/Textiles');

INSERT INTO RepairCategory(name)
VALUES ('Bag/Luggage/Purse');

INSERT INTO RepairCategory(name)
VALUES ('Bicycle');

INSERT INTO RepairCategory(name)
VALUES ('Bicycle Accessory');

INSERT INTO RepairCategory(name)
VALUES ('Car Accessory');

INSERT INTO RepairCategory(name)
VALUES ('Electrical Item');

INSERT INTO RepairCategory(name)
VALUES ('Furniture');

INSERT INTO RepairCategory(name)
VALUES ('Heater');

INSERT INTO RepairCategory(name)
VALUES ('Home Decor');

INSERT INTO RepairCategory(name)
VALUES ('Jewellery/Accessory');

INSERT INTO RepairCategory(name)
VALUES ('Mannual Tool');

INSERT INTO RepairCategory(name)
VALUES ('Misc');

INSERT INTO RepairCategory(name)
VALUES ('Scooter');


INSERT INTO RepairProduct(product_name, `condition`, brand, status)
VALUES ('Halogen Heater 3 Bars', 'A - As new', 'Brother', 'available');

INSERT INTO RepairProduct(product_name, `condition`, brand, status)
VALUES ('Sewing Machine', 'A - As new', 'Brother', 'available');

INSERT INTO RepairProduct(product_name, `condition`, brand, status)
VALUES ('Electric Multicooker', 'B - Fair', 'Team Uk international', 'available');

INSERT INTO RepairProduct(product_name, `condition`, brand, status)
VALUES ('DVD Player', 'B - Fair', 'Samsung', 'available');

INSERT INTO RepairProduct(product_name, `condition`, brand, status)
VALUES ('Vacuum Cleaner', 'A - As new', 'Numatic', 'available');

INSERT INTO RepairProduct(product_name, `condition`, brand, status)
VALUES ('Single Camping Mat', 'A - As new', ' Unknown', 'available');

INSERT INTO repair_Borrow(`firstName`, `lastName`, `email`, `productName`, `product_id`)
VALUES ('Fei', 'Liu', 'LiuF29@cardiff.ac.uk', 'Sewing Machine', 2);

INSERT INTO repair_Borrow(`firstName`, `lastName`, `email`, `productName`, `product_id`)
VALUES ('Louis', 'Polly', 'PollyL@cardiff.ac.uk', 'DVD Player', 4);

INSERT INTO repair_Borrow(`firstName`, `lastName`, `email`, `productName`, `product_id`)
VALUES ('Nikita', 'Vashchenko', 'VashchenkoN@cardiff.ac.uk', 'Single Camping Mat', 6);

INSERT INTO user(firstName, lastName, email, phoneNo, password, address, city, postcode, role,enabled)
VALUES ('Fei', 'Liu', 'admin@gmail.com', 0123456789, '$2a$10$/FhlPyse/nXmz8BSCRh4OuBnSic7FqDdklZch8X0/1.9yXCJqqXc.','Tyndall Street', 'Cardiff', 'CF10 4BZ', 'ROLE_ADMIN', 1);
INSERT INTO user(firstName, lastName, email, phoneNo, password, address, city, postcode, role,enabled)
VALUES ('Fei', 'Liu', 'user@gmail.com', 0123456789, '$2a$10$NyH9Ua9VLyHtgmrS6YzPo.vumgm5fQzanVx7FsfyyzOM41BVgSdWi','Tyndall Street', 'Cardiff', 'CF10 4BZ', 'ROLE_USER', 1);


