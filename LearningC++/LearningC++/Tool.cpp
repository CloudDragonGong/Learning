#include "Tool.h"

void PrintVecofVec1(vector<vector<int>>& res) {
	for (auto& rowV : res) {
		for (auto& el : rowV) {
			cout << el << " ";
		}
		cout << "; ";
	}
	cout << endl;
}
