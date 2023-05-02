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


TreeNode* Solution_leetcode_701:: insertIntoBST(TreeNode* root, int val) {
    if (root == nullptr) {
        root = new TreeNode(val);
        return root;
    }
    insert(root, val);
    return root;
}

void Solution_leetcode_701::insert(TreeNode* node, int val) {
       
    if (node->left == nullptr && val<node->val) {
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

