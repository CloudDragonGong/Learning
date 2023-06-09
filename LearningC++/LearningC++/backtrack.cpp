﻿#include "backtrack.h"
#include "Tool.h"
vector<vector<int>> solution_leetcode_216::combinationSum3(int k, int n) {
	if (k > 10 || k <= 0) return {};
	vector<vector<int>>* array = new vector<vector<int>>;
	stack<int>* Stack = new stack<int>;
	dfs(k, n, 1, Stack, array);
	return *array;
}

void solution_leetcode_216::dfs(int k, int n, int begin, stack<int>* Stack, vector<vector<int>>* array) {
	if (Stack->size() == k) {
		int num = 0;
		stack<int> copy = *Stack;
		vector<int> subarray;
		for (int i = 0; i < Stack->size(); i++) {
			num += copy.top();
			subarray.push_back(copy.top());
			copy.pop();
		}
		if (num == n) {
			array->push_back(subarray);
		}
		return;
	}

	for (int i = begin; i <= 9 - (k - Stack->size()) + 1; i++) {
		Stack->push(i);
		dfs(k, n, i + 1, Stack, array);
		Stack->pop();
	}
}

void printVector(const std::vector<std::vector<int>>& array) {
	for (const auto& row : array) {
		for (int element : row) {
			std::cout << element << " ";
		}
		std::cout << std::endl;
	}
}

void solution_leetcode_216::test() {
	/*
	找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：

	只使用数字1到9
	每个数字 最多使用一次 
	返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。

	来源：力扣（LeetCode）
	链接：https://leetcode.cn/problems/combination-sum-iii
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	*/

	/*执行结果：
	通过
	显示详情
	查看示例代码
	添加备注

	执行用时：
	0 ms
	, 在所有 C++ 提交中击败了
	100.00%
	的用户
	内存消耗：
	7.9 MB
	, 在所有 C++ 提交中击败了
	5.00%
	的用户
	通过测试用例：
	18 / 18*/
	vector<vector<int>> arrays = combinationSum3(4, 1);
	printVector(arrays);
}
vector<vector<string>> solution_leetcode_131::partition(string s) {
	vector<vector<string>>* arrays = new vector<vector<string>>;
	stack<string>* Stack = new stack<string>;
	BT2(s, 0, arrays, Stack);
	return *arrays;
}
void solution_leetcode_131::BT2(string s, int begin, vector<vector<string>>* arrays, stack<string>* Stack) {

	for (int i = begin; i < s.length(); i++) {
		if (judgment_palindrome_string(s.substr(begin, i - begin + 1))) {
			if (i == s.length() - 1) {
				stack<string>Stack_copy = *Stack;
				stack<string>Stack_use;
				vector<string> array;
				while (!Stack_copy.empty()) {
					Stack_use.push(Stack_copy.top());
					Stack_copy.pop();
				}
				while (!Stack_use.empty()) {
					array.push_back(Stack_use.top());
					Stack_use.pop();
				}
				array.push_back(s.substr(begin, i - begin + 1));
				arrays->push_back(array);
				return;
			}
			Stack->push(s.substr(begin, i - begin + 1));
			BT(s, i + 1, arrays, Stack);
			Stack->pop();
		}
	}
}
void solution_leetcode_131::BT(string s, int begin, vector<vector<string>>* arrays, stack<string>* Stack) {
	if (judgment_palindrome_stack(*Stack)) {
		for (int i = begin; i < s.length(); i++) {
			if (judgment_palindrome_string(s.substr(begin, i - begin + 1))) {
				if (i == s.length() - 1) {
					stack<string>Stack_copy = *Stack;
					stack<string>Stack_use;
					vector<string> array;
					while (!Stack_copy.empty()) {
						Stack_use.push(Stack_copy.top());
						Stack_copy.pop();
					}
					while (!Stack_use.empty()) {
						array.push_back(Stack_use.top());
						Stack_use.pop();
					}
					array.push_back(s.substr(begin, i - begin + 1));
					arrays->push_back(array);
					return;
				}
				Stack->push(s.substr(begin, i - begin + 1));
				BT(s, i + 1, arrays, Stack);
				Stack->pop();
			}
		}
	}
	else {
		return;
	}
}
bool solution_leetcode_131::judgment_palindrome_stack(stack<string> Stack) {
	for (int i = 0; i < Stack.size(); i++) {
		if (judgment_palindrome_string(Stack.top())) {
			Stack.pop();
		}
		else {
			return false;
		}
	}
	return true;
}

