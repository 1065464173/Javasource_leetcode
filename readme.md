﻿# 力扣学习计划

## 计划日程

* **当前计划** ：《剑指OfferI》/ 2021.11.10 - 2021.12.10
* [力扣进度](https://leetcode-cn.com/progress/)
* **历史计划：**

|      计划名      |        时间始终         | 持续时间/天 | 学习情况 |      |
| :--------------: | :---------------------: | :---------: | :------: | ---- |
| LeetCode每日一题 |  2021.6.21 - 2021.11.9  |     141     |  187题   | ✅    |
|  《剑指OfferI》  | 2021.11.10 - 2021.12.10 |     31     |    -     | 🕤    |

## 日记

### Nov. 2021
---

#### 2021/11/10

写leetcode有五六个月了吧，原先每天计划刷1-2题，但是由于没有写规划，所以经常懒惰或者将两三天的计划并到一天写。故决定从今天起将刷题计划写下来，并记录日志，以激励自己。

✅ 《剑指OfferI》/ 栈与队列（简单）

#### 2021/11/11

今天的题目都做了好久，三道题里有两道参考了解题答案。对于链表的掌握还需要再加强啊！但也是颇有收获。

✅ 《剑指OfferI》/ 链表（简单）

#### 2021/11/12

简单题我重拳出击！！但是简单也要把控好细节的效率问题，比如说字符串的拼接最好不要用"+"，比较消耗性能，但是从今天题目的测试结果来看差的并不多？ 把昨天的链表重新过了一遍，可以独立写出整个框架，掌握理解以及复习了了昨天题目的大体的思路。

✅ 《剑指OfferI》/ 字符串（简单）

#### 2021/11/13

在**排序**数组中搜索优先使用**二分算法**

✅ 《剑指OfferI》/ 查找算法（简单）

#### 2021/11/14

查找算法一般先考虑二分，再考虑字典，如果和需要查找第一个xx，可以考虑使用队列——队列的结构先进先出可以很好地解决此类问题。

✅ 《剑指OfferI》/ 查找算法（中等）

#### 2021/11/15

很开心～三道题自己和答案的思路都差不多，官方实现答案更加简单易懂，不走弯路。

📝记录一下：Queue使用时要尽量避免Collection的add()和remove()方法，而是要使用offer()来加入元素，使用poll()来获取并移出元素。它们的优点是通过返回值可以判断成功与否，add()和remove()
方法在失败的时候会抛出异常。

✅ 《剑指OfferI》/ 搜索与回溯算法（简单）

#### 2021/11/16

今天总的来说掌握的不是很到位，对于回溯的逻辑总是容易弄混乱，尤其是[剑指 Offer 26. 树的子结构](https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/)
这道题。先是看懂了答案的思路，但是由自己重现的时候还是会磕磕巴巴

✅ 《剑指OfferI》/ 搜索与回溯算法（简单）

#### 2021/11/17

动态规划算法的基本思想与分治法类似，也是将待求解的问题分解为若干个子问题（阶段），按顺序求解子阶段，前一子问题的解，为后一子问题的求解提供了有用的信息。做题过程中，有两道题是
斐波那契数列，直接使用递归的化很容易导致栈溢出，使用滑动窗口可以完美的避开这一点。 常见步骤：拆分问题(可递归或递推实现的小问题)->定义问题与状态之间的关系(推导公式)—>只保存最优解

✅ 《剑指OfferI》/ 动态规划（简单）

#### 2021/11/18

按照昨天动态规划的思路进行解题，总是能和答案相近的思路结出。所以这里再强调一下这个思路——很好用～

**动态规划解题步骤：拆分问题(可递归或递推实现的小问题)->定义问题与状态之间的关系(推导公式)—>只保存最优解**

并且在今天写[剑指 Offer 42. 连续子数组的最大和](https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/)
的时候对官方递第二种解答的方案真的感触颇深

- 虽然第二种方案相比与第一种时间复杂度相同，但是因为使用了递归，并且维护了四个信息的结构体，运行的时间略长，空间复杂度也不如方法一优秀，而且难以理解。但这种方法存在的意义是可以解决更多的问题，对于大规模的查询情况下 更有优势——线段树。
  所以有时候算法需要和业务相结合，真正开发中可能需要关注算法的可扩展性，并不是一时的效率快就是好。

✅ 《剑指OfferI》/ 动态规划（中等）

#### 2021/11/19

今天总的来说还可以，第一道把数字翻译成字符串，其本质就是斐波那契数列，第二道题是求出最长不含重复字符的子字符串，使用了递推+哈希表的形式解决的。

✅ 《剑指OfferI》/ 动态规划（中等）

#### 2021/11/20

双指针很好懂，也很好实现，同样是顺序解决问题，多一个指针可以很好的解决暴力解法中的冗余过大的问题 双指针也常称作快慢指针，在面试的时候常用。

✅ 《剑指OfferI》/ 双指针（简单）

#### 2021/11/21

双指针的实现思路写的和答案都差不多，但是[第二题](https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/)
在理解上没有处理好，把公共节点的判断方式误以为是值相等，其实应该是指针相等。 总体思路没有偏差～

✅ 《剑指OfferI》/ 双指针（简单）

#### 2021/11/22

在写[第一题](https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/)
的时候注意到一个小细节：我实现奇偶判断使用`%2==0`实现，官方直接使用位运算 用`&1`判断位数2^0是1还是0，这样判断奇偶效率更快。（小本本记下来）

✅ 《剑指OfferI》/ 双指针（简单）

#### 2021/11/23

搜索与回溯算法：为了求得问题的解，先选择某一种可能情况向前探索，在探索过程中，一旦发现原来的选择是错误的，就退回一步重新选择，继续向前探索，如此反复进行，直至得到解或证明无解。
今天两道题用的都是深度搜索，确定搜索时的终止条件，第一题是求是否有解，只要找到答案就直接返回true输出，如果返回的是false则继续进行苏搜索。第二题问题是求所有解——及只要符合遍记录，可以进行bfs和dfs，确定不符合解的条件，决定记录与否，另外需要明确：只要记录过的解都不可重复再记录。
看了一下明天也是搜索与回溯算法类型的题目，小flag：明天根据5道回溯题总结自己适用的算法框架。

✅ 《剑指OfferI》/ 搜索与回溯算法（中等）

#### 2021/11/24

今天3道题有两道是看了答案的，原因一是今天状态不是很好（天冷了注意身体了要！），脑袋有点昏昏沉沉。原因二是对回溯的理解不够透彻，没有自己的方法论，只有硬想。 发现很多回溯不需要返回值，只需要遍历记录即可。 并且通常会和深度搜索和树结构结合。
需要注意的部分需求需要在遍历是添上回溯返回的操作。部分只需要遍历到最后就好（有点类似与暴力解法）。

✅ 《剑指OfferI》/ 搜索与回溯算法（中等）

#### 2021/11/25

今天两道排序题目，但是我都没有写出来，呜呜呜呜。两道排序题都有巧妙的解法，值得学习借鉴。[剑指 Offer 45. 把数组排成最小的数](https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/)
、 [剑指 Offer 61. 扑克牌中的顺子](https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/)

✅ 《剑指OfferI》/ 排序（简单）

#### 2021/11/26

学到了一个数据结构-大小顶堆（栈实现）。对应类PriorityQueue。根据参数中的Comparator决定是大顶堆还是小顶堆。题目二数据流中的中位数就可以使用一个大顶堆+一个小顶堆实现。

✅ 《剑指OfferI》/ 排序（中等）

#### 2021/11/27

对回溯算法的套路有了一定的掌握，对今天两道题的完成度也很高。主要利用深度优先搜索完成遍历。

✅ 《剑指OfferI》/ 搜索与回溯算法（中等）

#### 2021/11/28

今天有两道有关最近祖先的问题，总结得对于搜索二叉树的回溯算法可以根据树的值的特点进行设计，非搜索二叉树先找到两个节点的路径，由于公共祖先的前面节点都是重合的，所以再次遍历两个路径即可。

✅ 《剑指OfferI》/ 搜索与回溯算法（中等）

#### 2021/11/29

分治：把问题分为几个子问题，求的子问题解后在合并成求整个问题的解法。 步骤：分解、求解、整合。
这几天做题目比较浮躁，一道题目通常要做很久很久，最终还是看解答抄作业了，有些作业也需要看很久才知道是如何得出结论的。可看评论区会发现，我所烦躁的题目人家琢磨了整整两天，写出了一个复杂度十分高的可通过过程（至少是可以解决问题了），再通过看精选的解答，融会贯通，更有心得体会了。我一天做三道，感觉越来越像是完成一个给自己定下的任务，并没有好好享受这个过程。做出来了就洋洋得意，做不出来就心浮气躁——深知这是不对的，学习算法是一个漫长且艰难的过程，如果没有足够的毅力很容易中途倒下，希望自己写下这个反思能给未来的自己一点警示，切莫心急，好事总是需要慢慢到来～

✅ 《剑指OfferI》/ 分治算法（中等）

#### 2021/11/30

位运算相比于十进制运算，处理速度更快，执行效率也更高，主要就是分清楚｜^ & ~ << >> 这些 位运算的含义。再到常见的位运算操作，比如：判断奇偶、交换符号、获得低位1等等——需要积攒

✅ 《剑指OfferI》/ 位运算（简单）

#### 2021/12/1

我:答案看完了. 脑子:有什么想法？我:哈希表挺好的…… ^_^

看到位运算找出出现n次的题目，我居然只能想到hashmap，我有罪。看到评论区还有用卡诺图解题的，好好复习了一遍，终于把题目看懂的感觉真的好爽

✅ 《剑指OfferI》/ 位运算（中等）

#### 2021/12/2

今天是两道数学题解，通常数学题解都可以使用暴力解法解——基本上也是超时。有点像脑经急转弯。根据第一道题复习了一遍 Boyer-Moore 投票算法——类似与分治。

✅ 《剑指OfferI》/ 数学（简单）

#### 2021/12/3

笑不活了，今天做数学题解，我在纸上列了方程式——用求和公式结合求根公式得每一个可用的解，再添加到答案里，结果没有官方一个暴力枚举法快 T——T 不过好歹是自己写了一大堆做出来了！！！欣慰～ By the way,数学是真的美妙。

✅ 《剑指OfferI》/ 数学（中等）

#### 2021/12/4

两道模拟题实现的都很完美，顺着思路写模拟，将变化转为代码即可，没有过多的套路，只有细节的处理～nice～

✅ 《剑指OfferI》/ 模拟（中等）

#### 2021/12/5

两道字符串的题目都走投机取巧的方法做出来了，看了答案人家是用有限机做的，有关有限机转为代码的过程我还需要仔细研究一下，这两天周末回家啦，感觉做题目没有特别认真，不过幸好还是完成给自己定下的指标了！

✅ 《剑指OfferI》/ 字符串（中等）

#### 2021/12/6

还以为困难题得琢磨很久！但是发现自己题刷多了真的对解题有了经验！很多套路一点就通了～学有所成就是如此吧！第一题滑动窗口直接写了双高的题解（虽然试错很多，很多边界情况反复修改），接下来的几天都是困难模式，加油冲～

✅ 《剑指OfferI》/ 栈与队列（困难）

#### 2021/12/7

回溯算法就是纯暴力穷举，复杂度一般都很高.回溯的套路（考虑三个问题）：

1. 路径：也就是已经做出的选择。
2. 选择列表：也就是你当前可以做的选择。
3. 结束条件：也就是到达决策树底层，无法再做选择的条件。

```
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

✅ 《剑指OfferI》/ 搜索与回溯算法（困难）