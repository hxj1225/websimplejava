package com.hxj.websimplejava.designpattern.observer.pull;

/**
 * ��ģ�͵ľ���۲�����
 * 
 * @author xiangjun.hexj
 * @date 2014��8��26�� ����5:59:29
 */
public class PullConcreteObserver implements PullObserver {

    private String observerStatus;

    @Override
    public void update(PullSubject pullSubject) {
        observerStatus = ((PullConcreteSubject) pullSubject).getStatus();
        System.out.println("��Ҳ����״̬����" + observerStatus);
    }

}
