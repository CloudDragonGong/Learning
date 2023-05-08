#include "backtrack.h"

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