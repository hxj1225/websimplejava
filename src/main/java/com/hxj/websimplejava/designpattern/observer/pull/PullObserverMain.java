package com.hxj.websimplejava.designpattern.observer.pull;

/**
 * ���������֪ͨ�۲��ߵ�ʱ��ֻ����������Ϣ������۲�����Ҫ���������Ϣ���ɹ۲�����������������л�ȡ���൱���ǹ۲��ߴ���������������ݡ�һ������ģ�͵�ʵ���У���������������ͨ��update()�������ݸ��۲��ߣ�
 * �����ڹ۲�����Ҫ��ȡ���ݵ�ʱ�򣬾Ϳ���ͨ�������������ȡ�ˡ�
 * 
 * @author xiangjun.hexj
 * @date 2014��8��26�� ����6:14:37
 */
public class PullObserverMain {

    public static void main(String[] args) {
        PullObserver pullObserver = new PullConcreteObserver();
        PullObserver pullObserver1 = new PullConcreteObserver();

        PullConcreteSubject pullConcreteSubject = new PullConcreteSubject();
        pullConcreteSubject.add(pullObserver);
        pullConcreteSubject.add(pullObserver1);
        pullConcreteSubject.change("hehe");
    }
}
