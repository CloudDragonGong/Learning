#pragma once
#include <iostream>
#include <vector>
#include <queue>
#include <stack>
using namespace std;
class solution_leetcode_216 {
public:
	void test();
	vector<vector<int>> combinationSum3(int k, int n);
	void dfs(int k, int n, int begin, stack<int>* Stack, vector<vector<int>>* array);
};