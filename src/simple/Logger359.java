package simple;

import java.util.HashMap;

/**
 * @program: Javasource_leetcode
 * @description: 请你设计一个日志系统，可以流式接收消息以及它的时间戳。每条 不重复 的消息最多只能每 10 秒打印一次。也就是说，如果在时间戳 t
 *     打印某条消息，那么相同内容的消息直到时间戳变为 t + 10 之前都不会被打印。 所有消息都按时间顺序发送。多条消息可能到达同一时间戳。 实现 Logger 类： Logger()
 *     初始化 logger 对象 bool shouldPrintMessage(int timestamp, string message) 如果这条消息 message 在给定的时间戳
 *     timestamp 应该被打印出来，则返回true ，否则请返回false 。
 * @author: Sxuet
 * @create: 2021-09-03 20:28
 */
public class Logger359 {

  HashMap<String, Integer> map = null;

  public Logger359() {
    map = new HashMap<>();
  }

  public boolean shouldPrintMessage(int timestamp, String message) {
    if (!map.containsKey(message) || map.get(message) <= timestamp) {
      map.put(message, timestamp + 10);
      return true;
    }
    return false;
  }
}
/*
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
