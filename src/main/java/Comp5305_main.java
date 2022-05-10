import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

import java.util.Scanner;

public class Comp5305_main {
    public static void main( String[] args )
	    {
		   String serverIP = "127.0.0.1";
		   String keyspace = "rubis";
		   
	       Cluster cluster = Cluster.builder()
	                          .addContactPoints(serverIP)
	                          .build();
	       Session session = cluster.connect(keyspace);
	       String cqlStatement;
	       
	     do {
	       Scanner input = new Scanner(System.in);
	       System.out.print("\nEnter your choice of queries (from 1 to 25), or 0 to exit: ");
	       if (!input.hasNextInt()) {
	    	   System.out.print("Invalid input; please enter an integer from 1 to 25: ");
	       }
	       int choice = input.nextInt();
	       
	       switch (choice) {
	         case 0:
	             System.out.println("\nThank you for running my project. --by Yuxi W.");
	             input.close();
	  	         System.exit(0);
	             break;
	         case 1:
		           System.out.println("Enter the user id: ");
		           int user_id_var = input.nextInt();
		           cqlStatement = "select nickname, password from users where id = "+user_id_var+";";
		           print_exec_results(session.execute(cqlStatement));
		           break;
	         case 2:
		           System.out.println("Enter the category dummy: ");
		           int category_dummy_var = input.nextInt();
		           cqlStatement = "select id, name from categories_by_dummy where dummy = "+category_dummy_var+";";
		           print_exec_results(session.execute(cqlStatement));
		           break;
	         case 3:
		           System.out.println("Enter the item id: ");
			       int item_id_var = input.nextInt();
				   cqlStatement = "select name from items where id = "+item_id_var+";";
				   print_exec_results(session.execute(cqlStatement));
			       break;
	         case 4:
		           System.out.println("Enter the item id: ");
			       item_id_var = input.nextInt();
				   cqlStatement = "select user, user_nickname, bid_id, item_id, qty, bid, "+
			         "date from bids_users where item_id = "+item_id_var+" order by date;";
				   print_exec_results(session.execute(cqlStatement));
			       break;
	         case 5:
		           System.out.println("Enter the item id: ");
			       item_id_var = input.nextInt();
				   cqlStatement = "select bid_id, qty, bid, date from bids_users where item_id = "+
			         item_id_var+";";
				   print_exec_results(session.execute(cqlStatement));
			       break;
	         case 6:
		           System.out.println("Enter category id: ");
		           int category_id_var = input.nextInt();
		           input.nextLine();
			       System.out.println("Enter items end_date: ");
			       String item_end_date = input.nextLine();
				   cqlStatement = "select id, name, initial_price, max_bid, nb_of_bids, end_date from rubis.items_by_category"
				   		+" where category = "+category_id_var+" AND end_date >="+item_end_date+";";
				   print_exec_results(session.execute(cqlStatement));
			       break;
	         case 7:
		           System.out.println("Enter user id: ");
		           user_id_var = input.nextInt();
				   cqlStatement = "select id, firstname, lastname, nickname, password, email, rating, balance, creation_date"+
				   		" from users where id = "+user_id_var+";";
				   print_exec_results(session.execute(cqlStatement));
			       break;
	         case 8:
		           System.out.println("Enter user id: ");
		           user_id_var = input.nextInt();
				   cqlStatement = "select comment_id, rating, date, comment "+
		             " from rubis.comments_by_users where from_user = "+user_id_var+";";
				   print_exec_results(session.execute(cqlStatement));
			       break;
	         case 9:
		           System.out.println("Enter user id: ");
		           user_id_var = input.nextInt();
				   cqlStatement = "select nickname from users where id = "+user_id_var+";";
				   print_exec_results(session.execute(cqlStatement));
			       break;
	         case 10:
		           System.out.println("Enter item id: ");
		           item_id_var = input.nextInt();
				   cqlStatement = "select id, name, description, initial_price, quantity, reserve_price, buy_now, nb_of_bids, max_bid, start_date, end_date"
				   		+ " from items where id = "+item_id_var+";";
				   print_exec_results(session.execute(cqlStatement));
			       break;
	         case 11:
		           System.out.println("Enter item id: ");
		           item_id_var = input.nextInt();
				   cqlStatement = "select quantity, nb_of_bids, end_date from items where id = "
		            +item_id_var+";";
				   print_exec_results(session.execute(cqlStatement));
			       break;
	         case 12:
		           System.out.println("Enter item id: ");
		           item_id_var = input.nextInt();
				   cqlStatement = "select qty, date from rubis.items_orderby_bid "
		             +" where item_id = "+item_id_var+" order by bid;";
				   print_exec_results(session.execute(cqlStatement));
			       break;
	         case 13:
		           System.out.println("Enter item id: ");
		           item_id_var = input.nextInt();
				   cqlStatement = "select nb_of_bids, max_bid from items where id = "
		            +item_id_var+";";
				   print_exec_results(session.execute(cqlStatement));
			       break;
	         case 14:
		           System.out.println("Enter user id: ");
		           user_id_var = input.nextInt();
				   cqlStatement = "select rating from users where id = "+user_id_var+";";
				   print_exec_results(session.execute(cqlStatement));
			       break;
	         case 15:
		           System.out.println("Enter comment id: ");
		           int comment_id_var = input.nextInt();
				   cqlStatement = "select nickname from comments_users where comment_id = "
						 +comment_id_var+";";
				   print_exec_results(session.execute(cqlStatement));
			       break;
	         case 16:
		           System.out.println("Enter user id: ");
		           user_id_var = input.nextInt();
		           input.nextLine();
			       System.out.println("Enter buy now date: ");
			       String buynow_date = input.nextLine();
				   cqlStatement = "select buynow_id, buynow_qty, item_id, item_name, description, initial_price, item_quantity, reserve_price, buy_now, nb_of_bids, max_bid, start_date, end_date"
				   		+ " from buynow_items where buyer_id = "+user_id_var+" AND date >= "+buynow_date+";";
				   print_exec_results(session.execute(cqlStatement));
			       break;
	         case 17:
		           System.out.println("Enter user id: ");
		           user_id_var = input.nextInt();
		           input.nextLine();
			       System.out.println("Enter item's end_date: ");
			       item_end_date = input.nextLine();
				   cqlStatement = "select id, name, description, initial_price, quantity, reserve_price, buy_now, nb_of_bids, max_bid, start_date, end_date"
				   		+ " from rubis.items_by_users where seller = "+user_id_var+" AND end_date >= "+item_end_date+";";
				   print_exec_results(session.execute(cqlStatement));
			       break;
	         case 18:
		           System.out.println("Enter user id: ");
		           user_id_var = input.nextInt();
		           input.nextLine();
			       System.out.println("Enter item's end_date: ");
			       item_end_date = input.nextLine();
				   cqlStatement = "select bid_id, item_id, item_name, description, initial_price, quantity, reserve_price, buy_now, nb_of_bids, max_bid, start_date, end_date"
				   		+ " from bids_items where user_id = "+user_id_var+" AND end_date >= "+item_end_date+";";
				   print_exec_results(session.execute(cqlStatement));
			       break;
	         case 19:
		           System.out.println("Enter region id: ");
		           int region_id_var = input.nextInt();
		           input.nextLine();
		           System.out.println("Enter category id: ");
		           category_id_var = input.nextInt();
		           input.nextLine();
			       System.out.println("Enter item's end_date: ");
			       item_end_date = input.nextLine();
				   cqlStatement = "select user_id, item_id, item_name, initial_price, max_bid, nb_of_bids, end_date"
				   		+ " from users_items where region = "+region_id_var
				   		+" AND category = "+category_id_var+" AND end_date >= "+item_end_date+";";
				   print_exec_results(session.execute(cqlStatement));
			       break;
	         case 20:
		           System.out.println("Enter region dummy: ");
		           int region_dummy_var = input.nextInt();
				   cqlStatement = "select id, name from regions_by_dummy where dummy = "+region_dummy_var+";";
				   print_exec_results(session.execute(cqlStatement));
			       break;
	         case 21:
		           System.out.println("Insert Item");
		           ResultSet tempResults = session.execute("select max(id) as id from items;");
		           int new_item_id = -1;
		           for (Row row : tempResults) {
		       		  if (row.getInt("id") > new_item_id) {
		       			  new_item_id = row.getInt("id") + 1;
		       		  }
		       	   }
		           
		           input.nextLine();
		           System.out.println("New item's id auto generated: "+new_item_id);
		           System.out.println("Enter new item name (please dont use \'): ");
		           String item_name = input.nextLine();
		           System.out.println("Enter item's description: ");
		           String item_description = input.nextLine();
		           System.out.println("Enter item initial price: ");
		           float item_initial_price = input.nextFloat();
		           input.nextLine();
		           System.out.println("Enter item quantity: ");
		           int item_quantity = input.nextInt();
		           input.nextLine();
		           System.out.println("Enter item reserve price: ");
		           float item_reserve_price = input.nextFloat();
		           input.nextLine();
		           System.out.println("Enter item buy now: ");
		           float ietm_buynow = input.nextFloat();
		           input.nextLine();
		           System.out.println("Enter item start date: ");
		           String item_start_date = input.nextLine();
		           System.out.println("Enter item end date: ");
		           item_end_date = input.nextLine();
		           System.out.println("Enter seller's id: ");
		           int ietm_seller = input.nextInt();
		           input.nextLine();
		           System.out.println("Enter item's category: ");
		           int item_category = input.nextInt();
		           
				   cqlStatement = "insert into items (id, name, description, initial_price, quantity, reserve_price, buy_now, nb_of_bids, max_bid, start_date, end_date, seller, category)"
				   		+ " values ("+new_item_id+", '"+item_name+"', '"+item_description+"', "+item_initial_price+","+ item_quantity+","+ item_reserve_price+","+ ietm_buynow+", 0, 0, '"+item_start_date+"','"+ item_end_date+"',"+ ietm_seller+","+ item_category+");";
				   
				   session.execute(cqlStatement);
				   System.out.println("Item inserted.");
			       break;
	         case 22:
		           System.out.println("Register New User");
		           tempResults = session.execute("select max(id) as id from users;");
		           int new_user_id = -1;
		           for (Row row : tempResults) {
		       		  if (row.getInt("id") > new_user_id) {
		       			new_user_id = row.getInt("id") + 1;
		       		  }
		       	   }
		           
		           input.nextLine();
		           System.out.println("New user's id auto generated: "+new_user_id);
		           System.out.println("Enter new user's firstname: ");
		           String firstname = input.nextLine();
		           System.out.println("Enter user's lastname: ");
		           String lastname = input.nextLine();
		           System.out.println("Enter user's nickname: ");
		           String nickname = input.nextLine();
		           System.out.println("Enter password: ");
		           String password = input.nextLine();
		           System.out.println("Enter email: ");
		           String email = input.nextLine();
		           System.out.println("Enter user's balance: ");
		           float balance = input.nextFloat();
		           input.nextLine();
		           System.out.println("Enter user's region: ");
		           int region = input.nextInt();
		           
				   cqlStatement = "insert into users (id, firstname, lastname, nickname, password, email, balance, creation_date, region)"
				   		+ " values ("+new_user_id+", '"+firstname+"', '"+lastname+"', '"+nickname+"', '"+ password+"', '"+ email+"', "+ balance+", toTimestamp(now()), "+region+");";
				   
				   session.execute(cqlStatement);
				   System.out.println("User registered and inserted.");
			       break;
	         case 23:
		           System.out.println("Store Buy Now");
		           tempResults = session.execute("select max(buynow_id) as buynow_id from buynow_items;");
		           int new_buynow_id = -1;
		           for (Row row : tempResults) {
		       		  if (row.getInt("buynow_id") > new_buynow_id) {
		       			new_buynow_id = row.getInt("buynow_id") + 1;
		       		  }
		       	   }
		           
		           input.nextLine();
		           System.out.println("New buynow id auto generated: "+new_buynow_id);
		           System.out.println("Enter buyer's id: ");
		           int buyer_id = input.nextInt();
		           input.nextLine();
		           System.out.println("Enter buy now qty: ");
		           int buynow_qty = input.nextInt();
		           input.nextLine();
		           System.out.println("Enter item's id: ");
		           int item_id = input.nextInt();
		           
		           item_name = "";
		           item_quantity = 0;
		           String description = "";
		           float initial_price = 0;
		           float reserve_price = 0;
		           float buy_now = 0;
		           int nb_of_bids = 0;
		           float max_bid = 0;
		           Long start_date = null;
		           Long end_date = null;
		           tempResults = session.execute("select name, description, initial_price, quantity, "
		           		+ "reserve_price, buy_now, nb_of_bids, max_bid, start_date, end_date from items where id = "+item_id+";");
		           for (Row row : tempResults) {
		        	   item_name = row.getString("name");
		        	   description = row.getString("description");
		        	   initial_price = row.getFloat("initial_price");
		        	   item_quantity = row.getInt("quantity");
		        	   reserve_price = row.getFloat("reserve_price");
		        	   buy_now = row.getFloat("buy_now");
		        	   nb_of_bids = row.getInt("nb_of_bids");
		        	   max_bid = row.getFloat("max_bid");
		        	   start_date = row.getTimestamp("start_date").getTime();
		        	   end_date = row.getTimestamp("end_date").getTime();
		       	   }
		           
				   cqlStatement = "insert into buynow_items (buyer_id, date, buynow_id, buynow_qty, item_id, item_name, description, initial_price, item_quantity, reserve_price, buy_now, nb_of_bids, max_bid, start_date, end_date)"
				   		+ " values ("+buyer_id+", toTimestamp(now()), "+new_buynow_id+", "+buynow_qty+", "+item_id+", '"+item_name+"', '"+description+"', "+initial_price+","+item_quantity+", "+reserve_price+","
				   		+buy_now+", "+nb_of_bids+", "+max_bid+", "+start_date+", "+end_date+");";
				   
				   session.execute(cqlStatement);
				   System.out.println("New buy now stored.");
			       break;
	         case 24:
		           System.out.println("Store Bid");
		           tempResults = session.execute("select max(bid_id) as bid_id from bids_users;");
		           int new_bid_id = -1;
		           for (Row row : tempResults) {
		       		  if (row.getInt("bid_id") > new_bid_id) {
		       			new_bid_id = row.getInt("bid_id") + 1;
		       		  }
		       	   }
		           
		           input.nextLine();
		           System.out.println("New bid id auto generated: "+new_bid_id);
		           System.out.println("Enter item's id, for this bid: ");
		           item_id_var = input.nextInt();
		           input.nextLine();
		           System.out.println("Enter user's id: ");
		           user_id_var = input.nextInt();
		           input.nextLine();
		           System.out.println("Enter bid's qty: ");
		           int bid_qty = input.nextInt();
		           input.nextLine();
		           System.out.println("Enter the bid: ");
		           float bid_value = input.nextFloat();
		           
		           
		           String user_nickname = "";
		           tempResults = session.execute("select nickname from users where id = "+user_id_var+";");
		           for (Row row : tempResults) {
		        	   user_nickname = row.getString("nickname");
		       	   }
		           
		           int quantity = 0;
		           int new_nb_of_bids = 0;
		           item_name = "";
		           description = "";
		           initial_price = 0;
		           reserve_price = 0;
		           buy_now = 0;
		           max_bid = 0;
		           end_date = null;
		           start_date = null;
		           tempResults = session.execute("select name, description, initial_price, quantity, "
		             +" reserve_price, buy_now, nb_of_bids, max_bid, start_date, end_date from items where id = "+item_id_var+";");
		           for (Row row : tempResults) {
		        	   item_name = row.getString("name");
		        	   description = row.getString("description");
		        	   initial_price = row.getFloat("initial_price");
		        	   quantity = row.getInt("quantity");
		        	   reserve_price = row.getFloat("reserve_price");
		        	   buy_now = row.getFloat("buy_now");
		        	   new_nb_of_bids = row.getInt("nb_of_bids") + 1;
		        	   max_bid = row.getFloat("max_bid");
		        	   start_date = row.getTimestamp("start_date").getTime();
		        	   end_date = row.getTimestamp("end_date").getTime();
		       	   }
		           
		           //Updating max_bid if new bid is greater.
		           if (bid_value > max_bid) {
		        	   max_bid = bid_value;
		        	   session.execute("update items set max_bid = "+max_bid+" where id = "
		  		             +item_id_var+" AND end_date = "+end_date+";");
		           }
		           
		           //updating nb_of_bids
		           session.execute("update items set nb_of_bids = "+new_nb_of_bids+" where id = "
				            +item_id_var+" AND end_date = "+end_date+";");
		           
		           //inserting record for table "bids_items"
		           session.execute("insert into bids_items (user_id, end_date, bid_id, item_id, item_name, description,"
		        		   +" initial_price, quantity, reserve_price, buy_now, nb_of_bids, max_bid, start_date) "
		        		   +" values ("+user_id_var+", "+end_date+", "+new_bid_id+", "+item_id_var+", '"+item_name+"', '"
		        		   +description+"', "+initial_price+", "+quantity+", "+reserve_price+", "+buy_now+", "
		        		   +new_nb_of_bids+", "+max_bid+", "+start_date+");");
		           
		           //inserting record for table "items"
				   cqlStatement = "insert into bids_users (item_id, date, user, user_nickname, bid_id, qty, bid, max_bid) "
				   		+ " values ("+item_id_var+", toTimestamp(now()), "+user_id_var+", '"+user_nickname+"', "+new_bid_id+","+bid_qty+","+bid_value+","+max_bid+");";
				   
				   session.execute(cqlStatement);
				   System.out.println("New bid stored, items updated.");
			       break;
	         case 25:
		           System.out.println("Store Comment");
		           tempResults = session.execute("select max(comment_id) as comment_id from comments_users;");
		           int new_comment_id = -1;
		           for (Row row : tempResults) {
		       		  if (row.getInt("comment_id") > new_comment_id) {
		       			new_comment_id = row.getInt("comment_id") + 1;
		       		  }
		       	   }
		           
		           input.nextLine();
		           System.out.println("New comment id auto generated: "+new_comment_id);
		           System.out.println("Enter from_user's id: ");
		           user_id_var = input.nextInt();
		           input.nextLine();
		           System.out.println("Enter to_user's id: ");
		           int to_user_id = input.nextInt();
		           input.nextLine();
		           System.out.println("Enter item's id, for this comment: ");
		           item_id_var = input.nextInt();
		           input.nextLine();
		           System.out.println("Enter the rating: ");
		           int rating = input.nextInt();
		           input.nextLine();
		           System.out.println("Enter the comment (please dont type \'): ");
		           String comment = input.nextLine();
		           
		           
		           user_nickname = "";
		           tempResults = session.execute("select nickname from users where id = "+user_id_var+";");
		           for (Row row : tempResults) {
		        	   user_nickname = row.getString("nickname");
		       	   }
		           
		           
				   cqlStatement = "insert into comments_users (comment_id, from_user, id, nickname, to_user, item, rating, date, comment) "
				   		+ " values ("+new_comment_id+", "+user_id_var+", "+new_comment_id+", '"+user_nickname+"', "
				   		+to_user_id+", "+item_id_var+ ", "+rating+", toTimestamp(now()), '"+comment+"');";
				   
				   session.execute(cqlStatement);
				   System.out.println("New comment stored.");
			       break;
	         default:
	           System.out.println("Invalid input.");
	       }
//	       input.close();
//	       System.exit(0);
	       System.out.println("Finished.");
	       } while (true);
        }
    
    
    
    public static void print_exec_results(ResultSet cqlResults) {
    	boolean executed = false;
    	for (Row row : cqlResults) {
    		if(!executed) {
    			System.out.println(row.getColumnDefinitions());
        	    executed = true;
        	}
	    	System.out.println(row);
    	}
    }
}