bool solution_leetcode_131::judgment_palindrome_string(string s) {
	if (s.length() == 1) {
		return true;
	}
	else if (s.length() == 0) {
		return false;
	}
	stack<char> Stack;
	for (int i = 0; i < s.length(); i++) {
		Stack.push(s[i]);
	}
	for (int i = 0; i < s.length(); i++) {
		if (Stack.top() == s[i]) {
			Stack.pop();
		}
		else {
			return false;
		}
	}
	return true;
}

void solution_leetcode_131::test() {
	/*
	* 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。

	回文串 是正着读和反着读都一样的字符串。
	*/
	/*
	执行用时：
	404 ms
	, 在所有 C++ 提交中击败了
	5.31%
	的用户
	内存消耗：
	302 MB
	, 在所有 C++ 提交中击败了
	5.00%
	的用户
	通过测试用例：
	32 / 32
	*/
	string s = "";
	vector<vector<string>> arrays = partition(s);
	for (const auto& innerVec : arrays) {
		for (const auto& str : innerVec) {
			std::cout << str << " ";
		}
		std::cout << std::endl;
	}
}


vector<vector<int>> Solution_leetcode_491:: findSubsequences(vector<int>& nums) {
	/*给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。

	数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。

 

	示例 1：

	来源：力扣（LeetCode）
	链接：https://leetcode.cn/problems/non-decreasing-subsequences
	著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	*/
	/*
	行用时：
	132 ms
	, 在所有 C++ 提交中击败了
	5.16%
	的用户
	内存消耗：
	103.4 MB
	, 在所有 C++ 提交中击败了
	5.02%
	的用户
	通过测试用例：
	58 / 58*/
	vector<vector<int>> arrays;
	vector<int>array;
	BT(nums, 0, arrays, array,INT_MIN);
	return arrays;
}


void Solution_leetcode_491:: BT(vector<int> nums, int cur, vector<vector<int>> &arrays, vector<int> &array,int last) {
	if (cur == nums.size()) {
		if(array.size()>1)
		arrays.push_back(array);
		return;
	}
	//至少两个元素
	//重复的不行
	if (array.empty()||last<=nums[cur]) {
		array.push_back(nums[cur]);
		BT(nums, cur + 1, arrays, array,nums[cur]);
		array.pop_back();
	}
	//意思就是如果有重复的元素，让最后一个匹配，比如4 6 7 6 6 6 9 10 ，可能会生成 4 6 9 的重复，为了避免
	//只让最后一个6生成 4 6 9 让后面的递归阻塞，如果前面添加的元素有6的话，不让你进行下面的递归
	//就比如 4 6 9(6为第一个6) 应该经过4 6 _  _  _ _ 9 ,这个算法就删除这个情况，在第二个_这里就不让你递归，直接切掉这个路
	if(array.size()==0||last != nums[cur])
		BT(nums, cur + 1, arrays, array,last);
 }


void Solution_leetcode_491::test() {
	vector<int> nums = { 4,6,7,7 };
	vector<vector<int>> arrays = findSubsequences(nums);
	PrintVecofVec1(arrays);
}


void Solution_leetcode_46:: test() {
	vector<int> nums = { 0,1 ,2,3,4,5,6 };
	vector<vector<int>> arrays = permute(nums);
	PrintVecofVec1(arrays);
}