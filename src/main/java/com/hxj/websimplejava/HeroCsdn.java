package com.hxj.websimplejava;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * ��Ŀ���� һ��������ˮ���ݣ����ӡģ�����²��ֽ������ ���롢֧���������������3������
 * <ul>
 * <li>1�����롢֧����������ж�������
 * <li>2��ͬһ�������֧����ֵ����ͬʱΪ����ֵ
 * <li>3����N-1�����(+��N�������-��N��֧��)=��N����� �������ԣ� java �밴�չ����д�㷨���޸��������ֵ
 * </ul>
 * ���������� �����������25�У�ÿ�ж������ĸ����ݣ��ֱ��ǣ����ݱ�ţ����롢֧������ģ����������?��ʾ������֮����;������
 * ���ļ���β����һ������Ϊ��ʼ����ֵ�����롢֧����������ݱ���2λС���� ��������� �����������˳������޸�������ݡ�
 * </p>
 * 
 * <p>
 * ��������:
 * <li>��ˮ��¼ID;���� ;֧�� ;���
 * <li>1 ;0.00;51.90 ;1945.45
 * <li>2 ;0.00;1000.00;?
 * <li>���������
 * <li>��ˮ��¼ID;���� ;֧�� ;���
 * <li>1 ;0.00;51.90 ;1945.45
 * <li>2 ;0.00;1000.00;945.45
 * </p>
 * 
 * @author xiangjun.hexj
 * 
 */
public class HeroCsdn {

	LinkedList<Demo> demoList = new LinkedList<Demo>();

	public float calculateYue(LinkedList<Demo> demoList) {
		for (Demo demo : demoList) {
			if (demo.getYue() != null) {

			}
		}
		return 0.00f;
	}

	class Demo {
		private int id;
		private BigDecimal shouru;
		private BigDecimal zhichu;
		private BigDecimal yue;

		private Demo pre;

		public boolean validate() {
			if (shouru.floatValue() == 0.00f && zhichu.floatValue() == 0.00f) {
				return false;
			} else {
				return true;
			}
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public BigDecimal getShouru() {
			return shouru;
		}

		public void setShouru(BigDecimal shouru) {
			this.shouru = shouru;
		}

		public BigDecimal getZhichu() {
			return zhichu;
		}

		public void setZhichu(BigDecimal zhichu) {
			this.zhichu = zhichu;
		}

		public BigDecimal getYue() {
			return yue;
		}

		public void setYue(BigDecimal yue) {
			this.yue = yue;
		}
	}

}
