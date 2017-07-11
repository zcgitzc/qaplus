package com.qaplus.entity.vo;

import java.io.Serializable;

public class Page implements Serializable{
	private static final long serialVersionUID = 1L;
	//分页计算的字段
	private int begin;
	private int end;
	//每页显示多少条记录
	private int length;
	private int count;
	//当前第几页
	private int current;
	
	//总记录数
	private int total;

	public Page() {
	}

	public Page(int begin, int length) {
		this.begin = begin;
		this.length = length;
		this.end = this.begin + this.length;
		this.current = (int) Math.floor((this.begin * 1.0d) / this.length) + 1;
	}

	public Page(int begin, int length, int count) {
		this(begin, length);
		this.count = count;
	}

	/**
	 * @return the begin
	 */
	public int getBegin() {
		return begin;
	}

	/**
	 * @return the end
	 */
	public int getEnd() {
		return end;
	}

	/**
	 * @param end
	 *            the end to set
	 */
	public void setEnd(int end) {
		this.end = end;
	}

	/**
	 * @param begin
	 *            the begin to set
	 */
	public void setBegin(int begin) {
		this.begin = begin;
		if (this.length != 0) {
			this.current = (int) Math.floor((this.begin * 1.0d) / this.length) + 1;
		}
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length
	 *            the length to set
	 */
	public void setLength(int length) {
		this.length = length;
		if (this.begin != 0) {
			this.current = (int) Math.floor((this.begin * 1.0d) / this.length) + 1;
		}
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(int count) {
		this.count = count;
		this.total = (int) Math.floor((this.count * 1.0d) / this.length);
		if (this.count % this.length != 0) {
			this.total++;
		}
	}

	/**
	 * @return the current
	 */
	public int getCurrent() {
		return current;
	}

	/**
	 * @param current
	 *            the current to set
	 */
	public void setCurrent(int current) {
		this.current = current;
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		if (total == 0) {
			return 1;
		}
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

}