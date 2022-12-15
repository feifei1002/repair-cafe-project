INSERT INTO `product` (productID, name, description, category, location, status, availability)
values ('001', 'Desk', 'White 120 x 70 x 50 desk', 'furniture', 'Stow Hill', '0', '0');

INSERT INTO `product` (productID, name, description, category, location, status, availability)
values ('002', 'Chair', 'Black 60 x 45 x 38 chair', 'furniture', 'Cathays', '0', '0');

INSERT INTO `product` (productID, name, description, category, location, status, availability)
values ('003', 'Shoes', 'Black Air Force 1 Size 10', 'clothing', 'Canton', '0', '0');

INSERT INTO `product` (productID, name, description, category, location, status, availability)
values ('004', 'Lawnmower', 'Green 400cc', 'Gardening', 'Newport', '0', '0');

INSERT INTO `product` (productID, name, description, category, location, status, availability)
values ('005', 'Frisbee', 'Yellow 30cm Circumfrence', 'Toys', 'Caerphilly', '0', '0');

INSERT INTO `product` (productID, name, description, category, location, status, availability)
values ('006', 'Book', 'The Nicomachean Ethics by Aristotle', 'Books', 'Castle', '0', '0');

INSERT INTO `product` (productID, name, description, category, location, status, availability)
values ('007', 'Cupboard', 'Wood 2.5m x 70cm x 40cm', 'furniture', 'Cathays', '0', '0');

INSERT INTO `product` (productID, name, description, category, location, status, availability)
values ('008', 'Laptop', 'Dell i7', 'Electronics', 'Cardiff University', '0', '0');

INSERT INTO `product` (productID, name, description, category, location, status, availability)
values ('009', 'Pen', '4 colour ballpoint', 'stationary', 'Stow Hill', '0', '0');

INSERT INTO `product` (productID, name, description, category, location, status, availability)
values ('010', 'Paper', 'White A4', 'stationary', 'Cardiff University', '0', '0');

INSERT INTO repair_Cafe(name, address, city, postcode)
VALUES ('Abergavenny', 'Abergavenny Community Centre, The Old School, Park Street', 'Abergavenny', 'NP7 5YB');

INSERT INTO repair_Cafe(name, address, city, postcode)
VALUES ('Bangor', 'SBangor Students Union, Room 3, Activities Hub, Ffriddoedd Site, Ffriddoedd Road', 'Bangor', 'LL57 2JW');

INSERT INTO repair_Cafe(name, address, city, postcode)
VALUES ('Barford', 'Scout Hut, Wasperton Lane, Barford', 'Warwick', 'CV35 8DT');

INSERT INTO repair_Cafe(name, address, city, postcode)
VALUES ('Beaumaris', 'Canolfan Hamdden Beaumaris, Rating Row, Beaumaris', 'Ynys Mon', 'LL58 8AL');

INSERT INTO repair_Cafe(name, address, city, postcode)
VALUES ('Boat of Garten', 'Boat of Garten Community Hall, Reidhaven Park, Craigie Avenue Boat of Garten', 'Highland', 'PH24 3BL');

INSERT INTO repair_Cafe(name, address, city, postcode)
VALUES ('Bridgend', 'Bryncethin Community Centre, Ogmore Terrace, Bryncethin', 'Bridgend', 'CF32 9YF');

INSERT INTO repair_Cafe(name, address, city, postcode)
VALUES ('Bridgend College Pop Up Shop', '22 The Rhiw', 'Bridgend', 'CF31 3BL');

INSERT INTO repair_Cafe(name, address, city, postcode)
VALUES ('Caerau', 'Caerau Menshed, Bangor Terrace, Nantyffyllon', 'Bridgend', 'CF34 0HU');

INSERT INTO repair_Cafe(name, address, city, postcode)
VALUES ('Caerphilly', 'Caerphilly Miners Centre For The Community, Watford Road', 'Caerphilly', 'CF83 1ET');

INSERT INTO repair_Cafe(name, address, city, postcode)
VALUES ('Caerphilly (The Furniture Revival)', 'The Furniture Revival, Unit 21 Lawn Industrial Estate, Rhymey, Tredegar', 'Gwent', 'NP22 5PW');




INSERT INTO repair_Booking(firstName, lastName, email, repairDate, category, location)
VALUES ('Fei', 'Liu', 'LiuF29@cardiff.ac.uk', '2021-11-25', 'Scooter','Bridgend');

INSERT INTO repair_Booking(firstName, lastName, email, repairDate, category, location)
VALUES ('Louis', 'Polly', 'PollyL@cardiff.ac.uk', '2021-12-02', 'Misc','Bangor');

INSERT INTO repair_Booking(firstName, lastName, email, repairDate, category, location)
VALUES ('Nikita', 'Vashchenko', 'VashchenkoN@cardiff.ac.uk', '2012-12-25', 'Heater','Barford');



INSERT INTO repair_Category(name)
VALUES ('Apparel/Textiles');

INSERT INTO repair_Category(name)
VALUES ('Bag/Luggage/Purse');

INSERT INTO repair_Category(name)
VALUES ('Bicycle');

INSERT INTO repair_Category(name)
VALUES ('Bicycle Accessory');

INSERT INTO repair_Category(name)
VALUES ('Car Accessory');

INSERT INTO repair_Category(name)
VALUES ('Electrical Item');

INSERT INTO repair_Category(name)
VALUES ('Furniture');

INSERT INTO repair_Category(name)
VALUES ('Heater');

INSERT INTO repair_Category(name)
VALUES ('Home Decor');

INSERT INTO repair_Category(name)
VALUES ('Jewellery/Accessory');

INSERT INTO repair_Category(name)
VALUES ('Mannual Tool');

INSERT INTO repair_Category(name)
VALUES ('Misc');

INSERT INTO repair_Category(name)
VALUES ('Scooter');


INSERT INTO repair_Product(`product_name`, `condition`, `brand`, `status`, `repair_Category_category_id`)
VALUES ('Halogen Heater 3 Bars', 'A - As new', 'Brother', 'available', 8);

INSERT INTO repair_Product(`product_name`, `condition`, `brand`, `status`, `repair_Category_category_id`)
VALUES ('Sewing Machine', 'A - As new', 'Brother', 'available', 6);

INSERT INTO repair_Product(`product_name`, `condition`, `brand`, `status`, `repair_Category_category_id`)
VALUES ('Electric Multicooker', 'B - Fair', 'Team Uk international', 'available', 6);

INSERT INTO repair_Product(`product_name`, `condition`, `brand`, `status`, `repair_Category_category_id`)
VALUES ('DVD Player', 'B - Fair', 'Samsung', 'available', 12);

INSERT INTO repair_Product(`product_name`, `condition`, `brand`, `status`, `repair_Category_category_id`)
VALUES ('Vacuum Cleaner', 'A - As new', 'Numatic', 'available', 6);

INSERT INTO repair_Product(`product_name`, `condition`, `brand`, `status`, `repair_Category_category_id`)
VALUES ('Single Camping Mat', 'A - As new', ' Unknown', 'on loan', 2);




