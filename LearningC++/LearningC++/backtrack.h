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

class Solution_leetcode_491 {
public:
	vector<vector<int>> findSubsequences(vector<int>& nums);
	void BT(vector<int> nums, int cur, vector<vector<int>>& arrays, vector<int> &array,  int last);
	void test();
};


class Solution_leetcode_46 {
	/*
	* ����һ�������ظ����ֵ����� nums �������� ���п��ܵ�ȫ���� ������� ������˳�� ���ش𰸡�
	*/
	/*ִ�н����
	ͨ��
	��ʾ����
	�鿴ʾ������
	��ӱ�ע

	ִ����ʱ��
	0 ms
	, ������ C++ �ύ�л�����
	100.00%
	���û�
	�ڴ����ģ�
	7.4 MB
	, ������ C++ �ύ�л�����
	90.67%
	���û�
	ͨ������������
	26 / 26
	*/
	
public:
	void BT(int begin, vector<int>& nums, vector<vector<int>>& arrays) {
		if (begin == nums.size()) {
			arrays.push_back(nums);
			return;
		}
		for (int i = begin; i < nums.size(); i++) {
			swap(nums[i], nums[begin]);
			BT(begin + 1, nums, arrays);
			swap(nums[i], nums[begin]);
		}
	}
	vector<vector<int>> permute(vector<int>& nums) {
		vector<vector<int>> arrays;
		vector<int>Stack;
		BT(0, nums, arrays);
		return arrays;
	}
	void test();
};