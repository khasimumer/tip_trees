package com.tip.trees;

public class TreeNode {
		private Integer data;
		public TreeNode rightChild;
		public TreeNode leftChild;
		
		
		public Integer getData() {
			return data;
		}

		public TreeNode getRightChild() {
			return rightChild;
		}

		public void setRightChild(TreeNode rightChild) {
			this.rightChild = rightChild;
		}

		public TreeNode getLeftChild() {
			return leftChild;
		}

		public void setLeftChild(TreeNode leftChild) {
			this.leftChild = leftChild;
		}

		public TreeNode(Integer data) {
			this.data = data;
		}
		
		public TreeNode find(Integer data) {
			if (this.data == data) {
				return this;
			}
			
			if(data < this.data && leftChild != null) {
				return leftChild.find(data);
			}
			
			if(data > this.data && rightChild != null) {
				return rightChild.find(data);
			}
			
			return null;			
		}
		
		public void insert(Integer data) {
			if (data >= this.data) {
				if(this.rightChild == null) {
					this.rightChild = new TreeNode(data);
				}else {
					this.rightChild.insert(data);
				}
			}else {
				if(this.leftChild == null) {
					this.leftChild = new TreeNode(data);
				}else {
					this.leftChild.insert(data);
				}
			}
		}
		
		public void delete(Integer data) {
			
			
		}
}
