--Q1
    SELECT Users.nickname, Users.password
    FROM Users WHERE Users.id = ?;

--Q2
    SELECT Categories.id, Categories.name
    FROM Categories
    WHERE Categories.dummy = ?;

--Q3
    SELECT Items.name
    FROM Items
    WHERE Items.id = ?;

 --Q4
    SELECT Users.id, Users.nickname, Bids.id, Items.id, Bids.qty, Bids.bid, Bids.date
    FROM Items.item_bid.Bids.user_bid.Users
    WHERE Items.id = ?
    ORDER BY Bids.date;

--Q5
    SELECT Bids.id, Bids.qty, Bids.bid, Bids.date
    FROM Items.item_bid.Bids
    WHERE Items.id = ?;

--Q6
    SELECT Items.id, Items.name, Items.initial_price, Items.max_bid, Items.nb_of_bids, Items.end_date
    FROM Categories.category.Items
    WHERE Categories.id = ? AND Items.end_date >= ?;

--Q7
    SELECT Users.id, Users.firstname, Users.lastname, Users.nickname, Users.password, Users.email, Users.rating, Users.balance, Users.creation_date
    FROM Users 
    WHERE Users.id = ?;

--Q8
    SELECT Comments.id, Comments.rating, Comments.date, Comments.comment
    FROM Users.to_user.Comments
    WHERE Users.id = ?;

--Q9
    SELECT Users.nickname
    FROM Users
    WHERE Users.id = ?;

--Q10
    SELECT Items.id, Items.name, Items.description, Items.initial_price, Items.quantity, Items.reserve_price, Items.buy_now, Items.nb_of_bids, Items.max_bid, Items.start_date, Items.end_date
    FROM Items
    WHERE Items.id = ?;

--Q11
    SELECT Items.quantity, Items.nb_of_bids, Items.end_date
    FROM Items
    WHERE Items.id = ?;

--Q12
    SELECT Bids.qty, Bids.date
    FROM Items.item_bid.Bids
    WHERE Items.id = ?
    ORDER BY Bids.bid;

--Q13
    SELECT Items.nb_of_bids, Items.max_bid
    FROM Items WHERE Items.id = ?;

--Q14
    SELECT Users.rating
    FROM Users
    WHERE Users.id = ?;

--Q15
    SELECT Users.nickname
    FROM Comments.from_user.Users
    WHERE Comments.id = ?;

--Q16
    SELECT Buynow.id, Buynow.qty, Buynow.date, Items.id, Items.name, Items.description, Items.initial_price, Items.quantity, Items.reserve_price, Items.buy_now, Items.nb_of_bids, Items.max_bid, Items.start_date, Items.end_date
    FROM Users.buyer.Buynow.item_buy_now.Items
    WHERE Users.id = ? AND Buynow.date >= ?;

--Q17
    SELECT Items.id, Items.name, Items.description, Items.initial_price, Items.quantity, Items.reserve_price, Items.buy_now, Items.nb_of_bids, Items.max_bid, Items.start_date, Items.end_date
    FROM Users.seller.Items
    WHERE Users.id=? AND Items.end_date >= ?;

--Q18
    SELECT Bids.id, Items.id, Items.name, Items.description, Items.initial_price, Items.quantity, Items.reserve_price, Items.buy_now, Items.nb_of_bids, Items.max_bid, Items.start_date, Items.end_date
    FROM Users.user_bid.Bids.item_bid.Items
    WHERE Users.id=? AND Items.end_date >= ?;

--Q19
SELECT Users.id, Items.id, Items.name, Items.initial_price, Items.max_bid, Items.nb_of_bids, Items.end_date
    FROM Categories.category.Items.seller.Users.user_region.Regions
    WHERE Regions.id = ? AND Categories.id = ? AND Items.end_date >= ?;

--Q20
SELECT Regions.id, Regions.name
    FROM Regions
    WHERE Regions.dummy = ?;

-- Insert Item: insert item and its relationship with category and seller (user).

-- register User: insert user and its relationship with region.

-- store buy now : insert buynow and its relationship with item and buyer(user).

-- store bid : 
	1. insert bid and its relationship with item and user; 
	2. update values of 'nb_of bids' and 'max_bid' in the corresponding item.

-- store comment: create comment and its relationship with to_user (user), from_user (user) and item.
	

