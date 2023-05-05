#include <iostream>
#include <vector>
#include <queue>
#include "binary_tree.h"
//Definition for a binary tree node.

TreeNode* TreeNode::buildTree(std::vector<int>& arr) {
	if (arr.empty()) {
		return nullptr;
	}
	TreeNode* root = new TreeNode(arr[0]);
	std::queue<TreeNode*> q;
	q.push(root);
	int i = 1;
	while (i < arr.size()) {
		TreeNode* parent = q.front();
		q.pop();
		if (arr[i] != NULL) {
			TreeNode* left = new TreeNode(arr[i]);
			parent->left = left;
			q.push(left);
		}
		i++;
		if (i < arr.size() && arr[i] != NULL) {
			TreeNode* right = new TreeNode(arr[i]);
			parent->right = right;
			q.push(right);
		}
		i++;
	}
	return root;
}

void TreeNode::printLevelOrder(TreeNode* root) {
	if (!root) {
		return;
	}
	std::queue<TreeNode*> q;
	q.push(root);
	while (!q.empty()) {
		int size = q.size();
		for (int i = 0; i < size; i++) {
			TreeNode* curr = q.front();
			q.pop();
			if (curr) {
				std::cout << curr->val << " ";
				q.push(curr->left);
				q.push(curr->right);
			}
			else {
				std::cout << "NULL ";
			}
		}
		std::cout << std::endl;
	}
}

TreeNode* TreeNode::createTree(std::vector<int> nums) {
	if (nums.empty()) return nullptr;
	int i = 0, n = nums.size();
	TreeNode* root = new TreeNode(nums[i++]);
	std::queue<TreeNode*> q{ {root} };
	while (!q.empty()) {
		int size = q.size();
		for (int j = 0; j < size; ++j) {
			auto t = q.front(); q.pop();
			if (i < n && nums[i] != -1) {
				t->left = new TreeNode(nums[i]);
				q.push(t->left);
			}
			++i;
			if (i < n && nums[i] != -1) {
				t->right = new TreeNode(nums[i]);
				q.push(t->right);
			}
			++i;
		}
	}
	return root;
}

void TreeNode::printTree(TreeNode* root) {
	if (!root) return;
	std::queue<TreeNode*> q{ {root} };
	std::cout << root->val;
	while (!q.empty()) {
		auto t = q.front(); q.pop();
		if (t->left) {
			q.push(t->left);
			std::cout << "," << t->left->val;
		}
		else {
			std::cout << ",null";
		}
		if (t->right) {
			q.push(t->right);
			std::cout << "," << t->right->val;
		}
		else {
			std::cout << ",null";
		}
	}
}
TreeNode* Solution_leetcode_701::insertIntoBST(TreeNode* root, int val) {
	if (root == nullptr) {
		root = new TreeNode(val);
		return root;
	}
	insert(root, val);
	return root;
}

void Solution_leetcode_701::insert(TreeNode* node, int val) {

	if (node->left == nullptr && val < node->val) {
		node->left = new TreeNode(val);
	}
	else if (node->right == nullptr && val > node->val) {
		node->right = new TreeNode(val);
	}
	else {
		if (val < node->val) {
			insert(node->left, val);
		}
		else {
			insert(node->right, val);
		}
	}
}

void Solution_leetcode_701::test() {
	std::vector<int> arr = {};
	TreeNode* tree = TreeNode::buildTree(arr);
	tree = insertIntoBST(tree, 5);
	tree->printLevelOrder(tree);
}

TreeNode* Solution_leetcode_801::trimBST(TreeNode* root, int low, int high) {
	if (root == nullptr) {
		return root;
	}
	if (root->val < low) {
		root = trimBST(root->right, low, high);
		return root;
	}
	else if (root->val > high) {
		root = trimBST(root->left, low, high);
		return root;
	}
	else {
		root->left = trimBST(root->left, low, high);
		root->right = trimBST(root->right, low, high);
		return root;
	}
}

void Solution_leetcode_801::test() {
	/*
	给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。

	所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。

	来源：力扣（LeetCode）
	链接：https://leetcode.cn/problems/trim-a-binary-search-tree
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	*/
	//执行用时：
	/*
		12 ms
		, 在所有 C++ 提交中击败了
		84.90 %
		的用户
		内存消耗：
		23.3 MB
		, 在所有 C++ 提交中击败了
		71.71 %
		的用户
		通过测试用例：
		78 / 78
	*/
	std::vector<int>arr = { 3,0,4,-1,2,-1,-1,1 };
	TreeNode* tree = TreeNode::createTree(arr);
	tree->printTree(tree);
	std::cout << std::endl;
	tree = trimBST(tree, 1, 3);
	tree->printTree(tree);
}