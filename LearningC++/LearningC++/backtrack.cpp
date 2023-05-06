#include "backtrack.h"

vector<vector<int>> solution_leetcode_216::combinationSum3(int k, int n) {
	if (k > 10 || k <= 0) return {};
	vector<vector<int>>  *array = new vector<vector<int>> ;
	stack<int> * Stack = new stack<int>;
	dfs(k, n, 1, Stack, array);
	return *array;
}

void solution_leetcode_216:: dfs(int k, int n,int begin, stack<int> *Stack, vector<vector<int>> *array) {
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