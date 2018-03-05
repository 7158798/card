package com.rw.finance.common.utils;
/**
 * 
 * @file ThreadUtils.java	
 * @author huanghongfei
 * @date 2017年12月22日 上午10:26:26
 * @declaration
 */
public class ThreadUtils {
	/**
     * 通过线程组获得线程
     *
     * @param threadName 线程名称
     * @return thread对象
     */
	private Thread findThread(String threadName) {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        while(group != null) {
            Thread[] threads = new Thread[(int)(group.activeCount() * 1.2)];
            int count = group.enumerate(threads, true);
            for(int i = 0; i < count; i++) {
                if(threadName.equals(threads[i].getName())) {
                    return threads[i];
                }
            }
            group = group.getParent();
        }
        return null;
    }
}
