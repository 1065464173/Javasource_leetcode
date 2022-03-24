# 回溯基本框架

三个考虑的问题：

1. 路径：也就是已经做出的选择。
2. 选择列表：也就是你当前可以做的选择。
3. 结束条件：也就是到达决策树底层，无法再做选择的条件。

```c++

 result = []
     def backtrack(路径, 选择列表):
         if 满足结束条件:
             result.add(路径)
             return

         for 选择 in 选择列表:
             做选择
             backtrack(路径, 选择列表)
             撤销选择
```

# 回溯应用

* FullPermutation - 全排列问题
* NQueens - N皇后问题