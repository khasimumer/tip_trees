package com.tip.trees;

public class BinarySearchTree {
   private TreeNode root;
   
   public TreeNode find(Integer data) {
	   if(root != null) {
		   return root.find(data);
	   }
	   return null;
   }
   
   
   public void insert (Integer data) {
	   if(root == null) {
		   this.root = new TreeNode(data);
	   }else {
		   root.insert(data);
	   }
   }
   
   
   public void delete (Integer data) {
	   TreeNode current = this.root; 
	   TreeNode parent = this.root;
	   boolean isLeftChild = false; //to keep track of which way the current pointer moves
		
	   //check for an empty tree i.e. root is null
	   if(current == null) {
		   return;
	   }
	   
	   //check for end of the tree and exit loop
	   //node to be deleted will be represented by current
	   while (current !=null && current.getData() != data) {
		   parent = current;  //set parent to current as long as data doesn't match
		   
		   //move the current pointer to one of the nodes - left or right depending on data
		   if(data < current.getData()) {
			   current = current.getLeftChild();
			   isLeftChild = true;
		   }else {
			   current = current.getRightChild();
			   isLeftChild = false;
		   }
	   }
	   //now, current will either be pointing to the node to be deleted or NULL if that node doesn't exist in the tree
	   
	   if(current == null) {
		   return;
	   }
	   
	   //delete the current node which is a LEAF node  i.e. CASE 1  ***
	   if(current.getLeftChild() == null && current.getRightChild() == null) {
		   if(current == root) { //if ROOT, deleting the root 
			   root = null;
		   }else {
			   if (isLeftChild) { //else check if it is Left child or right child
				   parent.setLeftChild(null);
			   }else {
				   parent.setRightChild(null);
			   }
		   }//if the node to be deleted has ONLY LEFT child i.e. CASE 2 ***
	   }else if (current.getRightChild() == null) {
		   if(current == root) { 
			   root = current.getLeftChild(); //set the ONLY LEFT child as ROOT
		   }else if (isLeftChild) {
			   parent.setLeftChild(current.getLeftChild());//the left child of deleted node will be the NEW left child of the parent node
		   }else {
			   parent.setRightChild(current.getLeftChild());//the left child of deleted node will be the NEW RIGHT child of the parent node
		   }//the node to be deleted has ONLY right child
	   }else if(current.getLeftChild()==null) {
		   if(current == root) {
			   root = current.getRightChild();
		   }else if(isLeftChild) {
			   parent.setLeftChild(current.getRightChild());
		   }else {
			   parent.setRightChild(current.getRightChild());
		   }
	   }else {// CASE 3 - node to be deleted has both Left and Right Child !
		   
	   }
	   
   }
}
