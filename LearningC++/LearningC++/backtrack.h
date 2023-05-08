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

class solution_leetcode_131 {
public:
	void test(); 
	vector<vector<string>> partition(string s);
	void BT(string s, int begin, vector<vector<string>>* arrays, stack<string>* Stack);
	void BT2(string s, int begin, vector<vector<string>>* arrays, stack<string>* Stack);
	bool judgment_palindrome_stack(stack<string> Stack);
	bool judgment_palindrome_string(string s);
};