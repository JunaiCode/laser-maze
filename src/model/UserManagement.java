package model;

public class UserManagement {
	private User root;
	
	public UserManagement() {
		root = null;
	}
	
	public void addUser(User u) {
		if(root ==null) {
			root = u;
		}
		else {
			addUser(root,u);
		}
	}
	
	private void addUser(User current, User u) {
	   if(current.getScore()> u.getScore()) {
		   if(current.getLeft() == null) {
			 current.setLeft(u);
			 u.setParent(current);
		   }
		   else {
			 addUser(current.getLeft(),u);  
		   }
	   }
	   else {
		   if(current.getRight() == null) {
				 current.setRight(u);
				 u.setParent(current);
			   }
			   else {
				 addUser(current.getRight(),u);
			   }
	   }
	}
	
	public void inOrder(User x) {
		if(x!= null) {
		  inOrder(x.getLeft());
		  System.out.println(x.getData());
		  inOrder(x.getRight());
		}
	}
	
	public User getRoot() {
		return root;
	}
}
