package com.hxj.websimplejava;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 题目详情 一份银行流水数据，因打印模糊导致部分金额不清楚。 收入、支出、余额满足以下3条规则：
 * <ul>
 * <li>1、收入、支出、余额三列都是数字
 * <li>2、同一行收入和支出的值不能同时为非零值
 * <li>3、第N-1行余额(+第N行收入或-第N行支出)=第N行余额 程序语言： java 请按照规则编写算法，修复不清楚的值
 * </ul>
 * 输入描述： 输入数据最多25行，每行都包含四个数据，分别是：数据编号，收入、支出、余额，模糊的数据以?表示，它们之间以;隔开。
 * 以文件结尾。第一组数据为初始数据值，收入、支出、余额数据保留2位小数。 输出描述： 以输入的数据顺序输出修复后的数据。
 * </p>
 * 
 * <p>
 * 输入样例:
 * <li>流水记录ID;收入 ;支出 ;余额
 * <li>1 ;0.00;51.90 ;1945.45
 * <li>2 ;0.00;1000.00;?
 * <li>输出样例：
 * <li>流水记录ID;收入 ;支出 ;余额
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
