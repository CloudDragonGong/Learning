#pragma once
#include <iostream>
#include <vector>
#include <queue>
struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right) {}
    static TreeNode* buildTree(std::vector<int>& arr);
    static void printLevelOrder(TreeNode* root);

};

class Solution_leetcode_701 {
public:
    TreeNode* insertIntoBST(TreeNode* root, int val);
    void insert(TreeNode* node, int val);
    void test();
};
